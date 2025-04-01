package com.ohgiraffers.springdatajpa.menu.controller;

import com.ohgiraffers.springdatajpa.common.Pagenation;
import com.ohgiraffers.springdatajpa.common.PagingButton;
import com.ohgiraffers.springdatajpa.menu.dto.MenuDTO;
import com.ohgiraffers.springdatajpa.menu.service.MenuService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/menu")
@RequiredArgsConstructor
@Slf4j  // log 라는 변수명으로 Logger 객체 타입의 필드가 선언되고 생성 된다.
public class MenuController {

    private final MenuService menuService;

    @GetMapping("/{menuCode}")
    public String findMenuByCode(@PathVariable int menuCode, Model model) {
        MenuDTO resultMenu = menuService.findMenuByMenuCode(menuCode);
        model.addAttribute("menu", resultMenu);
        return "menu/detail";
    }

    @GetMapping("/list")
    public String findMenuList(Model model, @PageableDefault Pageable pageable) {

        /* 페이징 처리 이전 정렬 처리만 반영 된 목록 조회 */
//        List<MenuDTO> menuList = menuService.findMenuList();
//        model.addAttribute("menuList", menuList);

        /* System.out.print 계열의 메소드보다 효율적으로 로그 출력을 할 수 있다.
         * 로그 레벨에 맞춘 메소드를 통해 출력 처리 한다.
         * {} 를 통해 값이 입력 될 위치를 포매팅 한다. */
        log.info("pageable : {}", pageable);

        /* 페이징 처리가 반영 된 목록 조회  */
        Page<MenuDTO> menuList = menuService.findMenuList(pageable);
        PagingButton paging = Pagenation.getPagingButtonInfo(menuList);
        model.addAttribute("menuList", menuList);
        model.addAttribute("paging", paging);

        /* number, size, sort 도 존재 */
        log.info("getContent : {}", menuList.getContent());
        log.info("getTotalPages : {}", menuList.getTotalPages());
        log.info("getTotalElements : {}", menuList.getTotalElements());
        log.info("getNumberOfElements : {}", menuList.getNumberOfElements());
        log.info("isFirst : {}", menuList.isFirst());
        log.info("isLast : {}", menuList.isLast());

        return "menu/list";
    }

    @GetMapping("/querymethod")
    public void queryMethodPage(){}

    @GetMapping("/search")
    public String findByMenuPrice(@RequestParam Integer menuPrice, Model model) {
        List<MenuDTO> menuList = menuService.findByMenuPrice(menuPrice);
        model.addAttribute("menuList", menuList);
        return "menu/searchResult";
    }

}