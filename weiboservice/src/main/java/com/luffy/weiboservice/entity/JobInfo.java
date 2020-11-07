package com.luffy.weiboservice.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobInfo {
    private Integer jobId;

    private String jobDate;

    private String jobTime;
}