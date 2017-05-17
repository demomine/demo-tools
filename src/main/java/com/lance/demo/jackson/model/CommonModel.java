package com.lance.demo.jackson.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

/**
 * Created by perdonare on 2017/5/17.
 */
@Data
public class CommonModel {
    @JsonIgnore
    private String orgCode;
    @JsonIgnore
    private String productCode;
}
