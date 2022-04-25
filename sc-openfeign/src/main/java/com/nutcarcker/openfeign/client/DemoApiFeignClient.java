package com.nutcarcker.openfeign.client;

import com.nutcarcker.openfeign.constant.ProviderConstant;
import com.nutcarcker.openfeign.entity.AppEntity;
import com.nutcarcker.openfeign.exception.BusinessException;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 示例接口
 *
 * @author wangxin65
 * @date 2022-04-20 21:45
 */
@Service
@FeignClient(ProviderConstant.PROVIDER)
public interface DemoApiFeignClient {

    @GetMapping("/demoApi/getDiff")
    public AppEntity getDiff(@RequestParam("value") Integer value);

    @GetMapping("/demoApi/getMessage")
    public AppEntity getMessage(@RequestParam("value") Integer value) throws BusinessException;


}
