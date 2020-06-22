package com.ctgu.sell.controller;


import com.ctgu.sell.dataobject.OrderDetail;
import com.ctgu.sell.dto.OrderDTO;
import com.ctgu.sell.service.impl.OrderServiceImpl;
import lombok.extern.slf4j.Slf4j;
import net.sf.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/wx")
@Slf4j
public class wxController {

    @Autowired
    private OrderServiceImpl orderService;

    @RequestMapping(value = "wxlogin.do")
    public String wxlogin(String name, HttpSession session, HttpServletRequest req, HttpServletResponse resp, Model model) {
        resp.setContentType("text/json");
        resp.setCharacterEncoding("utf-8");
        String address = (String) req.getParameter("address");
        String phone = req.getParameter("phone");
        String things = req.getParameter("things");
        JSONArray buythings = JSONArray.fromObject(things);
        System.out.println(name);
        System.out.println(address);
        //System.out.println(things.getJSONObject(0).get("name"));
        System.out.println(phone);
        System.out.println(buythings);
        PrintWriter pw = null;
        Map map = new HashMap();
        map.put("name", name);
        map.put("address", address);
        map.put("phone", phone);
        map.put("things", things);


        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setBuyerName(name);
        orderDTO.setBuyerAddress(address);
        orderDTO.setBuyerPhone(phone);
        orderDTO.setBuyerOpenid("110110110110");

        //购物车
        List<OrderDetail> orderDetailList = new ArrayList<>();

        for(int i = 0; i < buythings.size(); i ++){
            OrderDetail orderDetail = new OrderDetail();
            orderDetail.setProductId((String) buythings.getJSONObject(i).get("id"));
            orderDetail.setProductQuantity((Integer) buythings.getJSONObject(i).get("quantity"));
            orderDetailList.add(orderDetail);
        }
        orderDTO.setOrderDetailList(orderDetailList);
        OrderDTO result = orderService.create(orderDTO);
        System.out.println("=======订单创建成功========");



        JSONArray json = JSONArray.fromObject(map);
        try {
            pw = resp.getWriter();
            pw.print(json);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (pw != null)
                pw.close();
        }
        return null;
    }
}
