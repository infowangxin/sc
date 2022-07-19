package com.nutcracker.openfeign.client.api;

import com.nutcracker.openfeign.client.response.BaseResponse;
import com.nutcracker.openfeign.client.response.DemoApi;
import com.nutcracker.openfeign.constant.ProviderConstant;
import com.nutcracker.openfeign.exception.BusinessException;
import com.nutcracker.openfeign.fallback.DemoApiFeignClientFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 示例接口
 *
 * @author 胡桃夹子
 * @date 2022-04-20 21:45
 */
@Service
@FeignClient(name = ProviderConstant.PROVIDER, fallback = DemoApiFeignClientFallback.class)
public interface DemoApiFeignClient {

    @GetMapping("/demoApi/getDiff")
    public BaseResponse<DemoApi> getDiff(@RequestParam("value") Integer value);

    @GetMapping("/demoApi/getMessage")
    public BaseResponse<DemoApi> getMessage(@RequestParam("value") Integer value) throws BusinessException;


}
