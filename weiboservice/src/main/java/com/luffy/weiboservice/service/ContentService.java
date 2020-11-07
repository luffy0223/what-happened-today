package com.luffy.weiboservice.service;

import java.util.List;
import com.luffy.weiboservice.entity.Content;
public interface ContentService{

    public String getContentListFromJob(Integer jobId,List<String> contentList);

}
