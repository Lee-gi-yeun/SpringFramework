package com.ohgiraffers.handlermethod;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.WebRequest;

@Controller
@RequestMapping("/first/*")
public class FirstController {

    // 핸들러 메서드 반환 값이 void 인 경우 요청 주소가 곧 view의 이름이 된다
    @GetMapping("/regist")
    public void regist(){}

    // 1. WebRequest로 요청 파라미터 전달 받기
    // HttpServletRequest/Response 도 매개변수에 선언해서 사용하는 것이 가능하긴 하지만
    // WebRequest가 Servlet 기술에 종속적이지 않아 Spring 기반의 프로젝트에서 더 자주 사용된다
    @PostMapping("/regist")
    public String registMenu(WebRequest request, Model model){

        String name = request.getParameter("name");
        int price = Integer.parseInt(request.getParameter("price"));
        int categoryCode = Integer.parseInt(request.getParameter("categoryCode"));

        String message = name + "을 신규 메뉴 목록의 " + categoryCode + "번 카테고리에 " + price + "원으로 등록했습니다.";
        model.addAttribute("message", message);

        return "first/messagePrinter";
    }
}
