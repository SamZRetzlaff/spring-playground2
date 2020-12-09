package com.example.demo;

import org.springframework.web.bind.annotation.*;

import java.util.Map;

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

    @RequestMapping("/math/area")
    public String getAreaParams(@RequestParam Map<String, String> body){
        String resultString = "";
        String type = body.get("type");
        if(type.equals("rectangle")){
            int width = Integer.parseInt(body.get("width"));
            int height = Integer.parseInt(body.get("height"));
            int area = Math.multiplyExact(width, height);
            resultString = resultString + "Area: " + area;
            return resultString;
        } else if(type.equals("circle")){
            int radius = Integer.parseInt(body.get("radius"));
            int r2 = radius * radius;
            double area = Math.PI * r2;
            resultString = resultString + "Area: " + area;
            return resultString;
        } else {
            return resultString;
        }


    }

}
