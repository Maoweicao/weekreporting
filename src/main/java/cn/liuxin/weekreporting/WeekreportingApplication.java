package cn.liuxin.weekreporting;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class WeekreportingApplication {

    public static void main(String[] args) {
        SpringApplication.run(WeekreportingApplication.class, args);
    }

}
