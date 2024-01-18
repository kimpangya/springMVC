package com.sparta.springmvc.response;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/response") //response가 경로들 앞에 붙어있는거라고 했음
//경로에 response 붙는 애들 메소드들은 다 이 클래스에서 처리하겠다는 뜻
public class ResponseController {
    //Content-Type : text/html 얘는 어떤 형태로 반환될건지를 알려줌 html에서는 밑 제이슨 형태를 텍스트로 인식한다는 뜻
    //Response Body
    //{"name" : "pangya", "age" : 100} 이런 형식
    @GetMapping("/json/string")
    @ResponseBody
    public String helloStringJson() {
        //json형태로 생겼는데, string으로 반환해줌
        //json = 예전에 html 할 때 fetch 하는거 있었음 실시간 데이터 가져오는거 그거임 그거랑 형태 똑같음
        return "{\"name\":\"Robbie\",\"age\":95}";
    }

    //이때는 Content- type : application/json 타입
    //Resonse Body
    //{"name" : "pangya", "age" : 100}
    //위랑 똑같음 벗 타입이 다름 위는 텍스트고 아래는 어플리제이슨타입
    //어떻게? 자바 객체를 그대로 반환함 얘는
    //그러면 클라이언트코드는 자바스크립트인데 얘를 어떻게 이해함?
    //json혀태로 넘겨줘야 클라이언트는 이해할 수 있음
    //그럼 매번 위에처럼 바꿔줘야 함?
    //아니아니 이거 스프링부트가 알아서 바꿔줌 자바객체 => 제이슨
    @GetMapping("/json/class")
    @ResponseBody //controller가 달려 있을때 String 값 반환하게 되면
    // string 값의 templates에서 해당이름의 html을 찾고 반환하게 됨
    //but 우리는 html 찾으려고 하는 게 아니라, 데이터를 전달해 주고 싶은거임!
    //그래서 responsebody 쓴다~~ 이말임
    //그때 데이터를 Responsebody에 담아서 전달해준다고 했잖음 ㅇㅇ
    //responseBody = view 반환X 데이터 반환O
    public Star helloClassJson(){
        return new Star("pangya",100);
    }
}
