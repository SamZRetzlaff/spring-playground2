package com.example.demo;

import org.springframework.web.bind.annotation.*;

@RestController
public class Calculator {

    @GetMapping("/math/calculate")
    public String getIndividualParams(@RequestParam(defaultValue = "add") String operation, @RequestParam int x, @RequestParam int y){
        return "" + MathService.calculate(operation,x,y).toString();
    }

//    @PostMapping("/math/sum")
//    public String sum(@RequestParam Integer [] n){
//        return MathService.sum(n).toString();
//    }

    @RequestMapping("/math/volume/{l}/{w}/{h}")
    public String getVolumeParams(@PathVariable int l, @PathVariable int w, @PathVariable int h){
        return MathService.volume(l,w,h).toString();
    }

}
