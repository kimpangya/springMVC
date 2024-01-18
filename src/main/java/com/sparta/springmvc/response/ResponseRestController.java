package com.sparta.springmvc.response;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController //controller+responseBody임
//이 클래스 메소드들은 전부 responseBody가 붙어잇는거나 마찬가지임
//그래서 만약 이 클래스 안에서 view를 반환해야 한다면 Controller로 하고,
//json형태로 데이터만 반환하는 메소드만 가지고 있다면 RestController해서 편하게 쓰자
@RequestMapping("/response/rest")
public class ResponseRestController {
    // [Response header]
    //   Content-Type: text/html
    // [Response body]
    //   {"name":"Robbie","age":95}
    @GetMapping("/json/string")
    public String helloStringJson() {
        return "{\"name\":\"Robbie\",\"age\":95}";
    }

    // [Response header]
    //   Content-Type: application/json
    // [Response body]
    //   {"name":"Robbie","age":95}
    @GetMapping("/json/class")
    public Star helloClassJson() {
        return new Star("Robbie", 95);
    }
}