package com.jenkins.jenkinsAmm.controller;

import org.springframework.web.bind.annotation.GetMapping;

@org.springframework.web.bind.annotation.RestController
public class RestController {

    @GetMapping("/jen")
    public String getDemo(){
        return "Hellow Jenknins";
    }

    @GetMapping("/jenkins")
    public String getHelo(){
        return "Upadted Hellow Jenknins";
    }


}
