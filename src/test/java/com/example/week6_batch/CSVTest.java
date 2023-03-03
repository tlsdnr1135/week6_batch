package com.example.week6_batch;

import com.example.week6_batch.job.CSVChunkJobConfig;
import com.example.week6_batch.jobparameter.CustomJobParametersIncrementer;
import org.junit.Assert;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.test.JobLauncherTestUtils;
import org.springframework.batch.test.context.SpringBatchTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBatchTest
@SpringBootTest(classes={CSVChunkJobConfig.class, TestBatchConfig.class})
public class CSVTest {

    @Autowired
    private JobLauncherTestUtils jobLauncherTestUtils;

    @Test
    @DisplayName("잡_테스트")
    public void simple_job_test() throws Exception{

        //given
//        JobParameters jobParameters = new JobParametersBuilder()
//                .addString("Datedate", format.format(new Date()))
//
//                .toJobParameters();

        //when
        JobExecution jobExecution = jobLauncherTestUtils.launchJob(new CustomJobParametersIncrementer().getNext(null));

        //then
        Assert.assertEquals(jobExecution.getStatus(), BatchStatus.COMPLETED);

    }
//csv파일 읽고 -> 데이터베이스에 쓰기 , 청크단위로, 프로세서를 쓰기(원하는 항목 가공), 테스트 코드에서 실행 후 데베에 값이 들어가는 것 까지
}
