package com.xxml.admin.service;


import com.xxml.admin.bean.City;

public interface CityService {
    public City getById(Long id);

    public void insertCity(City city);

}
