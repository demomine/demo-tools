package com.lance.demo.java.model;

import com.fasterxml.jackson.annotation.JsonRawValue;
import lombok.Data;

/**
 * Created by perdonare on 2017/5/15.
 */
@Data
public class JsonRawValueModel {
    private String name;

    public JsonRawValueModel(String name) {
        this.name = name;
    }
    @JsonRawValue
    private String json;
}
