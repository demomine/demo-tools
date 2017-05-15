package com.lance.demo.jackson.model;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;

/**
 * Created by perdonare on 2017/5/15.
 */
@Data
//@JsonPropertyOrder({"age","id","name"})
@JsonPropertyOrder(alphabetic = true)
public class JsonOrderModel {
    public JsonOrderModel(int id, String name,int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }


    private int id;
    private String name;
    private int age;

}
