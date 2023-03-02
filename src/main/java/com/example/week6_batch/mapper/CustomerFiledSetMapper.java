package com.example.week6_batch.mapper;

import com.example.week6_batch.domain.CsvEntity;
import lombok.Getter;
import lombok.Setter;
import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.FieldSet;
import org.springframework.validation.BindException;

@Getter
@Setter
public class CustomerFiledSetMapper implements FieldSetMapper<CsvEntity> {

    @Override
    public CsvEntity mapFieldSet(FieldSet fieldSet) throws BindException {
        if(fieldSet == null){
            System.out.println("파일에 널");
            return null;
        }
        System.out.println(fieldSet.getFieldCount());
        CsvEntity csvDto = CsvEntity.builder()
                .code(fieldSet.readString(0))
                .codeName(fieldSet.readString(1))
                .costResource(fieldSet.readString(2))
                .adVariable(fieldSet.readString(3))
                .campaign(fieldSet.readString(4))
                .downCampaign(fieldSet.readString(5))
                .device(fieldSet.readString(6))
                .channel(fieldSet.readString(7))
                .portal(fieldSet.readString(8))
                .name(fieldSet.readString(9))
                .brand(fieldSet.readString(10))
                .brandNumber(fieldSet.readString(11))
                .team(fieldSet.readString(12))
                .keyword(fieldSet.readString(13))
                .date(fieldSet.readString(14))
                .showCount(fieldSet.readString(15))
                .build();
        System.out.print(csvDto.getCode()+ " :  ");
        System.out.println(csvDto.getShowCount());
        return csvDto;
    }
}
