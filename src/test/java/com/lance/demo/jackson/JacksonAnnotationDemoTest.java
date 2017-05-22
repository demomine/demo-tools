package com.lance.demo.jackson;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.lance.demo.jackson.model.JsonGetterModel;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by perdonare on 2017/5/15.
 */
public class JacksonAnnotationDemoTest {
    private JacksonAnnotationDemo jacksonAnnotationDemo;
    private JsonGetterModel jsonGetterModel;

    @Before
    public void tearUp() {
        jacksonAnnotationDemo = new JacksonAnnotationDemo();
    }
    @Test
    public void jsonAnyGetter() throws Exception {
        String result = jacksonAnnotationDemo.jsonAnyGetter();
        System.out.println("result:  " + result);
        assertTrue(result.contains("attr1"));
        assertTrue(result.contains("val1"));
    }

    @Test
    public void jsonGetter() throws Exception {
        String result = jacksonAnnotationDemo.jsonGetter();
        System.out.println("result:  " + result);
        assertTrue(result.contains("localName"));
    }

    @Test
    public void jsonOrder() throws Exception {
        String result = jacksonAnnotationDemo.jsonOrder();
        System.out.println("result:  " + result);
        //assertTrue(result.contains("localName"));
    }

    @Test
    public void jsonRawValue() throws Exception {
        String result = jacksonAnnotationDemo.jsonRawValue();
        System.out.println("result:  " + result);
        //assertTrue(result.contains("localName"));
    }

    @Test
    public void jsonValue() throws Exception {
        String result = jacksonAnnotationDemo.jsonValue();
        System.out.println("result:  " + result);
        //assertTrue(result.contains("localName"));
    }

    @Test
    public void jsonRoot() throws Exception {
        String result = jacksonAnnotationDemo.jsonRoot();
        System.out.println("result:  " + result);
        //assertTrue(result.contains("localName"));
    }

    @Test
    public void jsonSerial() throws Exception {
        String result = jacksonAnnotationDemo.jsonSerial();
        System.out.println("result:  " + result);
        //assertTrue(result.contains("localName"));
    }

    @Test
    public void jsonAll() throws Exception {
        String result = jacksonAnnotationDemo.jsonAll();
        System.out.println("result:  " + result);
        //assertTrue(result.contains("localName"));
    }

    @Test
    public void jsonCustomer() throws Exception {
        String result = jacksonAnnotationDemo.jsonCustomer();
        System.out.println("result:  " + result);
        //assertTrue(result.contains("localName"));
    }

    @Test
    public void jsonContext() throws Exception {
        String result = jacksonAnnotationDemo.jsonContextualByType();
        System.out.println("result:  " + result);
        //assertTrue(result.contains("localName"));
    }

    @Test
    public void jsonAnnotation() throws Exception {
        String result = jacksonAnnotationDemo.jsonContextualByAnnotation();
        System.out.println("result:  " + result);
        //assertTrue(result.contains("localName"));
    }
    @Test
    public void jsonCustomerProvider() throws Exception {
        String result = jacksonAnnotationDemo.jsonCustomerProvider();
        System.out.println("result:  " + result);
        //assertTrue(result.contains("localName"));
    }
    @Test
    public void jsonExtend() throws JsonProcessingException {
        String result = jacksonAnnotationDemo.jsonExtend();
        System.out.println("result:  " + result);
    }
}