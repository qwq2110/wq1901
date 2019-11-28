package com.test.ssm.pojo;

import lombok.Data;

/**
 * @author 徒有琴
 */
@Data
public class Hotel {
    private Integer id;
    private String name;
    private String address;
    private Integer price;
    private Double lat;
    private Double lng;
    private String image;
    private String info;
}
