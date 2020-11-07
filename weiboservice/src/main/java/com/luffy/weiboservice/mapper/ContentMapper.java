package com.luffy.weiboservice.mapper;

import com.luffy.weiboservice.entity.Content;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ContentMapper {
    int deleteByPrimaryKey(Integer contentId);

    int insert(Content record);

    int insertSelective(Content record);

    Content selectByPrimaryKey(Integer contentId);

    int updateByPrimaryKeySelective(Content record);

    int updateByPrimaryKey(Content record);

    int updateBatch(List<Content> list);

    int batchInsert(@Param("list") List<Content> list);
}