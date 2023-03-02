package com.example.week6_batch.domain;


import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
//@Entity
//@Table(name="csv_entity")
public class CsvEntity {

//    @Id @GeneratedValue(strategy = GenerationType.AUTO)
//    private Long id;
    private String code;
    private String codeName;
    private String costResource;
    private String adVariable;
    private String campaign;
    private String downCampaign;
    private String device;
    private String channel;
    private String portal;
    private String name;
    private String brand;
    private String brandNumber;
    private String team;
    private String keyword;
    private String date;
    private String showCount;

    @Builder

    public CsvEntity(String code, String codeName, String costResource, String adVariable, String campaign, String downCampaign, String device, String channel, String portal, String name, String brand, String brandNumber, String team, String keyword, String date, String showCount) {
        this.code = code;
        this.codeName = codeName;
        this.costResource = costResource;
        this.adVariable = adVariable;
        this.campaign = campaign;
        this.downCampaign = downCampaign;
        this.device = device;
        this.channel = channel;
        this.portal = portal;
        this.name = name;
        this.brand = brand;
        this.brandNumber = brandNumber;
        this.team = team;
        this.keyword = keyword;
        this.date = date;
        this.showCount = showCount;
    }
}
