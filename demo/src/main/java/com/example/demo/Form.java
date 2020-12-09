package com.example.demo;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import java.util.Map;

@RestController
public class Form {

    //Access request body as a string
    @PostMapping("/string-example")
    public String getRawString(@RequestBody String rawbody) {
        return rawbody;
    }
    //access request body as a map
    @PostMapping(value = "/map-example", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public String showFormData(@RequestParam Map<String, String> body) {
        return body.toString();
    }
//    //access request body as an object
//    @PostMapping(value = "/object-example", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
//    public String showFormDataObject(@RequestBody Person person){
//        return person.toString();
//    }

}
