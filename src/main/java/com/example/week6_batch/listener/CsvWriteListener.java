package com.example.week6_batch.listener;

import com.example.week6_batch.domain.CsvEntity;
import org.springframework.batch.core.ItemWriteListener;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobInstance;
import org.springframework.batch.core.annotation.AfterWrite;
import org.springframework.batch.core.scope.context.JobContext;
import org.springframework.batch.item.ExecutionContext;
import org.springframework.stereotype.Component;

import java.util.List;

import static com.example.week6_batch.listener.ScvJobListener.sum;

@Component
public class CsvWriteListener implements ItemWriteListener {
    //클래스로 상속.
    @Override
    public void beforeWrite(List items) {

    }

    //
    @Override
    public void afterWrite(List items) {
        List<CsvEntity> csvEntities = items;

        int num = csvEntities.stream().map(s -> s.getShowCount()).mapToInt(Integer::parseInt).sum();
        System.out.println(num);
        sum += num;
    }

    @Override
    public void onWriteError(Exception exception, List items) {

    }
}
