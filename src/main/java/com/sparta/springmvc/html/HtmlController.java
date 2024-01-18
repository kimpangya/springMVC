package com.sparta.springmvc.html;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HtmlController {

    private static long visitCount=0;

    //필요한 model 객체를 자동으로 넣어줌
    @GetMapping("/html/dynamic")
    public String htmlDynamic(Model model){
        visitCount++;
        //visits = 식별할 수 있는 이름 넣기, 실제 데이터=visitOcunt
        //  (방문자 수: <span th:text="${visits}"></span>) 이거 템플릿 html에 있음
        // 여기서 ${visits}에 밑에있는 값을 넣
        model.addAttribute("v", visitCount); //model
        //필요한 데이터 모델이랑, view name 정보 필요하다고 했음
        //controller에서 받아오고, view에 불러줄 때 필요하다고 했음!! 그림 이씀
        return "hello-visit"; //view name 정보
    }

    //Controller하고 안에있는 메소드에 String 반환 메소드를 하면
    //반환되는 return 값의 이름 파일을 찾아오는거임
    //여기서는 hello.html을 찾게 됨
    @GetMapping("/statichello")
    public String hello(){
        return "hello.html";
    }

    //직접 접근하는 경로로 다시한번 요청해달란 거임
    //그니까 컨트롤러를 거치긴 할 건데 돌아서 가겠단 거임
    @GetMapping("/html/redirect")
    public String htmlStatic(){
        return "redirect:/hello.html";
    }

    @GetMapping("/html/templates")
    public String htmlTemplates(){
        return "hello";
    }

}
