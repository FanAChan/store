package com.achan.controller;

import com.achan.common.CommonResponse;
import com.achan.common.StoreException;
import com.achan.entity.UserVo;
import com.achan.entity.base.UserBase;
import com.achan.service.UserService;
import com.achan.util.Encryptor;
import com.achan.util.UUIDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

/**
 * @author AChan
 * @title: UserController
 * @description: TODO
 * @date 2019/4/118:51
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    public UserService userService;

    @GetMapping("/login")
    public CommonResponse login(String phone, String password) {
        UserVo userVo = userService.getByPhone(phone);
        String credential = Encryptor.createCredential(phone, password);
        if (ObjectUtils.isEmpty(userVo) || !userVo.getPassword().equals(credential)) {
            return CommonResponse.operationFailed("用户名或密码错误");
        }

        return CommonResponse.operationSuccess();
    }

    @GetMapping("/test")
    public String test() {
        return "hello world";
    }


    @PostMapping({"/add", "/register"})
    public CommonResponse add(UserVo userVo) {
        userVo.setId(UUIDUtil.randomID());
        int add = userService.add(userVo);
        if (add == 0) {
            return CommonResponse.operationFailed();
        }
        return CommonResponse.operationSuccess();
    }

    @PostMapping("/delete")
    public CommonResponse delete(String id) {
        int delete = userService.delete(id);
        if (delete == 0) {
            return CommonResponse.operationFailed();
        }
        return CommonResponse.operationSuccess();
    }

    @PostMapping("/update")
    public CommonResponse update(UserVo userVo) {
        int update = userService.updateUserBase(userVo);
        if (update == 0) {
            return CommonResponse.operationFailed();
        }
        return CommonResponse.operationSuccess();
    }

    @GetMapping("/baseDetail")
    public CommonResponse baseDetail(String id) throws StoreException {
        UserVo userBase = userService.getUserBase(id);
        if (ObjectUtils.isEmpty(userBase)) {
            throw new StoreException();
        }
        HashMap<String, Object> data = new HashMap<>();
        data.put("userBase", userBase);
        return CommonResponse.success(data);
    }

    @GetMapping("/detail")
    public CommonResponse voDetail(String id) throws StoreException {
        UserVo userBase = userService.getUserVo(id);
        if (ObjectUtils.isEmpty(userBase)) {
            throw new StoreException();
        }
        HashMap<String, Object> data = new HashMap<>();
        data.put("userBase", userBase);
        return CommonResponse.success(data);
    }

    @GetMapping("/page")
    public CommonResponse page(@RequestParam(required = false) UserVo userVo, int pageNum, int pageSize) {
        List<UserVo> userVos = userService.selectUserVoPage(userVo, pageNum, pageSize);
        HashMap<String, Object> data = new HashMap<>();
        data.put("page", userVos);
        return CommonResponse.success(data);
    }

    @PostMapping("/verify")
    public CommonResponse verify(String id, Byte state) {
        int verify = userService.verify(id, state);
        if (verify == 0) {
            return CommonResponse.operationFailed();
        }
        return CommonResponse.operationSuccess();
    }


}
