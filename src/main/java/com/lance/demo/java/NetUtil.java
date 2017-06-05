package com.lance.demo.java;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.Consts;
import org.apache.http.NameValuePair;
import org.apache.http.client.fluent.Request;
import org.apache.http.message.BasicNameValuePair;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by perdonare on 2017/5/16.
 */
public class NetUtil {
    public static String post(String url, String jsonRequest,int timeout) throws IOException {
        Map<String,String> map = new ObjectMapper().readValue(jsonRequest, new TypeReference<HashMap<String,String>>(){});
        List<NameValuePair> nameValuePairs = new ArrayList<>();
        if (map != null && map.size() > 0) {
            map.forEach((key,value)->{
                NameValuePair nameValuePair = new BasicNameValuePair(key, value);
                nameValuePairs.add(nameValuePair);
            });
        }
        return Request.Post(url).connectTimeout(timeout).socketTimeout(timeout).bodyForm(nameValuePairs, Consts.UTF_8).execute().returnContent().asString();

    }
}
