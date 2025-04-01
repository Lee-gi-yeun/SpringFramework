package com.ohgiraffers.springdatajpa.menu.controller;

import com.ohgiraffers.springdatajpa.menu.dto.MenuDTO;
import com.ohgiraffers.springdatajpa.menu.service.MenuService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping(value = "/menu")
public class MenuController {

    private final MenuService menuService;



    @GetMapping(value = "/{menuCode}")
    public String findMenuByCode(@PathVariable int menuCode, Model model){
        MenuDTO resultMenu = menuService.findMenuByMenuCode(menuCode);
        model.addAttribute("menu", resultMenu);
        return "menu/detail";
    }
}
