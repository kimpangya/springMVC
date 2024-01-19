package com.sparta.springmvc;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sparta.springmvc.response.Star;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class JacksonTest {
    @Test
    //해당 클래스에 getter 있어야 함 없으면 오류남
    @DisplayName("Object To JSON : get Method 필요")
    void test1() throws JsonProcessingException {
        Star star = new Star("Robbie", 95);

        // Jackson 라이브러리의 ObjectMapper
        //Object => json 직렬화
        ObjectMapper objectMapper = new ObjectMapper();
        //파라미터값으로 변환하고 싶은 거 넣어주면 됨 star
        String json = objectMapper.writeValueAsString(star);
        System.out.println("json = " + json);
    }

    @Test
    //얘도 getter, setter 필요함
    //그리고 기본 생성자 없으면 오류남
    @DisplayName("JSON To Object : 기본 생성자 & (get OR set) Method 필요")
    void test2() throws JsonProcessingException {
        //여기서 변수명도 정확하게 일치해야 인식 가능함
        String json = "{\"name\":\"Robbie\",\"age\":95}"; // JSON 타입의 String


        ObjectMapper objectMapper = new ObjectMapper(); // Jackson 라이브러리의 ObjectMapper
        //만들 객체의 class타입 줘야함 Star.class
        //json => Star객체 만들기 역직렬화
        Star star = objectMapper.readValue(json, Star.class);
        System.out.println("star.getName() = " + star.getName());
        System.out.println("star.getAge() = " + star.getAge());
    }
}
