package com.lance.demo.jackson;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.lance.demo.jackson.annotation.EncryptFieldIntro;
import com.lance.demo.jackson.model.*;

import java.util.Arrays;
import java.util.Date;

/**
 * Created by perdonare on 2017/5/15.
 */
public class JacksonAnnotationDemo {
    private ObjectMapper objectMapper = new ObjectMapper();
    public String jsonAnyGetter() throws JsonProcessingException {
        JsonAnyGetterModel bean = new JsonAnyGetterModel("My bean");
        bean.getProperties().put("attr1", "val1");
        bean.getProperties().put("attr2", "val2");
        bean.getProperties().put("attr3", "val3");

        String result = objectMapper.writeValueAsString(bean);
        return result;
    }

    public String jsonGetter() throws JsonProcessingException {
        JsonGetterModel jsonGetterModel = new JsonGetterModel(1,"lance");

        return objectMapper.writeValueAsString(jsonGetterModel);
    }

    public String jsonOrder() throws JsonProcessingException {
        JsonOrderModel jsonOrderModel = new JsonOrderModel(1, "lance", 20);
        return objectMapper.writeValueAsString(jsonOrderModel);
    }

    public String jsonRawValue() throws JsonProcessingException {
        JsonRawValueModel jsonRawValue = new JsonRawValueModel("lance");
        jsonRawValue.setJson("{\"attr\":false}");
        return objectMapper.writeValueAsString(jsonRawValue);
    }

    public String jsonValue() throws JsonProcessingException {
        JsonValueModel jsonValueModel = new JsonValueModel(1, "lance", 20);
        return objectMapper.writeValueAsString(jsonValueModel);
    }

    public String jsonRoot() throws JsonProcessingException {
        JsonRootModel jsonRootModel = new JsonRootModel(1, "lance", 20);
        String result1 =  objectMapper.configure(SerializationFeature.WRAP_ROOT_VALUE,true).writeValueAsString(jsonRootModel);
        String result2 =  objectMapper.configure(SerializationFeature.WRAP_ROOT_VALUE,false).writeValueAsString(jsonRootModel);
        return result1 + result2;
    }

    public String jsonSerial() throws JsonProcessingException {
        JsonSerialModel jsonSerialModel = new JsonSerialModel("lance", new Date(), Arrays.asList("a1","a2","a3"));
        return objectMapper.writeValueAsString(jsonSerialModel);
    }

    public String jsonAll() throws JsonProcessingException {
        JsonAllModel<PayModel> jsonAllModel = new JsonAllModel<>();
        PayModel payModel = new PayModel();
        payModel.setTransNo("1234567A");
        payModel.setTransMoney("1.23");
        payModel.setToAccName("周小忍");
        payModel.setToAccNo("6222601234567890");
        payModel.setToBankName("工商银行");
        payModel.setToProName("上海市");
        payModel.setToCityName("上海市");
        payModel.setToAccDept("张江支行");
        payModel.setTransCardId("22032319930425218X");
        payModel.setTransMobile("18217550000");
        jsonAllModel.setDataContent(payModel);
        return new ObjectMapper().writeValueAsString(jsonAllModel);

    }

    public String jsonCustomer() throws JsonProcessingException {
        //objectMapper.setAnnotationIntrospector(new EncryptFieldIntro());
        JsonCustomerSerializeModel jsonCustomerSerializeModel = new JsonCustomerSerializeModel("lance",new InnerModel("aaa",30));
        jsonCustomerSerializeModel.setOrgCode("org1");
        jsonCustomerSerializeModel.setProductCode("product1");
        return objectMapper.writeValueAsString(jsonCustomerSerializeModel);
    }
}
