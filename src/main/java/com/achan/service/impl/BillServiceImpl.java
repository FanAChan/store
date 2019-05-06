package com.achan.service.impl;

import com.achan.dao.BillDao;
import com.achan.dao.BillDetailDao;
import com.achan.entity.BillDetailVo;
import com.achan.entity.BillVo;
import com.achan.entity.base.BillBase;
import com.achan.entity.base.BillBaseExample;
import com.achan.service.BillService;
import com.achan.util.EntityConverter;
import com.achan.util.UUIDUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * @author AChan
 * @title: BillServiceImpl
 * @description: TODO
 * @date 2019/4/16
 */
@Service("billService")
public class BillServiceImpl implements BillService {

    @Autowired
    private BillDao billDao;

    @Autowired
    private BillDetailDao billDetailDao;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int add(BillVo billVo) {
        if (checkNumber(billVo.getNumber())) {
            return 0;
        }
        billVo.setId(UUIDUtil.randomID());
        int insert = billDao.insert(billVo);
        if (insert > 0) {
            buildBillDetailBase(billVo);
            insert = billDetailDao.batchInsert(billVo.getBillDetailVoList());
        }
        return insert;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int delete(String id) {
        BillBase billBase = new BillBase();
        billBase.setId(id);
        billBase.setDeleted(true);
        int delete = billDao.updateByPrimaryKeySelective(billBase);
        if (delete > 0) {
            delete = billDetailDao.deleteByBillId(id);
        }
        return delete;
    }

    @Override
    public int update(BillVo billVo) {
        int update = billDao.updateByPrimaryKey(billVo);
        if (update > 0) {
            billDetailDao.deleteByBillId(billVo.getId());
            buildBillDetailBase(billVo);
            update = billDetailDao.batchInsert(billVo.getBillDetailVoList());
        }
        return update;
    }


    @Override
    public PageInfo getBillVoPage(BillVo billVo, int page, int num) {

        PageHelper.startPage(page, num);
        BillBaseExample billBaseExample = new BillBaseExample();
        List<BillBase> billBases = billDao.selectByExample(billBaseExample);
        PageInfo pageInfo = new PageInfo<>(billBases);
        List<BillVo> convert = EntityConverter.convert(billBases, BillVo.class);
        pageInfo.setList(convert);
        return pageInfo;
    }

    @Override
    public BillVo getBillVoDetail(String id) {
        BillBase billBase = billDao.selectByPrimaryKey(id);
        BillVo billVo = EntityConverter.convert(billBase, BillVo.class);
        return billVo;
    }

    @Override
    public int verify(String id, Byte state) {
        BillBase billBase = new BillBase();
        billBase.setId(id);
        billBase.setState(state);
        int update = billDao.updateByPrimaryKeySelective(billBase);
        return update;
    }

    private boolean checkNumber(String number) {
        BillBaseExample billBaseExample = new BillBaseExample();
        billBaseExample.createCriteria()
                .andNumberEqualTo(number)
                .andDeletedEqualTo(false);
        int i = billDao.countByExample(billBaseExample);
        if (i > 0) {
            return true;
        }
        return false;
    }

    private void buildBillDetailBase(BillVo billVo) {

        List<BillDetailVo> billDetailVoList = billVo.getBillDetailVoList();
        billDetailVoList.stream()
                .forEach(billDetailVo -> {
                    billDetailVo.setId(UUIDUtil.randomID());
                    billDetailVo.setBillId(billVo.getId());
                });
    }

    private boolean valid(BillVo billVo) {
        if (ObjectUtils.isEmpty(billVo)) {
            return false;
        }
        String name = billVo.getName();
        String number = billVo.getNumber();
        String storehouseId = billVo.getStorehouseId();
        if (StringUtils.isEmpty(name) || name.length() > 64) {
            return false;
        }
        if (StringUtils.isEmpty(number) || number.length() > 64) {
            return false;
        }
        if (StringUtils.isEmpty(storehouseId)) {
            return false;
        }
        return true;
    }

}
