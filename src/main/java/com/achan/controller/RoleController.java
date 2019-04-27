package com.achan.controller;

import com.achan.common.CommonResponse;
import com.achan.entity.RoleVo;
import com.achan.service.RoleService;
import com.achan.util.UUIDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

/**
 * @author AChan
 * @title: RoleController
 * @date 2019/4/19
 */
@RestController
@RequestMapping("/role")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @PostMapping("/add")
    public CommonResponse add(RoleVo roleVo) {
        roleVo.setId(UUIDUtil.randomID());
        int add = roleService.add(roleVo);
        if (add == 0) {
            return CommonResponse.operationFailed();
        }
        return CommonResponse.operationSuccess();
    }

    @PostMapping("/delete")
    public CommonResponse delete(String id) {
        int delete = roleService.delete(id);
        if (delete == 0) {
            return CommonResponse.operationFailed();
        }
        return CommonResponse.operationSuccess();
    }

    @PostMapping("/update")
    public CommonResponse update(RoleVo roleVo) {
        int update = roleService.update(roleVo);
        if (update == 0) {
            return CommonResponse.operationFailed();
        }
        return CommonResponse.operationSuccess();
    }

    @GetMapping("/page")
    public CommonResponse page(RoleVo roleVo, int page, int num) {
        List<RoleVo> roleVoList = roleService.pageRole(roleVo, page, num);
        HashMap<String, Object> data = new HashMap<>();
        data.put("page", roleVoList);
        return CommonResponse.success(data);
    }

    @GetMapping("/all")
    public CommonResponse getAll() {
        List<RoleVo> roleVoList = roleService.getAll();
        HashMap<String, Object> data = new HashMap<>();
        data.put("roleVoList", roleVoList);
        return CommonResponse.success(data);
    }

    @GetMapping("/detail")
    public CommonResponse detail(String id) {
        RoleVo roleVo = roleService.getById(id);
        HashMap<String, Object> data = new HashMap<>();
        data.put("roleVo", roleVo);
        return CommonResponse.success(data);
    }


}
