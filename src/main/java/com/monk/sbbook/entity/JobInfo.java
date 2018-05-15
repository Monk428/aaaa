package com.monk.sbbook.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "qrtz_job_details")
public class JobInfo {
    private String JOB_NAME;
    private String JOB_GROUP;
    private String JOB_CLASS_NAME;
}
