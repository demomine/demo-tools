package com.lance.demo.java.annotation;

import com.fasterxml.jackson.annotation.JacksonAnnotation;
import com.fasterxml.jackson.annotation.JacksonAnnotationsInside;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by perdonare on 2017/5/16.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD})
@JacksonAnnotationsInside
@JacksonAnnotation
//@JsonSerialize(using = EncryptFieldSerializer.class)
public @interface PropertyEncrypt {

    EncryptMethod value() default EncryptMethod.AES;

    Class<? extends PropertyNamingStrategy> naming() default PropertyNamingStrategy.class;
}
