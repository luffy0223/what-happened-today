package com.luffy.weiboservice;

import com.luffy.weiboservice.Entity.Entry;
import org.jsoup.Connection;
import org.jsoup.select.Elements;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.jsoup.Jsoup;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class WeiboserviceApplication {

    public static void main(String[] args) throws IOException {
        List<Entry> list = new ArrayList<>();
        Connection.Response response = Jsoup.connect("https://s.weibo.com/top/summary")
                .method(Connection.Method.GET)
                .userAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/70.0.3538.77 Safari/537.36")
                .header("Host", "s.weibo.com")
                .header("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8")
                .header("Accept-Language", "zh-CN,zh;q=0.9")
                .execute();
        response.parse().getElementsByClass("td-02")
                .stream()
                .skip(1)
                .forEach(element -> {
                    Elements aTag = element.getElementsByTag("a");
                    Elements spanTag = element.getElementsByTag("span");
                    Entry entry = new Entry();
                    entry.setHot(Integer.parseInt(spanTag.text()));
                    entry.setValue(aTag.text());
                    list.add(entry);
                });
        System.out.println(list);
        SpringApplication.run(WeiboserviceApplication.class, args);
    }

}
