package com.test.ssm.service.impl;

import com.test.ssm.dao.HotelDAO;
import com.test.ssm.pojo.Hotel;
import com.test.ssm.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author 徒有琴
 */
@Service
public class HotelServiceImpl implements HotelService {
    @Autowired
    private HotelDAO hotelDAO;

    @Override
    public void addHotel(Hotel hotel) {
        hotelDAO.addHotel(hotel);
    }

    @Override
    public Hotel getHotelById(Integer id) {
        return hotelDAO.getHotelById(id);
    }
}
