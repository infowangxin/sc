package com.nutcarcker.openfeign.config;

import okhttp3.ConnectionPool;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.concurrent.TimeUnit;

/**
 * okhttp config
 *
 * @author wangxin65
 * @date 2022-04-24 19:48
 */
@Configuration
public class OkHttpConfig {

    /**
     * 忽略证书校验
     *
     * @return 证书信任管理器
     */
    @Bean
    public X509TrustManager x509TrustManager() {
        return new X509TrustManager() {
            @Override
            public void checkClientTrusted(X509Certificate[] x509Certificates, String s) throws CertificateException {
            }

            @Override
            public void checkServerTrusted(X509Certificate[] x509Certificates, String s) throws CertificateException {
            }

            @Override
            public X509Certificate[] getAcceptedIssuers() {
                return new X509Certificate[0];
            }
        };
    }

    /**
     * 信任所有 SSL 证书
     *
     * @return
     */
    @Bean
    public SSLSocketFactory sslSocketFactory() {
        try {
            TrustManager[] trustManagers = new TrustManager[]{x509TrustManager()};
            SSLContext sslContext = SSLContext.getInstance("SSL");
            sslContext.init(null, trustManagers, new SecureRandom());
            return sslContext.getSocketFactory();
        } catch (NoSuchAlgorithmException | KeyManagementException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 连接池配置
     *
     * @return 连接池
     */
    @Bean
    public ConnectionPool pool() {
        // 最大连接数、连接存活时间、存活时间单位（分钟）
        // max-connections: 200 # 默认值
        // max-connections-per-route: 50 # 默认值
        return new ConnectionPool(200, 5, TimeUnit.MINUTES);
    }

    @Bean
    public okhttp3.OkHttpClient okHttpClient() {
        return new okhttp3.OkHttpClient.Builder()
                // 读取超时时间
                .readTimeout(10, TimeUnit.SECONDS)
                // 连接超时时间
                .connectTimeout(10, TimeUnit.SECONDS)
                // 写超时时间
                .writeTimeout(10, TimeUnit.SECONDS)
                // 设置连接池
                //.connectionPool(new ConnectionPool())
                .connectionPool(pool())
                // 设置拦截器
                .addInterceptor(new OkHttpLogInterceptor())
                .build();
    }


    /**
     * 信任所有主机名
     *
     * @return 主机名校验
     */
    @Bean
    public HostnameVerifier hostnameVerifier() {
        return (s, sslSession) -> true;
    }
}
