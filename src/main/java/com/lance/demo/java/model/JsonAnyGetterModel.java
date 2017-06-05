package com.lance.demo.java.model;

import com.fasterxml.jackson.annotation.JsonAnyGetter;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by perdonare on 2017/5/15.
 */
public class JsonAnyGetterModel {

    public JsonAnyGetterModel(String name) {
        this.name = name;
    }

    public String name;
    private Map<String, String> properties = new HashMap<>();

    @JsonAnyGetter
    public Map<String, String> getProperties() {
        return properties;
    }
}
