package com.lance.demo.java.model;

import com.fasterxml.jackson.annotation.JsonRootName;
import lombok.Data;

/**
 * Created by perdonare on 2017/5/15.
 */
@Data
@JsonRootName(value = "root")
public class JsonRootModel {
    public JsonRootModel(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    private int id;
    private String name;
    private int age;
}
