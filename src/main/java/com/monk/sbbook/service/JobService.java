package com.monk.sbbook.service;

import com.monk.sbbook.entity.JobInfo;

import java.util.List;

/**
 * 获取定时任务信息
 */
public interface JobService {

    List<JobInfo> listJobInfo(JobInfo jobInfo,Integer pageNo, Integer pageSize);

    Long listJobInfo(JobInfo jobInfo);

}
