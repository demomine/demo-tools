package com.lance.demo.jackson.model;

import com.lance.demo.jackson.annotation.EncryptSerializer;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Created by perdonare on 2017/5/18.
 */
@Data@AllArgsConstructor
public class EncryptSerialModel2 {
    private String name;

    private int age;
    @EncryptSerializer
    private String encryptObject;
}
