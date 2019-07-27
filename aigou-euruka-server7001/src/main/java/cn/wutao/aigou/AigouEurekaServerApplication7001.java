package cn.wutao.aigou;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * 注册中心服务端
 */
@SpringBootApplication
@EnableEurekaServer
public class AigouEurekaServerApplication7001 {
    public static void main(String[] args) {
        SpringApplication.run(AigouEurekaServerApplication7001.class);
    }
}
