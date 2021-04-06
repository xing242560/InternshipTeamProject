package com.mm.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class helloController {


@GetMapping("/hello")
    public String hello(){
    return "hi";
}

//private helloConfig helloConfig;
//@Value("${date}")
//   private String date;
//@GetMapping("/date")
//    public String date(){
//    return date;
//}
}
