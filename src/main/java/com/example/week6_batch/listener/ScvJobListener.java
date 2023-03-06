package com.example.week6_batch.listener;

import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.stereotype.Component;

import javax.batch.api.listener.JobListener;

@Component
public class ScvJobListener implements JobExecutionListener {

    public static int sum= 0;

    @Override
    public void beforeJob(JobExecution jobExecution) {

    }

    @Override
    public void afterJob(JobExecution jobExecution) {
        //잡 컨텍스트에다 값 넣기.
        System.out.println("sum : " + sum);
        System.out.println("afterJobafterJobafterJobafterJobafterJobafterJobafterJobafterJobafterJob");
    }
}
