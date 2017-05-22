package com.lance.demo.jackson.model;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.lance.demo.jackson.annotation.EnableEncrypt;
import com.lance.demo.jackson.annotation.EncryptMethod;
import com.lance.demo.jackson.annotation.EncryptSerializer;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Created by perdonare on 2017/5/18.
 */
@Data@AllArgsConstructor@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
@EnableEncrypt
public class EncryptSerialModel {
    private String name;

    private int age;
    @EncryptSerializer(EncryptMethod.DES)
    private String encryptObject;
}
