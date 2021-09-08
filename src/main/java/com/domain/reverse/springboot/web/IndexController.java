package com.domain.reverse.springboot.web;

import com.domain.reverse.springboot.service.posts.PostsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@RequiredArgsConstructor
@Controller
public class IndexController {

    private final PostsService postsService;

    @GetMapping("/")
    public String index(Model model) {  //서버 템플릿 엔진에서 사용할 수 있는 객체 저장할 수 있다.
        model.addAttribute("posts", postsService.findAllDesc());    //findAllDesc()로 가져온 결과를 posts로 index.mustache에 전달함.
        return "index";
    }

    @GetMapping("/posts/save")
    public String postsSave() {
        return "posts-save";
    }
}
