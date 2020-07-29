package com.demo.controller;

import com.demo.common.Msg;
import com.demo.pojo.Pay;
import com.demo.service.PayService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
public class UserPayController {
    @Autowired
    private PayService payService;
//工资理财界面
    @RequestMapping("/userpay")
    public String  selectUserAll(@RequestParam(value = "pageNum",defaultValue = "1") Integer pageNum,
                                 @RequestParam(value = "pageSize",defaultValue = "5") Integer pageSize,
                                 Model model, Map<String,Object> top)
    {
        //
        PageHelper.startPage(pageNum,pageSize);
        List<Pay> list=payService.selectPayAll();
        //
        PageInfo<Pay> pageInfo=new PageInfo<Pay>(list);

        model.addAttribute("payMoneyList",list);
        model.addAttribute("activeUrl","indexActive");
        model.addAttribute("activeUrl1","financeActive");
        model.addAttribute("activeUrl2","payMoneyActive");
        model.addAttribute("username","username");
        top.put("pageTopBarInfo","工资理财界面");
        //ModelAndView modelAndView=new ModelAndView("userinfo","list",userService.selectUserAll());

        return "user/finance/paymoney";
    }

    @RequestMapping("/user/buyPayMoney")
    @ResponseBody
    public Msg insertPayMoney(Pay pay){
        int i=payService.addPayMoney(pay);
        if(i==1){
            return Msg.success();
        }else {
            return Msg.fail();
        }
    }


}
