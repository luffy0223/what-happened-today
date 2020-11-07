package com.luffy.weiboservice.job;


import com.luffy.weiboservice.entity.JobInfo;
import com.luffy.weiboservice.mapper.JobInfoMapper;
import com.luffy.weiboservice.service.ContentService;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.select.Elements;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Component
public class WebContentJob {

    @Resource
    JobInfoMapper jobInfoMapper;


    @Resource
    ContentService contentService;

    @Scheduled(fixedRate = 1000*60)
    public void weiboContentJob(){

        Connection.Response response = null;
        try {
            response = Jsoup.connect("https://s.weibo.com/top/summary")
                    .method(Connection.Method.GET)
                    .userAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/70.0.3538.77 Safari/537.36")
                    .header("Host", "s.weibo.com")
                    .header("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8")
                    .header("Accept-Language", "zh-CN,zh;q=0.9")
                    .execute();
        } catch (IOException e) {
            e.printStackTrace();
        }
        JobInfo jobInfo=  new JobInfo();
        jobInfo.setJobDate(LocalDate.now().toString());
        jobInfo.setJobTime(LocalTime.now().toString());
        jobInfoMapper.insert(jobInfo);
        Integer jobId= jobInfo.getJobId();
        System.out.println("jobId:" + jobId);
        List<String> contentList = null;
        try {
            contentList = response.parse().getElementsByClass("td-02").eachText();

        } catch (IOException e) {
            e.printStackTrace();
        }
        String s=  contentService.getContentListFromJob(jobId,contentList);
        System.out.println(s);

    }




}
