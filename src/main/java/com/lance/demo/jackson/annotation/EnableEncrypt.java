package com.lance.demo.jackson.annotation;

import com.fasterxml.jackson.annotation.JacksonAnnotationsInside;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by perdonare on 2017/5/16.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
@JacksonAnnotationsInside
@JsonSerialize(using = EncryptFieldSerializer.class)
public @interface EnableEncrypt {

    boolean value() default true;
}
