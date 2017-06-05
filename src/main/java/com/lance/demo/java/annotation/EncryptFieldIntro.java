package com.lance.demo.java.annotation;

import com.fasterxml.jackson.annotation.JsonRawValue;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.introspect.Annotated;
import com.fasterxml.jackson.databind.introspect.JacksonAnnotationIntrospector;
import com.fasterxml.jackson.databind.ser.std.RawSerializer;

/**
 * Created by perdonare on 2017/5/16.
 */
public class EncryptFieldIntro extends JacksonAnnotationIntrospector {

    @Override
    public Object findSerializer(Annotated a) {
        if (a.hasAnnotation(PropertyEncrypt.class)) {

            JsonSerialize ann = _findAnnotation(a, JsonSerialize.class);
            if (ann != null) {
                @SuppressWarnings("rawtypes")
                Class<? extends JsonSerializer> serClass = ann.using();
                if (serClass != JsonSerializer.None.class) {
                    return serClass;
                }
            }

        /* 18-Oct-2010, tatu: [JACKSON-351] @JsonRawValue handled just here, for now;
         *  if we need to get raw indicator from other sources need to add
         *  separate accessor within {@link AnnotationIntrospector} interface.
         */
            JsonRawValue annRaw =  _findAnnotation(a, JsonRawValue.class);
            if ((annRaw != null) && annRaw.value()) {
                // let's construct instance with nominal type:
                Class<?> cls = a.getRawType();
                return new RawSerializer<Object>(cls);
            }
            return null;
        }
        return super.findSerializer(a);
    }
}
