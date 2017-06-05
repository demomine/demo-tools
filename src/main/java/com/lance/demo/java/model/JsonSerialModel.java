package com.lance.demo.java.model;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.lance.demo.java.JsonCustomerContentSerialize;
import com.lance.demo.java.JsonCustomerSerialize;
import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * Created by perdonare on 2017/5/15.
 */
@Data
public class JsonSerialModel {
    public JsonSerialModel(String name, Date birthday,List<String> names) {
        this.birthday = birthday;
        this.name = name;
        this.names = names;
    }

    private String name;
    @JsonSerialize(using = JsonCustomerSerialize.class)
    private Date birthday;
    @JsonSerialize(keyUsing = JsonCustomerContentSerialize.class)
    private List<String> names;
}
