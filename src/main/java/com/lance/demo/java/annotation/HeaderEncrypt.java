package com.lance.demo.java.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by perdonare on 2017/5/16.
 */
@Target({ElementType.ANNOTATION_TYPE, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface HeaderEncrypt {
    String value();

    EncryptMethod method() default EncryptMethod.AES;

    EncryptType type() default EncryptType.JSON;

    String[] encryptField() default {};
}
