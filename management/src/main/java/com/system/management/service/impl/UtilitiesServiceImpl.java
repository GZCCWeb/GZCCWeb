package com.system.management.service.impl;

import com.system.management.service.UtilitiesService;
import com.system.management.dao.UtilitiesMapper;
import com.system.management.model.Fee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("utilitiesServiceImpl")  //表示service层

public class UtilitiesServiceImpl implements UtilitiesService {

    @Autowired
    private UtilitiesMapper utilitiesMapper; //用AutoWired注入DB层

    @Transactional  //读取数据库
   @Override
    public List<Fee> getAll() {
        return utilitiesMapper.getAll();
    }

    @Override
    public Integer insert(Fee fee) {
       return utilitiesMapper.insert(fee);
    }

    @Override
    public Integer update(Fee fee) {

        return utilitiesMapper.update(fee);
    }

    @Override
    public int deleteById(Integer id) {
        return utilitiesMapper.deleteById(id);

    }




}

