package com.test.ssm.service;

import com.test.ssm.pojo.Hotel;

public interface HotelService {
    void addHotel(Hotel hotel);
    Hotel getHotelById(Integer id);
}
