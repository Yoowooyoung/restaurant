package com.example.restaurant.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

// HTML 페이지를 반환하는 컨트롤러 (화면 라우팅 담당)
@Controller  // 뷰(HTML)를 반환하는 컨트롤러임을 명시
@RequestMapping("/pages")  // 이 컨트롤러의 기본 URL은 /pages
public class PageController {

    // GET /pages/main 요청을 처리
    @GetMapping("/main")
    public ModelAndView main(){
        // resources/templates/aaaa/main.html 파일을 찾아서 반환
        return new ModelAndView("aaaa/main");
    }
}