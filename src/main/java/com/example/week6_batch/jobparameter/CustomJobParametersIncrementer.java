package com.example.week6_batch.jobparameter;

import io.micrometer.core.lang.Nullable;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.JobParametersIncrementer;

import java.text.SimpleDateFormat;
import java.util.Date;

public class CustomJobParametersIncrementer implements JobParametersIncrementer {

    public static final SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd-hhmmss");

    @Override
    public JobParameters getNext(@Nullable JobParameters parameters) {
        String id = format.format(new Date());
        return new JobParametersBuilder().addString("Datedate",id).toJobParameters();
    }
}
