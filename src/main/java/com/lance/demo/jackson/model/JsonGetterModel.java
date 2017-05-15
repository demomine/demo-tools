package com.lance.demo.jackson.model;

import com.fasterxml.jackson.annotation.JsonGetter;

/**
 * Created by perdonare on 2017/5/15.
 */
public class JsonGetterModel {
    public JsonGetterModel(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int id;
    private String name;

    @JsonGetter("name")
    public String getTheName() {
        return name;
    }
}
