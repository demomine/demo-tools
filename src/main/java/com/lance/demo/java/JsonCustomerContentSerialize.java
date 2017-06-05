package com.lance.demo.java;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;
import java.util.List;

/**
 * Created by perdonare on 2017/5/15.
 */
public class JsonCustomerContentSerialize extends JsonSerializer<List<String>> {

    @Override
    public void serialize(List<String> strings, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.writeString(strings.toString());
    }

}
