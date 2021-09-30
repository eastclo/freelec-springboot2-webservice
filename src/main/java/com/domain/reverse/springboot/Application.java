package com.domain.reverse.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

//@EnableJpaAuditing
@SpringBootApplication  //스프링 부트의 자동설정, 스프링 Bean 읽기와 생성 자동설정
                        //이 위치부터 설정을 읽어가기 때문에 항상 프로젝트 최상단에 위치해야함
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args); //내장 WAS 실행
    }
}