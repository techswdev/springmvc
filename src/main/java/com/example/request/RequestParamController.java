package com.example.request;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@Controller
public class RequestParamController {

    @RequestMapping("/request-param-v1")
    public void requestParamV1(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String userName = request.getParameter("userName");
        int age = Integer.parseInt(request.getParameter("age"));

        response.getWriter().write("ok");

    }

    @ResponseBody
    @RequestMapping("/request-param-v2")
    public String requestParamV2(
            @RequestParam("userName") String memberName,
            @RequestParam("age") int memberAge) {

        return "okay";
    }

    @ResponseBody
    @RequestMapping("/request-param-v3")
    public String requestParamV3(
            @RequestParam String memberName,
            @RequestParam int memberAge) {

        return "okay call";
    }

    @ResponseBody
    @RequestMapping("/request-param-v4")
    public String requestParamV4(
             String memberName,
             int memberAge) {

        return "okay";
    }

    @ResponseBody
    @RequestMapping("/request-param-v5")
    public String requestParamV5(
             @RequestParam(required = true) String memberName,
             @RequestParam(required = false) Integer memberAge) {

        return "okay calling";
    }

    @ResponseBody
    @RequestMapping("/request-param-v6")
    public String requestParamV6(
             @RequestParam(required = true, defaultValue = "guest") String memberName,
             @RequestParam(required = false, defaultValue = "-1") int memberAge) {

        return "okay calling";
    }

    @ResponseBody
    @RequestMapping("/request-param-v7")
    public String requestParamV7(
             @RequestParam Map<String, String> paraMap) {

        return "okay calling";
    }
}
