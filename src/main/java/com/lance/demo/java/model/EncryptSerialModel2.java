package com.lance.demo.java.model;

import com.lance.demo.java.annotation.EncryptSerializer;
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
