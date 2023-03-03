package com.example.week6_batch.process;

import com.example.week6_batch.domain.CsvEntity;

import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@StepScope
@Component
public class CsvProcesser implements ItemProcessor<CsvEntity, CsvEntity> {


    @Value("#{jobParameters[date]}")
    private String date;

    @Override
    public CsvEntity process( CsvEntity item) throws Exception {
//        System.out.println("item : "+ item.getShowCount());
        Long num = Long.parseLong(item.getShowCount());
        if(!item.getDate().equals(date)){
            return null;
        }
        if(num == 0L){
            return null;
        }
        return item;
    }
}
