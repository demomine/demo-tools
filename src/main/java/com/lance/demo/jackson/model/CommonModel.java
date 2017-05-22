package com.lance.demo.jackson.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Data;

/**
 * Created by perdonare on 2017/5/17.
 */
@Data
//@JsonTypeInfo(use= JsonTypeInfo.Id.CLASS, include= JsonTypeInfo.As.PROPERTY, property="data")
public class CommonModel {
    private String orgCode;
    private String productCode;
}
