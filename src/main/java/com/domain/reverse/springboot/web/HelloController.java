package com.domain.reverse.springboot.web;

import com.domain.reverse.springboot.web.dto.HelloResponseDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController //1.컨트롤러를 JSON을 반환하는 컨트롤러로 만들어준다.
                // 2. @ResponseBody를 각 메소드마다 선언했던 것을 한번에 사용할 수 있게 해줌
public class HelloController {
    @GetMapping("/hello")   //1.HTTP Method인 Get의 요청을 받을 수 있는 API를 만들어준다.
                            // 2.예전에는 @RequestMapping(method = RequestMethod.GET)으로 사용되었다.
    public String hello() { ///hello로 요청이 오면 문자열 Hello World!!를 반환함.
        return "Hello World!!";
    }

    @GetMapping("/hello/dto")
    public HelloResponseDto helloDto(@RequestParam("name") String name, //외부에서 API로 넘긴 파라미터를 가져옴
                                     @RequestParam("amount") int amount) {
        return new HelloResponseDto(name, amount);
    }
}