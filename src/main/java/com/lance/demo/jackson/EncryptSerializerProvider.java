package com.lance.demo.jackson;

import com.fasterxml.jackson.databind.SerializationConfig;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.DefaultSerializerProvider;
import com.fasterxml.jackson.databind.ser.SerializerFactory;
import lombok.Getter;

/**
 * Created by perdonare on 2017/5/18.
 */

public class EncryptSerializerProvider extends DefaultSerializerProvider {
    @Getter
    private String merchantNo;
    @Getter
    private String bizType;
    private static final long serialVersionUID = 1L;

    public EncryptSerializerProvider(String merchantNo,String bizType) {
        super();
        this.merchantNo = merchantNo;
        this.bizType = bizType;
    }
    public EncryptSerializerProvider(String merchantNo,String bizType,EncryptSerializerProvider src) {
        super(src);
        this.merchantNo = merchantNo;
        this.bizType = bizType;
    }

    protected EncryptSerializerProvider(String merchantNo,String bizType,SerializerProvider src, SerializationConfig config,
                   SerializerFactory f) {
        super(src, config, f);
        this.merchantNo = merchantNo;
        this.bizType = bizType;
    }

    @Override
    public DefaultSerializerProvider copy()
    {
        if (getClass() != EncryptSerializerProvider.class) {
            return super.copy();
        }
        return new EncryptSerializerProvider(this.merchantNo,this.bizType);
    }

    @Override
    public EncryptSerializerProvider createInstance(SerializationConfig config, SerializerFactory jsf) {
        return new EncryptSerializerProvider(this.merchantNo,this.bizType,this, config, jsf);
    }
}
