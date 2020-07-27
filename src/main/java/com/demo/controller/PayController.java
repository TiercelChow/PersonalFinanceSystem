package com.demo.controller;


import com.demo.common.Msg;
import com.demo.pojo.Pay;
import com.demo.service.PayService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
public class PayController {
    @Autowired
    private PayService payService;


    @RequestMapping("/pay")
    public String  selectUserAll(@RequestParam(value = "pageNum",defaultValue = "1") Integer pageNum,
                                 @RequestParam(value = "pageSize",defaultValue = "5") Integer pageSize,
                                 Model model, Map<String,Object> top)
    {
        //
        PageHelper.startPage(pageNum,pageSize);
        List<Pay> list=payService.selectPayAll();
        //
        PageInfo<Pay> pageInfo=new PageInfo<Pay>(list);
        model.addAttribute("finacnePageInfo",pageInfo);
        model.addAttribute("financeList",list);
        model.addAttribute("activeUrl","indexActive");
        model.addAttribute("activeUrl1","financeActive");
        model.addAttribute("activeUrl2","paymoneyActive");
        model.addAttribute("username","username");
        top.put("pageTopBarInfo","工资理财管理界面");
        //ModelAndView modelAndView=new ModelAndView("userinfo","list",userService.selectUserAll());

        return "admin/finance/paymoney";
    }

    @RequestMapping("/admin/addPayMoney")
    @ResponseBody
    public Msg insertPay(Pay pay){
        int i=payService.addPay(pay);
        if(i==1){
            return Msg.success();
        }else {
            return Msg.fail();
        }
    }
    @RequestMapping("/admin/getPayMoneyInfoById/{id}")
    @ResponseBody
    public Msg getPayInfoById(@PathVariable("id") Integer id) {
        Pay pay = payService.selectPayById(id);
        return Msg.success().add("pay", pay);
    }
    @RequestMapping("/admin/updatePayMoney/{id}")
    @ResponseBody
    public Msg updatePayProfile(@PathVariable("id") Integer id, Pay pay) {
        pay.setId(id);
        int i=payService.updatePay(pay);
        if(i==1){
            return Msg.success();
        }else {
            return Msg.fail();
        }
    }
    @RequestMapping("/admin/deletePayMoneyById/{id}")
    @ResponseBody

    public Msg deletePayById(@PathVariable("id") Integer id,Pay pay){
        int i=payService.deletePayById(pay);
        if(i==1){
            return Msg.success();
        }else {
            return Msg.fail();
        }
    }
}
