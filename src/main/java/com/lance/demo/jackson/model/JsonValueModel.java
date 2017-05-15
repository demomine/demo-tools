package com.lance.demo.jackson.model;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Data;

/**
 * Created by perdonare on 2017/5/15.
 */
@Data
public class JsonValueModel {
    public JsonValueModel(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }


    private int id;
    @JsonValue
    private String name;
    //@JsonValue
    private int age;
}
