package com.xxml.admin.service.impl;


import com.xxml.admin.bean.City;
import com.xxml.admin.mapper.CityMapper;
import com.xxml.admin.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CityServiceImpl implements CityService {

    @Autowired
    CityMapper cityMapper;


    @Override
    public City getById(Long id) {
        return null;
    }

    @Override
    public void insertCity(City city) {

    }
}
