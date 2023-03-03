package com.example.week6_batch.job;

import com.example.week6_batch.domain.CsvEntity;
import com.example.week6_batch.domain.TestCSVEntity;
import com.example.week6_batch.mapper.CustomerFiledSetMapper;
import com.example.week6_batch.mapper.DefaultLineMapper;
import com.example.week6_batch.process.CsvProcesser;
import lombok.RequiredArgsConstructor;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.JobScope;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.database.builder.JdbcBatchItemWriterBuilder;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

import javax.sql.DataSource;

@Configuration
@RequiredArgsConstructor
public class CSVChunkJobConfig {

    private final JobBuilderFactory jobBuilderFactory;
    private final StepBuilderFactory stepBuilderFactory;
    private final DataSource dataSource; // DataSource DI
    private final CsvProcesser csvProcesser;

    @Bean
    public Job CSVJob(){
        return this.jobBuilderFactory.get("csvJob")
                .start(step1())
//                .incrementer(new CustomJobParametersIncrementer())
                .build();
    }

//    @JobScope
    @Bean
    public Step step1() {
        return stepBuilderFactory.get("step1")
                .<CsvEntity, CsvEntity>chunk(10)
                .reader(itemReader())
                .processor(csvProcesser)
                .writer(itemWriter())
                .build();
    }

    @Bean
    public ItemWriter<? super TestCSVEntity> itemWriter(){
        return new JdbcBatchItemWriterBuilder<TestCSVEntity>()
                .dataSource(dataSource)
                .sql("insert into csv_entity(code, code_name, cost_resource, ad_variable, campaign, down_campaign, device, channel, portal, name, brand, brand_number, team, keyword, date, show_count) values (:code, :codeName, :costResource, :adVariable, :campaign, :downCampaign, :device, :channel, :portal, :name, :brand, :brandNumber, :team, :keyword, :date, :showCount) ") //insert into CSV_TEST values(1);
                .beanMapped()
                .build();
    }

    //TODO 시스템 지우기, 잡 파라미터 받아오기, 프로세서 빼기, 매퍼 다른 방법으로
//    @Bean
//    public ItemReader itemReader(){
//        FlatFileItemReader<CsvEntity> itemReader = new FlatFileItemReader<>();
//        itemReader.setResource(new ClassPathResource("/itemsample/sample.csv"));
//
//
//        /* DefaultLineMapper */
//        DefaultLineMapper<CsvEntity> lineMapper = new DefaultLineMapper<>();
//        lineMapper.setLineTokenizer(new DelimitedLineTokenizer());
//        lineMapper.setFieldSetMapper(new CustomerFiledSetMapper()); /* filedSetMapper */
//
//        itemReader.setLineMapper(lineMapper);
//        itemReader.setLinesToSkip(1); // 첫번째 row 건너뜀
//        itemReader.setStrict(false);
//
//        return itemReader;
//    }
    @Bean
    public FlatFileItemReader itemReader() {
        return new FlatFileItemReaderBuilder<CsvEntity>()
                .name("CsvEntity")
                .resource(new ClassPathResource("/itemsample/sample.csv"))
                .strict(false)
                .fieldSetMapper(new BeanWrapperFieldSetMapper<>())
                .targetType(CsvEntity.class)
                .linesToSkip(1)
                .delimited()
                .names("code", "codeName", "costResource", "adVariable", "campaign", "downCampaign", "device", "channel", "portal", "name", "brand", "brandNumber", "team", "keyword", "date", "showCount")
                .build();
    }

}
