package com.example;

import com.example.user.entity.User;
import com.example.user.support.UserJsonObject;
import com.example.user.support.UserMap;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.http.*;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

public class RestTemplateDemo {

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Test
    public void testExchange() {
        String url = "http://127.0.0.1:8080/user/add";
        RestTemplate restTemplate = new RestTemplate();

        UserMap userMap = new UserMap();
        userMap.putAge(12);
        userMap.putName("12岁的人");
        Map<String, Object> map = userMap.getMap();

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);

        MultiValueMap<String, Object> multiValueMap = new LinkedMultiValueMap<>();
        multiValueMap.setAll(map);

        //HttpEntity<MultiValueMap<String, Object>> requestEntity = new HttpEntity<>(multiValueMap, httpHeaders);
        HttpEntity<Map<String, Object>> requestEntity = new HttpEntity<>(map, httpHeaders);
        ResponseEntity<Map> exchange = restTemplate.exchange(url, HttpMethod.POST, requestEntity, Map.class);
        Map body = exchange.getBody();
        System.out.println(body);
    }

    @Test
    public void testPostForObject() throws JSONException {
        String url = "http://127.0.0.1:8080/user/add";
        RestTemplate restTemplate = new RestTemplate();

        UserJsonObject json = new UserJsonObject();
        json.putAge(12);
        json.putName("12岁的人");
        String jsonStr = json.getJsonStr();

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);

        //HttpEntity<MultiValueMap<String, Object>> requestEntity = new HttpEntity<>(multiValueMap, httpHeaders);
        HttpEntity<String> requestEntity = new HttpEntity<>(jsonStr, httpHeaders);
//        ResponseEntity<Map> exchange = restTemplate.exchange(url, HttpMethod.POST, requestEntity, Map.class);
//        Map body = exchange.getBody();

        Map body = restTemplate.postForObject(url, requestEntity, Map.class);
        System.out.println(body);
    }

    @Test
    public void testPostForObject2() throws JSONException {
        String url = "http://127.0.0.1:8080/user/add";
        RestTemplate restTemplate = new RestTemplate();

        User user = new User();
        user.setAge(12);
        user.setName("姓名");

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<User> requestEntity = new HttpEntity<>(user, httpHeaders);

        Map body = restTemplate.postForObject(url, requestEntity, Map.class);
        System.out.println(body);
    }
}
