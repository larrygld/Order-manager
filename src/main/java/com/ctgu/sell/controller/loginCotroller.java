package com.ctgu.sell.controller;


import com.ctgu.sell.dataobject.SellerInfo;
import com.ctgu.sell.exception.SellException;
import com.ctgu.sell.repository.SellerInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.Map;

@RestController
@RequestMapping("/seller")
public class loginCotroller {

    @Autowired
    SellerInfoRepository sellerInfoRepository;

    @RequestMapping("/login")
    public ModelAndView login() {
        return new ModelAndView("login/login");
    }


    @RequestMapping("/check")
    public ModelAndView check(@RequestParam("username") String username,
                              @RequestParam("password") String password,
                              Map<String, Object> map,
                              HttpSession session) {
        SellerInfo sellerInfo = sellerInfoRepository.findByUsernameAndPassword(username, password);
        if(sellerInfo == null) {
            map.put("msg", "用户名或密码错误！");
           // map.put("url", "/sell/seller/login");
            return new ModelAndView("login/login", map);
        }
        else {
            session.setAttribute("loginUser", username);
            map.put("url", "/sell/seller/product/list");
            return new ModelAndView("common/success", map);
        }
    }


}
