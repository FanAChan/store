package com.achan.util;

import com.achan.common.StoreException;
import org.springframework.beans.BeanUtils;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author AChan
 * @title: EntityConverter
 * @date 2019/4/20
 */
public class EntityConverter {


    /**
     * 实体对象转换，复制相同字段
     *
     * @param source
     * @param clazz
     * @return V
     * @Author AChan
     * @Date 2019/4/20 2:03
     **/
    public static <D, V extends D> V convert(D source, Class<V> clazz) {
        if (ObjectUtils.isEmpty(source)) {
            return null;
        }
        V result = null;
        try {
            result = clazz.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        BeanUtils.copyProperties(source, result);
        return result;
    }

    /**
     * 实体对象数组转换，复制相同字段
     *
     * @param source
     * @param clazz
     * @return V
     * @Author AChan
     * @Date 2019/4/20 2:03
     **/
    public static <D, V extends D> List<V> convert(List<D> source, Class<V> clazz) {
        if (CollectionUtils.isEmpty(source)) {
            return null;
        }
        List<V> result = source.stream().map(d -> convert(d, clazz))
                .collect(Collectors.toList());
        return result;
    }

}
