package com.lance.demo.jackson.model;

import com.fasterxml.jackson.annotation.JsonRawValue;
import com.lance.demo.jackson.annotation.EnableEncrypt;
import com.lance.demo.jackson.annotation.PropertyEncrypt;
import lombok.Data;

/**
 * Created by perdonare on 2017/5/16.
 */
@Data
@EnableEncrypt
public class JsonCustomerSerializeModel extends CommonModel{
    //@PropertyEncrypt
    private String localName;
    //@PropertyEncrypt
    //@JsonRawValue
    private InnerModel innerModel;

    public JsonCustomerSerializeModel(String localName, InnerModel innerModel) {
        this.innerModel = innerModel;
        this.localName = localName;
    }
}
