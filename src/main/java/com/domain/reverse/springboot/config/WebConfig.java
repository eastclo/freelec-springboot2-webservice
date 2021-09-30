package com.domain.reverse.springboot.config;

import com.domain.reverse.springboot.config.auth.LoginUserArgumentResolver;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

@RequiredArgsConstructor
@Configuration
public class WebConfig implements WebMvcConfigurer {
    private final LoginUserArgumentResolver loginUserArgumentResolver;

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
        argumentResolvers.add(loginUserArgumentResolver);   //Spring에서 생성한 HandlerMethodArgumentResolver의 구현체 클래스를 인식할 수 있게 하려면
                                                            //WebMvcConfigurer의 addArgumentResolvers를 통해 추가해야한다.
    }
}
