package com.lance.demo.jackson.model;

import com.lance.demo.jackson.annotation.EnableEncrypt;
import com.lance.demo.jackson.annotation.EncryptMethod;
import com.lance.demo.jackson.annotation.PropertyEncrypt;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Created by perdonare on 2017/5/17.
 */
@Data@AllArgsConstructor
public class JsonContextModel2 {

    private String name;

    private int age;
    @PropertyEncrypt(value = EncryptMethod.DES)
    private EncryptObject encryptObject;
}
