package com.demo.controller;


import com.demo.common.Msg;
import com.demo.pojo.Change;
import com.demo.service.ChangeService;
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
public class UserChangeController {
    @Autowired
    private ChangeService changeService;

//零钱理财界面
    @RequestMapping("/userchange")
    public String  selectUserAll(@RequestParam(value = "pageNum",defaultValue = "1") Integer pageNum,
                                 @RequestParam(value = "pageSize",defaultValue = "5") Integer pageSize,
                                 Model model, Map<String,Object> top)
    {
        //
        PageHelper.startPage(pageNum,pageSize);
        List<Change> list= changeService.selectChangeAll();
        //
        PageInfo<Change> pageInfo=new PageInfo<Change>(list);
        model.addAttribute("changeMoneyList",list);
        model.addAttribute("activeUrl","indexActive");
        model.addAttribute("activeUrl1","financeActive");
        model.addAttribute("activeUrl2","changeMoneyActive");
        model.addAttribute("username","username");
        top.put("pageTopBarInfo","零钱理财界面");
        //ModelAndView modelAndView=new ModelAndView("userinfo","list",userService.selectUserAll());

        return "user/finance/changemoney";
    }

    @RequestMapping("/user/buyChangeMoney")
    @ResponseBody
    public Msg insertChangeMoney(Change change){
        int j=changeService.insertFlowOfFund(change);
        int i=changeService.addChangeMoney(change);
        if(i==1&&j==1){
            return Msg.success();
        }else {
            return Msg.fail();
        }
    }
}
