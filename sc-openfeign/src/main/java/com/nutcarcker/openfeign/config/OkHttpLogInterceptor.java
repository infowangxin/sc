package com.nutcarcker.openfeign.config;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

/**
 * OKHTTP LOG 拦截器
 *
 * @author wangxin65
 * @date 2022/4/25 16:54
 */
public class OkHttpLogInterceptor implements Interceptor {

    private static final Logger LOG = LoggerFactory.getLogger(OkHttpLogInterceptor.class);

    @Override
    public Response intercept(Interceptor.Chain chain) throws IOException {
        //这个chain里面包含了request和response，所以你要什么都可以从这里拿
        Request request = chain.request();

        long t1 = System.nanoTime();
        LOG.info(String.format("#==> 发送请求: %s on %s%n%s", request.url(), chain.connection(), request.headers()));

        Response response = chain.proceed(request);
        long t2 = System.nanoTime();
        LOG.info(String.format("#<== 接收响应: %s in %.1fms%n%s", response.request().url(), (t2 - t1) / 1e6d, response.headers()));
        return response;
    }
}

