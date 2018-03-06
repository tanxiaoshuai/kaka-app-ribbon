package com.sobey.controller;

import com.sobey.model.UserBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@RestController
public class UserController {

    @Autowired
    RestTemplate restTemplate;

    @PostMapping("/rest/user/login")
    public Object login (@RequestBody Object userBean) {
        return restTemplate.postForEntity("http://KAKA-APP-SERVICE/kaka-app-mservice/rest/user/login",userBean , Map.class);
    }

    @GetMapping("/rest/site/findByIdList/{userid}")
    public Object findByIdList(@PathVariable String userid , HttpServletRequest request) throws Exception{
        HttpHeaders headers = new HttpHeaders();
        headers.add("token" , request.getHeader("token"));
        HttpEntity<String> requestEntity = new HttpEntity<String>(headers);
        return restTemplate.exchange("http://KAKA-APP-SERVICE/kaka-app-mservice/rest/site/findByIdList/" + userid , HttpMethod.resolve("GET"),requestEntity , Map.class);
    }
}
