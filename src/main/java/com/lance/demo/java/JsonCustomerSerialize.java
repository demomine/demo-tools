package com.lance.demo.java;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by perdonare on 2017/5/15.
 */
public class JsonCustomerSerialize extends StdSerializer<Date> {
    private static SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");
    public JsonCustomerSerialize(Class<Date> t) {
        super(t);
    }

    public JsonCustomerSerialize() {
        this(null);
    }

    @Override
    public void serialize(Date date, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {

        jsonGenerator.writeString(formatter.format(date));
    }
}
