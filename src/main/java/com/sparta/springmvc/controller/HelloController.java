package com.sparta.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/api") //이거 밑에 다 경로 중복됨
//api/put , /api/delete 처럼 계속 중복됨
// 리퀘스트매핑해주면 이 클래스 안 메소드 경로에는 앞에 /api가 다 적용되는거임! = 중복 없애기 덜 쓰기 굿
public class HelloController {
    @GetMapping("/hello") //postman에서 get하고 로컬호스트 8080포트 뒤에붙는 부분이랑 매칭되는거임
    //만약 http://localhost:8080/api/pangya 였으면 여기 /apipangya해주면 됨
    @ResponseBody //내용물 return이 직접 문자열을 전해주는거라서 이거 적음
    public String hello(){
        return "Hello World";
    }

    @GetMapping("/get")
    @ResponseBody
    public String get(){
        return "GET Method 요청";
    }

    @PostMapping("/post")
    @ResponseBody
    public String post(){
        return "POST Method 요청";
    }

    @PutMapping("/put")
    @ResponseBody
    public String put(){
        return "PUT Method 요청";
    }

    @DeleteMapping("/delete")
    @ResponseBody
    public String delete(){
        return "DELETE Method 요청";
    }
}
