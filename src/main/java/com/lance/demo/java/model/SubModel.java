package com.lance.demo.java.model;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Created by perdonare on 2017/5/18.
 */
@Data
@AllArgsConstructor
// @JsonTypeInfo(use=JsonTypeInfo.Id.CLASS, include=JsonTypeInfo.As.PROPERTY, property="data")
public class SubModel extends CommonModel {
    private String name;
    private int age;

}
