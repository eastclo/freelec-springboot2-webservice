package com.domain.reverse.springboot.config.auth;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.PARAMETER)  //어노테이션이 생성될 수 있는 위치 지정(PARAMETER: 메소드의 파라미터로 선언된 객체에만 사용 가능, TYPE:클래스 선언문에 사용가능)
@Retention(RetentionPolicy.RUNTIME)
public @interface LoginUser {   //LoginUser 어노테이션 선언
}
