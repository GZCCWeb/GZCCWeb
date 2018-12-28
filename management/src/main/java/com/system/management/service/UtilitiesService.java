package com.system.management.service;

import com.system.management.model.Fee;

import java.util.List;

public interface UtilitiesService {

    List<Fee> getAll();
    Integer insert(Fee fee);
    Integer update(Fee fee);
    int deleteById(Integer id);

}
