package com.lance.demo.java.model;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

/**
 * Created by perdonare on 2017/5/16.
 */
@Data
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class PayModel {
    private String transNo;
    private String transMoney;
    private String toAccNo;
    private String toAccName;
    private String toBankName;
    private String toProName;
    private String toCityName;
    private String toAccDept;
    private String transCardId;
    private String transMobile;
    private String transSummary;
}
