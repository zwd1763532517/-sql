package com.zwd.area;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = {"com.zwd.area.core.dao"})
public class AreaApplication {

    public static void main(String[] args) {
        SpringApplication.run(AreaApplication.class, args);
    }

}
