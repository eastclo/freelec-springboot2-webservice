package com.domain.reverse.springboot.web;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)    //JUnit 내장 실행자 외에 다른 실행자(SpringRunner)를 실행시킴. 스프링부트 테스트와 JUnit의 연결자 역할
@WebMvcTest(controllers = HelloController.class)    //Spring test annotation 중 하나. Web(Spring MVC)에 집중
                                                    //선언시 @Controller, @ControllerAdvice 등 사용 가능
                                                    //선언시 @Service, @Component, @Repository 등 사용 불가
public class HelloControllerTest {

    @Autowired  //Spring이 관리하는 빈(Bean)을 주입받는다.
    private MockMvc mvc;    //웹 API를 테스트할 때 사용, Spring MVC 테스트의 시작점, HTTP GET/POST 등에 대한 API 테스트

    @Test
    public void hello_returned() throws Exception {
        String hello = "Hello World!!";

        mvc.perform(get("/hello"))  //MockMvc를 통해 /hello 주소로 HTTP GET 요청, 체이닝 지원
                .andExpect(status().isOk()) //mvc.perform의 결과 중 HTTP Header의 Status검증(200, 404, 500 등). 200이면 통과
                .andExpect(content().string(hello));    //mvc.perform의 결과 중 응답 본문 내용 검증
    }

    @Test
    public void helloDto가_리턴된다() throws Exception {
        String name = "hello";
        int amount = 1000;

        mvc.perform(
                get("/hello/dto")
                        .param("name", name)    //API 테스트 시 사용될 요청 파라미터 설정, String만 가능
                        .param("amount", String.valueOf(amount)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name", is(name)))    //JSON 응답 값을 필드별로 검증
                .andExpect(jsonPath("$.amount", is(amount)));
    }
}