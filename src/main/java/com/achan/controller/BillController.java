package com.achan.controller;

import com.achan.common.CommonResponse;
import com.achan.entity.BillVo;
import com.achan.service.BillService;
import com.achan.util.UUIDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

/**
 * @author AChan
 * @title: BillController
 * @date 2019/4/19
 */
@RestController
@RequestMapping("/bill")
public class BillController {
    @Autowired
    private BillService billService;

    @PostMapping("/add")
    public CommonResponse add(BillVo billVo) {
        billVo.setId(UUIDUtil.randomID());
        int add = billService.add(billVo);
        if (add == 0) {
            return CommonResponse.operationFailed();
        }
        return CommonResponse.operationSuccess();
    }

    @PostMapping("/delete")
    public CommonResponse delete(String id) {
        int delete = billService.delete(id);
        if (delete == 0) {
            return CommonResponse.operationFailed();
        }
        return CommonResponse.operationSuccess();
    }
    @PostMapping("/update")
    public CommonResponse update(BillVo billVo) {
        int update = billService.update(billVo);
        if (update == 0) {
            return CommonResponse.operationFailed();
        }
        return CommonResponse.operationSuccess();
    }

    @GetMapping("/page")
    public CommonResponse page(@RequestParam(required = false) BillVo billVo, int pageNum, int pageSize) {
        List<BillVo> billVoPage = billService.getBillVoPage(billVo, pageNum, pageSize);
        HashMap<String, Object> data = new HashMap<>();
        data.put("page", billVoPage);
        return CommonResponse.success(data);
    }

    @GetMapping("/detail")
    public CommonResponse detail(String id) {
        BillVo billVo = billService.getBillVoDetail(id);
        HashMap<String, Object> data = new HashMap<>();
        data.put("billVo", billVo);
        return CommonResponse.success(data);
    }
}
