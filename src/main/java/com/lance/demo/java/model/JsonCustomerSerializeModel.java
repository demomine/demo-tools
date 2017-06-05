package com.lance.demo.java.model;

import com.lance.demo.java.annotation.EnableEncrypt;
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
