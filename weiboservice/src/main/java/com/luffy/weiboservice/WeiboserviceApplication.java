package com.luffy.weiboservice;

import com.luffy.weiboservice.entity.Entry;
import org.jsoup.Connection;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.jsoup.Jsoup;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
@EnableScheduling
@SpringBootApplication
@MapperScan("com.luffy.weiboservice.mapper")
public class WeiboserviceApplication {

    public static void main(String[] args) throws IOException {

        SpringApplication.run(WeiboserviceApplication.class, args);
    }

}
