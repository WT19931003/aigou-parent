package cn.wutao.aigou;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableEurekaClient
@EnableZuulProxy //开启网关
public class ZuulEurekaClientApplication9527 {
    public static void main(String[] args) {
        SpringApplication.run(ZuulEurekaClientApplication9527.class);
    }
}
