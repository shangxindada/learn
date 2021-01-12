package com.example.demo;

import com.alibaba.fastjson.JSON;
import com.example.demo.model.HttpClientResult;
import com.example.demo.utils.HttpClient;
import com.example.demo.utils.HttpClientUtils;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.Map;

@SpringBootTest
class DemoApplicationTests {

    @Test
    void contextLoads() throws Exception {
        String url = "http://122.152.192.245:8007/DataPlatform.WebDataPlatform.svc/Web/GetZZSData";
        Map<String,String> params = new HashMap<>();
        params.put("nsrdj_no","123456789012345");
        params.put("pwd","123456");
        params.put("strdate","20190701");
        params.put("enddate","20190809");
        Map<String,String> header = new HashMap<>();
        String result = HttpClient.doPost(url,JSON.toJSONString(params));
        System.out.println( result.TrimStart('\"').TrimEnd('\"'));
        System.out.println(JSON.toJSONString(params));
    }

}
