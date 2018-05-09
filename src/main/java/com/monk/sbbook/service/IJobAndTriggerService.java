package com.monk.sbbook.service;


import com.github.pagehelper.PageInfo;
import com.monk.sbbook.entity.JobAndTrigger;

public interface IJobAndTriggerService {
	public PageInfo<JobAndTrigger> getJobAndTriggerDetails(int pageNum, int pageSize);
}
