package com.test.ssm.controller;

import com.aliyun.oss.OSSClient;
import com.test.ssm.pojo.Hotel;
import com.test.ssm.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author 徒有琴
 */
@Controller
public class HotelController {

    @Autowired
    private HotelService hotelService;
    @Value("${aliyun.oss.endpoint}")
    private String endpoint;
    @Value("${aliyun.oss.accessKeyId}")
    private String accessKeyId;
    @Value("${aliyun.oss.accessKeySecret}")
    private String accessKeySecret;
    @Value("${aliyun.oss.url}")
    private String url;

    @RequestMapping("add.html")
    public String add(Hotel hotel, @RequestParam(name = "file") MultipartFile file) {
        String name = upload(file);
        hotel.setImage(name);

        hotelService.addHotel(hotel);
        return "add";
    }

    @RequestMapping("goadd.html")
    public String goAdd() {
        return "add";
    }

    @RequestMapping("upload.html")
    @ResponseBody
    public String uploadImg(@RequestParam(name = "file") MultipartFile file) {
        String url = upload(file);
        String json = "{\"error\":0,\"url\":\"" + url + "\"}";
        return json;
    }

    public String upload(MultipartFile file) {
        // 创建OSSClient实例。
        OSSClient ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret);
        // 上传文件流。
        // File file = new File("d:/upload/timg.jfif");

        long time = System.currentTimeMillis();
        String extName = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
        String fileName = time + extName;
        try {
            InputStream inputStream = file.getInputStream();
            ossClient.putObject("wq1901", fileName, inputStream);
            // 关闭OSSClient。
            ossClient.shutdown();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return url + fileName;
    }

    @RequestMapping("detail.html")
    public String detail(Integer id, Model model) {
        Hotel hotel = hotelService.getHotelById(id);
        model.addAttribute("hotel", hotel);
        return "detail";
    }

}
