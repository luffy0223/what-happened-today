package com.luffy.weiboservice.service;

import com.luffy.weiboservice.entity.Content;
import com.luffy.weiboservice.mapper.ContentMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ContentServiceImpl implements ContentService{

    @Resource
    private ContentMapper contentMapper;



    @Override
    public String getContentListFromJob(Integer jobId,List<String> contentList){
        List<Content> contentResultList = contentList.stream().map(webValue->{
            Integer rank = contentList.indexOf(webValue);
            String hot = "top";
            String value = webValue;
            for(int i = webValue.length()-1;i>=0;i--){
                if(webValue.charAt(i)==' '){
                    hot = webValue.substring(i);
                    value = webValue.substring(0,i);
                    break;
                }
            }
            Content content = new Content();
            content.setHot(hot);
            content.setJobId(jobId);
            content.setRank(rank);
            content.setValue(value);
            return content;
        }).collect(Collectors.toList());
        contentMapper.batchInsert(contentResultList);
        return "done";
    }

}
