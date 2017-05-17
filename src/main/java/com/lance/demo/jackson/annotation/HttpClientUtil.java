package com.lance.demo.jackson.annotation;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.apache.http.Consts;
import org.apache.http.NameValuePair;
import org.apache.http.client.fluent.Request;
import org.apache.http.message.BasicNameValuePair;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by perdonare on 2017/5/16.
 */
public class HttpClientUtil {
    ObjectMapper objectMapper = new ObjectMapper();

    public <T> void post(T t) throws Exception {
        objectMapper.configure(SerializationFeature.WRAP_ROOT_VALUE, true);
        Class clazz = t.getClass();
        //字段加密
        encryptField(t);
        //签名
        BasicNameValuePair signPair = resolveEncrypt(t);
        //表格化请求
        Map<String, String> formedMap = resolveFormedMap(t);
        }

    private <T> void encryptField(T t) throws IllegalAccessException {
        Field[] fields = t.getClass().getFields();
        if (fields != null && fields.length > 0) {
            for (int i = 0; i < fields.length; i++) {
                PropertyEncrypt propertyEncrypt = fields[i].getAnnotation(PropertyEncrypt.class);
                if (propertyEncrypt != null && fields[i].getType().equals(String.class)) {
                    fields[i].set(t,EncryptUtil.encrypt((String)fields[i].get(t),propertyEncrypt.value()));
                }
            }
        }
    }

    private <T> Map<String, String> resolveFormedMap(T t) throws IOException {
        FormRequest formRequest = t.getClass().getAnnotation(FormRequest.class);
        if (formRequest != null) {
            //formRequest.encryptField()
            return objectMapper.readValue(objectMapper.writeValueAsString(t),new TypeReference<HashMap<String, String>>() {
            });
        }
        return null;
    }

    private <T> BasicNameValuePair resolveEncrypt(T t) throws IOException {
        HeaderEncrypt headerEncrypt = t.getClass().getAnnotation(HeaderEncrypt.class);

        if (headerEncrypt != null) {
            String encryptName = headerEncrypt.value();
            String encryptValue = null;
            if (headerEncrypt.type() == EncryptType.JSON) {
                encryptValue = new ObjectMapper().writeValueAsString(t);
            } else if (headerEncrypt.type() == EncryptType.FORM) {
                List<NameValuePair> nameValuePairs = new ArrayList<>();
                if (headerEncrypt.encryptField().length == 0) {
                    String result = objectMapper.writeValueAsString(t);
                } else {
                    encryptValue = "";
                }
                String result = Request.Post("").connectTimeout(5000).socketTimeout(5000).bodyForm(nameValuePairs, Consts.UTF_8).execute().returnContent().asString();
                System.out.println(result);
            } else {
                throw new RuntimeException("");
            }
            return new BasicNameValuePair(encryptName, encryptValue);
        }
        return null;
    }
}
