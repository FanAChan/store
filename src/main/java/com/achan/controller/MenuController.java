package com.achan.controller;

import com.achan.common.CommonResponse;
import com.achan.entity.MenuVo;
import com.achan.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

/**
 * @author AChan
 * @title: MenuController
 * @date 2019/4/19
 */
@RestController
@RequestMapping("/menu")
public class MenuController {

    @Autowired
    private MenuService menuService;

    @GetMapping("/all")
    public CommonResponse getAll() {
        List<MenuVo> all = menuService.getAll();
        HashMap<String, Object> data = new HashMap<>();
        data.put("menuVoList", all);
        return CommonResponse.success(data);
    }

    @GetMapping("/page")
    public CommonResponse page(@RequestParam(required = false) MenuVo menuVo, int pageNum, int pageSize) {
        List<MenuVo> menuVoPage = menuService.getPage(menuVo, pageNum, pageSize);
        HashMap<String, Object> data = new HashMap<>();
        data.put("page", menuVoPage);
        return CommonResponse.success(data);
    }

    @GetMapping("/detail")
    public CommonResponse detail(String id) {
        MenuVo menuVo = menuService.getById(id);
        HashMap<String, Object> data = new HashMap<>();
        data.put("menuVo", menuVo);
        return CommonResponse.success(data);
    }
}
