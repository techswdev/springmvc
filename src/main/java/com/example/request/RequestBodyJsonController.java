package com.example.request;


import com.example.requestmapping.User;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

@Controller
@Slf4j
public class RequestBodyJsonController {

    @Autowired
    private ObjectMapper objectMapper;

    @PostMapping("/request-body-json-v1")
    public void requestBodyJsonV1(HttpServletRequest request, HttpServletResponse response) throws IOException {
        ServletInputStream inputStream = request.getInputStream();
        String messageBody = StreamUtils.copyToString(inputStream, StandardCharsets.UTF_8);

        User user = objectMapper.readValue(messageBody, User.class);
        log.info("userName : {}", user.getUserName());
        log.info("age : {}", user.getAge());
        response.getWriter().write("ok");
    }

    @ResponseBody
    @PostMapping("/request-body-json-v2")
    public String requestBodyJsonV2(@RequestBody String messageBody) throws IOException {

        User user = objectMapper.readValue(messageBody, User.class);
        log.info("userName : {}", user.getUserName());
        log.info("age : {}", user.getAge());
        return "ok";
    }

    @ResponseBody
    @PostMapping("/request-body-json-v3")
    public String requestBodyJsonV3(@RequestBody User user) throws IOException {

        log.info("userName : {}", user.getUserName());
        log.info("age : {}", user.getAge());
        return "ok";
    }

    @ResponseBody
    @PostMapping("/request-body-json-v4")
    public String requestBodyJsonV4(HttpEntity<User> userHttpEntity) throws IOException {

        User data = userHttpEntity.getBody();
        return "ok";
    }

    @ResponseBody
    @PostMapping("/request-body-json-v5")
    public User requestBodyJsonV5(@RequestBody User user) throws IOException {
        return user;
    }




}

