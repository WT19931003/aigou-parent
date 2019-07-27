package cn.wutao.aigou;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableEurekaClient
public class PlatEurekaClientApplication6000 {
    public static void main(String[] args) {
        SpringApplication.run(PlatEurekaClientApplication6000.class);
    }
}
