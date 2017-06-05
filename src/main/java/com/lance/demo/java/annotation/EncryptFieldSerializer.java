package com.lance.demo.java.annotation;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.fasterxml.jackson.databind.ser.ContextualSerializer;
import com.lance.demo.java.EncryptSerializerProvider;

import java.io.IOException;

/**
 * Created by perdonare on 2017/5/16.
 */
public class EncryptFieldSerializer extends JsonSerializer<Object>  implements ContextualSerializer {
    protected final static ObjectMapper objectMapper = new ObjectMapper();
    protected final EncryptMethod _encryptMethod;
    protected final PropertyNamingStrategy propertyNamingStrategy;
    private String orgCode;
    private String productCode;

    public EncryptFieldSerializer() {
        this(null, null, null, null);
    }

    public EncryptFieldSerializer(String orgCode,String productCode,EncryptMethod _encryptMethod, PropertyNamingStrategy propertyNamingStrategy) {
        this._encryptMethod = _encryptMethod;
        this.propertyNamingStrategy = propertyNamingStrategy;
        objectMapper.setPropertyNamingStrategy(propertyNamingStrategy);
        objectMapper.configure(SerializationFeature.WRAP_ROOT_VALUE,true);
        this.orgCode = orgCode;
        this.productCode = productCode;
    }



    @Override
    public void serialize(Object value, JsonGenerator gen, SerializerProvider serializers) throws IOException{
        if (serializers instanceof EncryptSerializerProvider) {
            String merchantNo = ((EncryptSerializerProvider) serializers).getMerchantNo();
            System.out.println("===========merchantNo"+ merchantNo);
        }
        gen.writeString(value.toString()+orgCode+productCode);
    }

    @Override
    public JsonSerializer<?> createContextual(SerializerProvider prov, BeanProperty property) throws JsonMappingException {
        PropertyNamingStrategy propertyNamingStrategy = PropertyNamingStrategy.SNAKE_CASE;
        EncryptMethod encryptMethod = EncryptMethod.AES;
        EncryptSerializer ann = null;
        JsonNaming naming = null;
        if (property != null) {
            naming = property.getAnnotation(JsonNaming.class);
            ann = property.getAnnotation(EncryptSerializer.class);
            if (ann == null) {
                ann = property.getContextAnnotation(EncryptSerializer.class);
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
        System.out.println("=============" + encryptMethod);
        return new EncryptFieldSerializer(orgCode,productCode,encryptMethod,propertyNamingStrategy);
    }

}
