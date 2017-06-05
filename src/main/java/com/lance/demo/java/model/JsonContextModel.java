package com.lance.demo.java.model;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Created by perdonare on 2017/5/17.
 */
@Data@AllArgsConstructor
public class JsonContextModel {

    private String name;

    private int age;

    private EncryptObject encryptObject;
}
