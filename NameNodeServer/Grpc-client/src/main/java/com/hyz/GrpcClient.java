package com.hyz;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author HGD
 * @date 2022/8/23 0:51
 */
@SpringBootApplication
@MapperScan("com.hyz.dao.mapper")
public class GrpcClient {
    public static void main(String[] args) {
        SpringApplication.run(GrpcClient.class, args);
    }
}
