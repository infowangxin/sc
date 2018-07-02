package com.wangxin.provider.common.id;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.script.DefaultRedisScript;
import org.springframework.data.redis.core.script.RedisScript;
import org.springframework.stereotype.Component;

@Component
public class RedisIdGeneratorImpl implements RedisIdGenerator {
    private static final Logger log = LoggerFactory.getLogger(RedisIdGeneratorImpl.class);

    private static final String DATE_FORMAT = "yyyyMMddHHmmssSSS";// id前缀
    private static final String DECIMAL_FORMAT = "00000000";// 数值格式
    private static final int MAX_BATCH_COUNT = 1000;// 批量获取ID最大个数
    private static final int step = 1;// 递增值
    private static final int length = 8;// 长度

    @Value("${spring.application.name}")
    private String prefix;// redis key固定前缀，一般用于区分应用

    @Value("${frequentLogPrint:false}")
    private Boolean frequentLogPrint;// 是否开启频率的日志打印,默认不开启

    private static RedisScript<List<Object>> redisScript;
    private static SimpleDateFormat dateFormat;
    private static DecimalFormat decimalFormat;

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @SuppressWarnings({ "unchecked", "rawtypes" })
    @PostConstruct
    public void initialize() {
        // 设定serializer
        // redisTemplate.setKeySerializer(new StringRedisSerializer());
        // redisTemplate.setValueSerializer(new GenericJackson2JsonRedisSerializer());

        // 组装redis script
        redisScript = new DefaultRedisScript(buildLuaScript(), List.class);

        // format object
        dateFormat = new SimpleDateFormat(DATE_FORMAT);
        decimalFormat = new DecimalFormat(DECIMAL_FORMAT);
    }

    /** 
     * 封装Redis Script
     * @return  Redis Script
     */
    private String buildLuaScript() {
        StringBuilder lua = new StringBuilder();
        lua.append("local incrKey = KEYS[1];");
        lua.append("\nlocal step = ARGV[1];");
        lua.append("\nlocal count;");
        lua.append("\ncount = tonumber(redis.call('incrby', incrKey, step));");
        lua.append("\nlocal now = redis.call('time');");
        lua.append("\nreturn {now[1], now[2], count}");
        return lua.toString();
    }

    /** 
     * 数值格式化成指定长度字符串，不够长度前面补“0”
     * @param key 数值
     * @param length 长度
     * @return  数值字符串
     */
    public static String formatString(long key, int length) {
        String value = String.valueOf(key);
        if (value.length() < length) {
            return decimalFormat.format(key);
        } else {
            return value.substring(value.length() - length, value.length());
        }
    }

    @Override
    public String nextUniqueId(String name, String key, int step, int length) {
        if (StringUtils.isEmpty(name)) {
            throw new RuntimeException("Name is null or empty");
        }
        if (StringUtils.isEmpty(key)) {
            throw new RuntimeException("Key is null or empty");
        }
        String compositeKey = prefix + "_" + name + "_" + key;
        return nextUniqueId(compositeKey, step, length);
    }

    @Override
    public String nextUniqueId(String compositeKey, int step, int length) {
        if (StringUtils.isEmpty(compositeKey)) {
            throw new RuntimeException("Composite key is null or empty");
        }

        List<String> keys = new ArrayList<String>();
        keys.add(compositeKey);

        List<Object> result = redisTemplate.execute(redisScript, keys, step);

        Object value1 = result.get(0);
        Object value2 = result.get(1);
        Object value3 = result.get(2);

        Date date = new Date(Long.parseLong(String.valueOf(value1)) * 1000 + Long.parseLong(String.valueOf(value2)) / 1000);

        StringBuilder builder = new StringBuilder();
        builder.append(dateFormat.format(date));
        builder.append(formatString((long) value3, length));

        String nextUniqueId = builder.toString();
        if (frequentLogPrint) {
            log.info("Next unique id is {} for key={}", nextUniqueId, compositeKey);
        }
        return nextUniqueId;
    }

    @Override
    public String nextUniqueId(String compositeKey) {
        if (StringUtils.isEmpty(compositeKey)) {
            throw new RuntimeException("Composite key is null or empty");
        }

        List<String> keys = new ArrayList<String>();
        keys.add(compositeKey);

        List<Object> result = redisTemplate.execute(redisScript, keys, step);

        Object value1 = result.get(0);
        Object value2 = result.get(1);
        Object value3 = result.get(2);

        Date date = new Date(Long.parseLong(String.valueOf(value1)) * 1000 + Long.parseLong(String.valueOf(value2)) / 1000);

        StringBuilder builder = new StringBuilder();
        builder.append(dateFormat.format(date));
        builder.append(formatString((long) value3, length));

        String nextUniqueId = builder.toString();
        if (frequentLogPrint) {
            log.info("Next unique id is {} for key={}", nextUniqueId, compositeKey);
        }
        return nextUniqueId;
    }

    @Override
    public String[] nextUniqueIds(String name, String key, int step, int length, int count) {
        if (count <= 0 || count > MAX_BATCH_COUNT) {
            throw new RuntimeException(String.format("Count can't be greater than %d or less than 0", MAX_BATCH_COUNT));
        }
        String[] nextUniqueIds = new String[count];
        for (int i = 0; i < count; i++) {
            nextUniqueIds[i] = nextUniqueId(name, key, step, length);
        }
        return nextUniqueIds;
    }

    @Override
    public String[] nextUniqueIds(String compositeKey, int step, int length, int count) {
        if (count <= 0 || count > MAX_BATCH_COUNT) {
            throw new RuntimeException(String.format("Count can't be greater than %d or less than 0", MAX_BATCH_COUNT));
        }
        String[] nextUniqueIds = new String[count];
        for (int i = 0; i < count; i++) {
            nextUniqueIds[i] = nextUniqueId(compositeKey, step, length);
        }
        return nextUniqueIds;
    }
}