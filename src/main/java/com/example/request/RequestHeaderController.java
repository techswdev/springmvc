package com.example.request;


import org.springframework.http.HttpMethod;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Locale;

@RestController
public class RequestHeaderController {

    @RequestMapping("/header")
    public String header(HttpServletRequest request,
                         HttpServletResponse response,
                         HttpMethod httpMethod,
                         Locale locale,
                         @RequestHeader MultiValueMap<String, String> headerMap,
                         @RequestHeader("host") String host,
                         @CookieValue(value = "myCookie", required = false) String cookie
                        ) {

        System.out.println("request = " + request);
        System.out.println("response = " + response);
        System.out.println("httpMethod = " + httpMethod);
        System.out.println("locale = " + locale);
        System.out.println("headerMap = " + headerMap);
        System.out.println("host = " + host);
        System.out.println("cookie = " + cookie);

        return "ok";
    }
}