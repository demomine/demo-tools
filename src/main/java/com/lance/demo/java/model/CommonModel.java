package com.lance.demo.java.model;

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
