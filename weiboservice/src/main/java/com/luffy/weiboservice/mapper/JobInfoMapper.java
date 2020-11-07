package com.luffy.weiboservice.mapper;

import com.luffy.weiboservice.entity.JobInfo;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface JobInfoMapper {
    int deleteByPrimaryKey(Integer jobId);

    int insert(JobInfo record);

    int insertSelective(JobInfo record);

    JobInfo selectByPrimaryKey(Integer jobId);

    int updateByPrimaryKeySelective(JobInfo record);

    int updateByPrimaryKey(JobInfo record);

    int updateBatch(List<JobInfo> list);

    int batchInsert(@Param("list") List<JobInfo> list);
}