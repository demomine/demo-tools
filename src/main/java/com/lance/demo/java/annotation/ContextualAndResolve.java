package com.lance.demo.java.annotation;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.fasterxml.jackson.databind.ser.ContextualSerializer;
import com.lance.demo.java.model.EncryptObject;

import java.io.IOException;

/**
 * Created by perdonare on 2017/5/17.
 */
public class ContextualAndResolve  extends JsonSerializer<EncryptObject>
        implements ContextualSerializer/*, ResolvableSerializer*/ {
    private String orgCode;
    private String productCode;
    private String bizType;
    private String name;


    public ContextualAndResolve(String orgCode, String productCode, String bizType,String name) {
        this.orgCode = orgCode;
        this.productCode = productCode;
        this.bizType = bizType;
        this.name = name;
    }

    @Override
    public void serialize(EncryptObject value, JsonGenerator gen, SerializerProvider serializers) throws IOException, JsonProcessingException {
        gen.writeString(value.getValue()+name);
    }

    @Override
    public JsonSerializer<?> createContextual(SerializerProvider prov, BeanProperty property) throws JsonMappingException {

        PropertyNamingStrategy propertyNamingStrategy = PropertyNamingStrategy.SNAKE_CASE;
        EncryptMethod encryptMethod = EncryptMethod.AES;
        PropertyEncrypt ann = null;
        JsonNaming naming = null;
        if (property != null) {
            naming = property.getAnnotation(JsonNaming.class);
            ann = property.getAnnotation(PropertyEncrypt.class);
            if (ann == null) {
                ann = property.getContextAnnotation(PropertyEncrypt.class);
            }
            if (naming == null) {
                naming = property.getContextAnnotation(JsonNaming.class);
            }
        }
        if (ann != null) {
            encryptMethod = ann.value();
        }
        if (naming != null) {
            if (naming.value() == PropertyNamingStrategy.LOWER_CAMEL_CASE.getClass()) {
                propertyNamingStrategy = PropertyNamingStrategy.LOWER_CAMEL_CASE;
            }
        }
        System.out.println("==============="+ encryptMethod.name());
        JsonSerializer jsonSerializer =  new ContextualAndResolve(orgCode,productCode,bizType,encryptMethod.name());
        return jsonSerializer;
    }
/*
    @Override
    public void resolve(SerializerProvider provider) throws JsonMappingException {
        name = orgCode + productCode + bizType;
    }*/
}
