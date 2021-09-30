package com.domain.reverse.springboot.config.auth;

import com.domain.reverse.springboot.domain.user.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@RequiredArgsConstructor
@EnableWebSecurity //Spring Security 설정 활성화
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    private final CustomOAuth2UserService customOAuth2UserService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .headers().frameOptions().disable() //h2-console 화면을 사용하기 위해 해당 옵션들을 disable함
                .and()
                    .authorizeRequests() //URL별 권한 관리를 설정하는 옵션의 시작점
                    .antMatchers("/", "/css/**", "/images/**", "/js/**", "/h2-console/**").permitAll() //권한 관리 대상자 지정 옵션, URL HTTP 메소드별 관리 가능. 해당 라인 URL은 전체 열란권한
                    .antMatchers("/api/v1/**").hasRole(Role.USER.name())  //USER 권한을 가진 사람만 가능
                    .anyRequest().authenticated() //설정된 값 이외의 나머지 URL들은 autenticated로 인증된 사용자만 허용
                .and()
                    .logout()
                        .logoutSuccessUrl("/") //로그아웃 성공시 "/"로 이동
                .and()
                    .oauth2Login()  //OAuth2 로그인 기능에 대한 설정의 진입점
                        .userInfoEndpoint() //OAuth2 로그인 성공 이후 사용자 정보를 가져올때의 설정
                            .userService(customOAuth2UserService);  //소셜 로그인 성공 시 후속 조치를 진행할 UserService 인터페이스의 구현체 지정
                                                                    // 리소스 서버에서 사용자 정보를 가져온 상태에서 추가로 진행하고자 하는 기능을 명시할 수 있다.
    }
}
