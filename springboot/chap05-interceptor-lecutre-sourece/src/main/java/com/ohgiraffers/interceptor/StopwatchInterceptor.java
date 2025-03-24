package com.ohgiraffers.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Component
@RequiredArgsConstructor
public class StopwatchInterceptor implements HandlerInterceptor {

    // Interceptor는 스프링 컨테이너에 존재하는 빈을 의존성 주입 받을 수 있다
    private final MenuService menuService;

//    public StopwatchInterceptor(MenuService menuService) {
//        this.menuService = menuService;
//    }

    // 전처리 메소드
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("PreHandler 메소드 동작");
        long startTime = System.currentTimeMillis();
        request.setAttribute("startTime", startTime);
        return true;    // 컨트롤러 핸들러 메소드 호출로 이어짐, false 이면 호출하지 않는다
    }

    // 후처리 메소드
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        // ModelAndView 객체를 후처리시 가공할 수도 있다
        System.out.println("PostHandler 메소드 호출");
        long endTime = System.currentTimeMillis();
        long startTime = (long)request.getAttribute("startTime");
        modelAndView.addObject("interval", endTime - startTime);
    }

    // 뷰가 렌더링 된 이후 동작하는 메소드, exception 사용 가능
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("afterCompletion 메소드 호출");
        menuService.method();
    }
}
