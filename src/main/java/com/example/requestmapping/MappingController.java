package com.example.requestmapping;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
public class MappingController {

    //case1
    @RequestMapping("/hello-basic")
    public String helloBasic(){
        return "ok";
    }

    //case2
    @RequestMapping("/hello-basic1, hello-basic2")
    public String helloBasicMulti(){
        return "ok";
    }

    //case3
    @RequestMapping(value = "/hello-basic3",method = RequestMethod.GET)
    public String helloBasic3(){
        return "ok";
    }

    //case4
    @GetMapping(value = "/hello-basic4")
    public String helloBasic4(){
        return "ok";
    }

    //case5
    @PostMapping(value = "/hello-basic5")
    public String helloBasic5(){
        return "ok";
    }

    //case6
    @DeleteMapping (value = "/hello-basic6")
    public String helloBasic6(){
        return "ok";
    }



    //case7
    @GetMapping("/hello-basic7/{data}")
    public String helloBasic7(@PathVariable("data") String datas){
        return "ok";
    }

    //case8
    @GetMapping("/hello-basic8/{data}")
    public String helloBasic8(@PathVariable String data){
        return "ok";
    }

    //case9
    @GetMapping("/hello-basic9/user/{userId}/orders/{orderId}")
    public String helloBasic9(@PathVariable String userId, @PathVariable String orderId){
        return "ok";
    }

    //case10
    @GetMapping(value = "/hello-basic10", params = "mode=debug")
    public String helloBasic10(){
        return "ok";
    }

    //case11
    @PostMapping(value = "/hello-basic11", headers = "mode=debug")
    public String helloBasic11(){
        return "ok";
    }


    //case12
    @PostMapping(value = "/hello-basic12", consumes = MediaType.APPLICATION_JSON_VALUE)
    public String helloBasic12(){
        return "ok";
    }

    //case13
    @PostMapping(value = "/hello-basic13", produces = MediaType.TEXT_PLAIN_VALUE)
    public String helloBasic13(){
        return "ok";
    }
}
