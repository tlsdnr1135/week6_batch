package com.example.week6_batch.launcher;


import com.example.week6_batch.job.CSVChunkJobConfig;
import lombok.RequiredArgsConstructor;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class JobRunner implements ApplicationRunner {

    @Autowired
    private JobLauncher jobLauncher;

//    @Autowired
//    private Job job;
    private final CSVChunkJobConfig csvChunkJobConfig;

    @Override
    public void run(ApplicationArguments args) throws Exception {
//        SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
//        format.format(new Date());
//        Date  date = new Date();
        //TODO 물어보기 데이트형식으로 어캐하나?
        JobParameters jobParameters = new JobParametersBuilder().addString("date","20220515").toJobParameters();
        jobLauncher.run(csvChunkJobConfig.CSVJob(),jobParameters);
    }
}
