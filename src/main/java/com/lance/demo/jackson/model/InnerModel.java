package com.lance.demo.jackson.model;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Created by perdonare on 2017/5/17.
 */
@Data
@AllArgsConstructor
public class InnerModel{
    private String innerName;

    private int innerAge;
}