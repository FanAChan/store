package com.achan.controller;

import com.achan.common.CommonResponse;
import com.achan.entity.StoreHouseStockVo;
import com.achan.entity.UserVo;
import com.achan.service.StorehouseStockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;

/**
 * @author AChan
 * @title: StorehouseStockController
 * @date 2019/4/19
 */
@RestController
@RequestMapping("stock")
public class StorehouseStockController {

    @Autowired
    private StorehouseStockService storehouseStockService;


    @GetMapping("/page")
    public CommonResponse page(HttpServletRequest request, @RequestBody(required = false) StoreHouseStockVo storeHouseStockVo,
                               int pageNum, int pageSize) {
        HttpSession session = request.getSession();
        //开发测试
//        UserVo user = (UserVo) session.getAttribute("user");
//        String userId = user.getId();
        String userId = "5ff94ac96f9e4a80ac13a166779356c9";
        List<StoreHouseStockVo> page = storehouseStockService.page(userId, storeHouseStockVo, pageNum, pageSize);
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("page", page);
        return CommonResponse.success(hashMap);
    }

}
