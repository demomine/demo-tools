package com.lance.demo.jackson.annotation;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.fasterxml.jackson.databind.ser.ContextualSerializer;
import com.lance.demo.jackson.model.CommonModel;

import java.io.IOException;

/**
 * Created by perdonare on 2017/5/16.
 */
public class EncryptFieldSerializer extends JsonSerializer<Object>  implements ContextualSerializer {
    protected final static ObjectMapper objectMapper = new ObjectMapper();
    protected final EncryptMethod _encryptMethod;
    protected final PropertyNamingStrategy propertyNamingStrategy;

    public EncryptFieldSerializer() {
        this(null,PropertyNamingStrategy.SNAKE_CASE);
    }

    public EncryptFieldSerializer(EncryptMethod _encryptMethod, PropertyNamingStrategy propertyNamingStrategy) {
        this._encryptMethod = _encryptMethod;
        this.propertyNamingStrategy = propertyNamingStrategy;
        objectMapper.setPropertyNamingStrategy(propertyNamingStrategy);
        objectMapper.configure(SerializationFeature.WRAP_ROOT_VALUE,true);
    }



    @Override
    public void serialize(Object value, JsonGenerator gen, SerializerProvider serializers) throws IOException{
        if (value instanceof CommonModel) {
            CommonModel commonModel = (CommonModel) value;
            serializers.setAttribute("orgCode", commonModel.getOrgCode());
            serializers.setAttribute("productCode", commonModel.getProductCode());
            return;
        }
        //gen.wr
        String result = (value instanceof String) ? (String) value : objectMapper.writeValueAsString(value);
        if (_encryptMethod.equals(EncryptMethod.AES)) {
            System.out.println(result);
            result = result + serializers.getAttribute("orgCode");
        }
        gen.writeString(result);
        System.out.println("");
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
        return new EncryptFieldSerializer(encryptMethod,propertyNamingStrategy);
    }
}
