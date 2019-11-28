package com.test.ssm.dao;

import com.test.ssm.pojo.Hotel;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface HotelDAO {
    void addHotel(Hotel hotel);

    Hotel getHotelById(Integer id);
}
