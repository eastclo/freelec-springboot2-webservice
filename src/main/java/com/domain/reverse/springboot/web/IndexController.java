package com.domain.reverse.springboot.web;

import com.domain.reverse.springboot.config.auth.dto.SessionUser;
import com.domain.reverse.springboot.service.posts.PostsService;
import com.domain.reverse.springboot.web.dto.PostsResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import javax.servlet.http.HttpSession;

@RequiredArgsConstructor
@Controller
public class IndexController {

    private final PostsService postsService;
    private final HttpSession httpSession;

    @GetMapping("/")
    public String index(Model model) {  //서버 템플릿 엔진에서 사용할 수 있는 객체 저장할 수 있다.
        model.addAttribute("posts", postsService.findAllDesc());    //findAllDesc()로 가져온 결과를 posts로 index.mustache에 전달함.
        SessionUser user = (SessionUser) httpSession.getAttribute("user"); //CustomOAuth2UserService에서 로그인 성공시 httpSession.setAttribute로 SessionUser를 저장함
        if(user != null) { //세션에 저장된 값이 있을 때만 model에 userName으로 등록, 값이 없으면 model에 아무것도 없으므로 로그인 버튼이 보임(index.mustache)
            model.addAttribute("userName", user.getName());
        }
        return "index";
    }

    @GetMapping("/posts/save")
    public String postsSave() {
        return "posts-save";
    }

    @GetMapping("/posts/update/{id}")
    public String postUpdate(@PathVariable Long id, Model model) {
        PostsResponseDto dto = postsService.findById(id);
        model.addAttribute("post", dto);

        return "posts-update";
    }

}
