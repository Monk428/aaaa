package com.monk.sbbook.dao;

import com.monk.sbbook.entity.JobAndTrigger;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

//public interface JobAndTriggerMapper extends JpaRepository<JobAndTrigger, Long> {
////	@Query("SELECT qrtz_job_details.JOB_NAME,qrtz_job_details.JOB_GROUP,qrtz_job_details.JOB_CLASS_NAME,qrtz_triggers.TRIGGER_NAME,qrtz_triggers.TRIGGER_GROUP,qrtz_cron_triggers.CRON_EXPRESSION,qrtz_cron_triggers.TIME_ZONE_ID FROM qrtz_job_details JOIN qrtz_triggers JOIN qrtz_cron_triggers ON qrtz_job_details.JOB_NAME = qrtz_triggers.JOB_NAME AND qrtz_triggers.TRIGGER_NAME = qrtz_cron_triggers.TRIGGER_NAME AND qrtz_triggers.TRIGGER_GROUP = qrtz_cron_triggers.TRIGGER_GROUP")
//	@Query("SELECT qrtz_job_details.JOB_NAME From qrtz_job_details")
//	List<JobAndTrigger> getJobAndTriggerDetails();
//
//}

public interface JobAndTriggerMapper {

}