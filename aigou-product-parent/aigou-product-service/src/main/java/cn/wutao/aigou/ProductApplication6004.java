package cn.wutao.aigou;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableEurekaClient
@MapperScan(basePackages = "cn.wutao.aigou.mapper")
@EnableFeignClients(basePackages = "cn.wutao.aigou.client")
@EnableSwagger2
public class ProductApplication6004 {
    public static void main(String[] args) {
        SpringApplication.run(ProductApplication6004.class,args);
    }
}
