package com.luffy.weiboservice.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Content {
    private Integer contentId;

    private String value;

    private Integer rank;

    private String hot;

    private Integer jobId;
}