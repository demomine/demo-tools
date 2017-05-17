package com.lance.demo.jackson;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRawValue;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import lombok.Data;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by perdonare on 2017/5/16.
 */
public class JsonPaySerialize extends JsonSerializer {
    @Override
    public void serialize(Object value, JsonGenerator gen, SerializerProvider provider) throws IOException {
        TransContent transContent = new TransContent();
        TransReqData transReqData = new TransReqData();
        transReqData.getTrans_reqData().add(value);
        transContent.getTransReqDatas().add(transReqData);
        gen.writeObject(transContent);
    }

    @Data@JsonRootName("trans_content")
    class TransContent {
        @JsonProperty("trans_ReqDatas")
        private List<TransReqData> transReqDatas = new ArrayList<>(1);
    }

    @Data
    class TransReqData{
        @JsonProperty("trans_ReqData")
        private List trans_reqData = new ArrayList(1);
    }

}
