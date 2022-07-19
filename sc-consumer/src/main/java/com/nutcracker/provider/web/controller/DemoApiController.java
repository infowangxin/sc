package com.nutcracker.provider.web.controller;

import com.nutcracker.openfeign.client.api.DemoApiFeignClient;
import com.nutcracker.openfeign.client.response.BaseResponse;
import com.nutcracker.openfeign.client.response.DemoApi;
import com.nutcracker.openfeign.exception.BusinessException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 胡桃夹子
 * @date 2022-01-21 18:17
 */
@RestController
public class DemoApiController {

    private static final Logger LOG = LoggerFactory.getLogger(DemoApiController.class);

    @Autowired
    private DemoApiFeignClient demoApiFeignClient;

    @GetMapping("diff/{input}")
    public BaseResponse<DemoApi> diff(@PathVariable Integer input) {
        LOG.info("# diff input={}", input);
        BaseResponse<DemoApi> result = null;
        try {
            result = demoApiFeignClient.getDiff(input);
        } catch (BusinessException e) {
            result = new BaseResponse<>(500, e.getMessage());
            LOG.error("# BusinessException {}", result);
        } catch (Throwable e) {
            result = new BaseResponse<>(500, e.getMessage());
            LOG.error("# Exception {}", result);
        }
        LOG.debug("# {}", result);
        return result;
    }

    @GetMapping("msg/{input}")
    public BaseResponse<DemoApi> msg(@PathVariable Integer input) {
        LOG.info("# msg input={}", input);
        BaseResponse<DemoApi> result;
        try {
            result = demoApiFeignClient.getMessage(input);
        } catch (BusinessException e) {
            result = new BaseResponse<>(500, e.getMessage());
            LOG.error("# BusinessException {}", result);
        } catch (Throwable e) {
            result = new BaseResponse<>(500, e.getMessage());
            LOG.error("# Exception {}", result);
        }
        return result;
    }

}
