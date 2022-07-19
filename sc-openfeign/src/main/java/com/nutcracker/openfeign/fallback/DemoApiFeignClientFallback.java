package com.nutcracker.openfeign.fallback;

import com.nutcracker.openfeign.client.api.DemoApiFeignClient;
import com.nutcracker.openfeign.client.response.DemoApi;
import com.nutcracker.openfeign.client.response.BaseResponse;
import com.nutcracker.openfeign.exception.BusinessException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 示例接口 溶断处理
 *
 * @author 胡桃夹子
 * @date 2022-05-03 16:36
 */
@Component
public class DemoApiFeignClientFallback implements DemoApiFeignClient {

    private static final Logger LOG = LoggerFactory.getLogger(DemoApiFeignClientFallback.class);

    @Override
    public BaseResponse<DemoApi> getDiff(Integer value) {
        LOG.error("# 请求异常 value=[{}]", value);
        return new BaseResponse<>(500, "from DemoApiFallback");
    }

    @Override
    public BaseResponse<DemoApi> getMessage(Integer value) throws BusinessException {
        LOG.error("# 请求异常 value=[{}]", value);
        return new BaseResponse<>(500, "from DemoApiFallback");
    }
}
