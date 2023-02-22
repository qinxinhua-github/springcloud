package com.yun.util;

import com.alibaba.fastjson.JSON;
import net.sf.json.JSONArray;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

import java.util.Map;

/**
 * 工具方法
 * 2023年1月29日19:25:28
 */
public class Tookit {
    /**
     * 获取请求参数
     * @param val
     * @return
     */
    public static HttpEntity getHttpEntity(Map<String,String> val){
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        HttpEntity httpEntity = new HttpEntity(JSON.toJSONString(val),headers);
        return httpEntity;
    }
}
