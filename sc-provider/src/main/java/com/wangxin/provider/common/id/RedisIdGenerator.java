package com.wangxin.provider.common.id;

/** 
 * @Description 利用redis获取全局唯一ID：</br>
 * ID规则：</br>
 * <strong>1.</strong> ID的前半部分为yyyyMMddHHmmssSSS格式的17位数字</br>
 * <strong>2.</strong> ID的后半部分为由length(最大为8位，如果length > 8，则取8)决定，取值Redis对应Value，如果小于length所对应的数位，如果不足该数位，前面补足0
 *    例如Redis对应Value为1234，length为8，那么ID的后半部分为00001234；length为2，那么ID的后半部分为34
 * @author 王鑫 
 * @date Dec 20, 2017 10:26:59 PM  
 */
public interface RedisIdGenerator {

    /**
     * 获取全局唯一ID
     * @param name 资源名字
     * @param key 资源Key
     * @param step 递增值
     * @param length 长度
     * @return 全局唯一ID
     */
    String nextUniqueId(String name, String key, int step, int length);

    /**
     * 获取全局唯一ID
     * @param compositeKey 组合Key
     * @param step 递增值
     * @param length 长度
     * @return 全局唯一ID
     */
    String nextUniqueId(String compositeKey, int step, int length);
    
    /**
     * 获取全局唯一ID
     * @param compositeKey 组合Key
     * @return 全局唯一ID
     */
    String nextUniqueId(String compositeKey);

    /** 
     * 批量获取全局唯一ID
     * @author 王鑫
     * @param name 资源名字
     * @param key 资源Key
     * @param step 递增值
     * @param length 长度
     * @param count 批量获取数量
     * @return  全局唯一ID
     */
    String[] nextUniqueIds(String name, String key, int step, int length, int count);

    /** 
     * 批量获取全局唯一ID
     * @param compositeKey 组合Key
     * @param step 递增值
     * @param length 长度
     * @param count 批量获取数量
     * @return  全局唯一ID
     */
    String[] nextUniqueIds(String compositeKey, int step, int length, int count);
}