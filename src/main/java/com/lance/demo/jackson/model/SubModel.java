package com.lance.demo.jackson.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
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
