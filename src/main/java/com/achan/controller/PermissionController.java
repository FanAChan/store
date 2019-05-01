package com.achan.controller;

import com.achan.common.CommonResponse;
import com.achan.entity.PermissionVo;
import com.achan.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

/**
 * @author AChan
 * @title: PermissionController
 * @date 2019/4/19
 */
@RestController
@RequestMapping("/permission")
public class PermissionController {

    @Autowired
    private PermissionService permissionService;


    @GetMapping("/all")
    public CommonResponse getAll() {
        List<PermissionVo> permissionVoList = permissionService.getAllPermission();
        HashMap<String, Object> data = new HashMap<>();
        data.put("permissionVoList", permissionVoList);
        return CommonResponse.success(data);
    }

    @GetMapping("/page")
    public CommonResponse page(@RequestParam(required = false) PermissionVo permissionVo, int pageNum, int pageSize) {
        List<PermissionVo> permissionVoList = permissionService.getPermissionPage(permissionVo, pageNum, pageSize);
        HashMap<String, Object> data = new HashMap<>();
        data.put("page", permissionVoList);
        return CommonResponse.success(data);
    }
}
