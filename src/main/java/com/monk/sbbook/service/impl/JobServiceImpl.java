package com.monk.sbbook.service.impl;

import com.monk.sbbook.entity.JobInfo;
import com.monk.sbbook.service.DynamicQuery;
import com.monk.sbbook.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

@Service("jobService")
public class JobServiceImpl implements JobService {

    @Autowired
    private DynamicQuery dynamicQuery;

    @Override
    public List<JobInfo> listJobInfo(JobInfo jobInfo, Integer pageNo, Integer pageSize) {
        StringBuffer nativeSql = new StringBuffer();
        nativeSql.append("SELECT job.JOB_NAME as jobName,job.JOB_GROUP as jobGroup,job.DESCRIPTION as description,job.JOB_CLASS_NAME as jobClassName,");
        nativeSql.append("cron.CRON_EXPRESSION as cronExpression,tri.TRIGGER_NAME as triggerName,tri.TRIGGER_STATE as triggerState,");
        nativeSql.append("job.JOB_NAME as oldJobName,job.JOB_GROUP as oldJobGroup ");
        nativeSql.append("FROM qrtz_job_details AS job LEFT JOIN qrtz_triggers AS tri ON job.JOB_NAME = tri.JOB_NAME ");
        nativeSql.append("LEFT JOIN qrtz_cron_triggers AS cron ON cron.TRIGGER_NAME = tri.TRIGGER_NAME ");
        nativeSql.append("WHERE tri.TRIGGER_TYPE = 'CRON'");

        Object[] params = new Object[]{};
        if (!StringUtils.isEmpty(jobInfo.getJobName())) {
            nativeSql.append(" AND job.JOB_NAME = ?");
            params = new Object[]{jobInfo.getJobName()};
        }

        return dynamicQuery.nativeQueryListModel(JobInfo.class, nativeSql.toString(), params);
    }

    @Override
    public Long listJobInfo(JobInfo jobInfo) {
        StringBuffer nativeSql = new StringBuffer();
        nativeSql.append("SELECT COUNT(*)");
        nativeSql.append("FROM qrtz_job_details AS job LEFT JOIN qrtz_triggers AS tri ON job.JOB_NAME = tri.JOB_NAME ");
        nativeSql.append("LEFT JOIN qrtz_cron_triggers AS cron ON cron.TRIGGER_NAME = tri.TRIGGER_NAME ");
        nativeSql.append("WHERE tri.TRIGGER_TYPE = 'CRON'");
        return dynamicQuery.nativeQueryCount(nativeSql.toString(), new Object[]{});
    }

}
