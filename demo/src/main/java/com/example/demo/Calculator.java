package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Calculator {

    @GetMapping("/math/caclculate")
    public String getIndividualParams(@RequestParam(defaultValue = "add") String operation, @RequestParam int x, @RequestParam int y){
        return "" + MathService.calculate(operation,x,y).toString();
    }
    

}
