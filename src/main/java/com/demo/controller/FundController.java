package com.demo.controller;


import com.demo.common.Msg;
import com.demo.pojo.Fund;
import com.demo.pojo.MyFinance.UserFund;
import com.demo.service.FundService;
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
public class FundController {
    @Autowired
    private FundService fundService;
//基金理财管理界面
    @RequestMapping("/fund")
    public String  selectUserAll(@RequestParam(value = "pageNum",defaultValue = "1") Integer pageNum,
                                 @RequestParam(value = "pageSize",defaultValue = "5") Integer pageSize,
                                 Model model, Map<String,Object> top)
    {
        //
        PageHelper.startPage(pageNum,pageSize);
        List<Fund> list=fundService.selectFundAll();
        //
        PageInfo<Fund> pageInfo=new PageInfo<Fund>(list);
        model.addAttribute("finacnePageInfo",pageInfo);
        model.addAttribute("financeList",list);
        model.addAttribute("activeUrl","indexActive");
        model.addAttribute("activeUrl1","financeActive");
        model.addAttribute("activeUrl2","fundproductActive");
        model.addAttribute("username","username");
        top.put("pageTopBarInfo","基金理财管理界面");
        //ModelAndView modelAndView=new ModelAndView("userinfo","list",userService.selectUserAll());

        return "admin/finance/fundproduct";
    }
    @RequestMapping("/admin/addFundProduct")
    @ResponseBody
    public Msg insertFund(Fund fund){
        int i=fundService.addFund(fund);
        if(i==1){
            return Msg.success();
        }else {
            return Msg.fail();
        }
    }
    @RequestMapping("/admin/getFundProductInfoById/{id}")
    @ResponseBody
    public Msg getFundInfoById(@PathVariable("id") Integer id) {
        Fund fund = fundService.selectFundById(id);
        return Msg.success().add("fund", fund);
    }
    @RequestMapping("/admin/updateFundProduct/{id}")
    @ResponseBody
    public Msg updateFundProfile(@PathVariable("id") Integer id,Fund fund) {
        fund.setId(id);
        int i=fundService.updateFund(fund);
        if(i==1){
            return Msg.success();
        }else {
            return Msg.fail();
        }
    }
    @RequestMapping("/admin/deleteFundProductById/{id}")
    @ResponseBody

    public Msg deleteFundById(@PathVariable("id") Integer id,Fund fund){
        int i=fundService.deleteFundById(fund);
        if(i==1){
            return Msg.success();
        }else {
            return Msg.fail();
        }
    }
    @RequestMapping("/userfund")
    public String  selectFundAll(@RequestParam(value = "pageNum",defaultValue = "1") Integer pageNum,
                                 @RequestParam(value = "pageSize",defaultValue = "5") Integer pageSize,
                                 Model model, Map<String,Object> top)
    {
        //
        PageHelper.startPage(pageNum,pageSize);
        List<Fund> list=fundService.selectFundAll();
        //
        PageInfo<Fund> pageInfo=new PageInfo<Fund>(list);

        model.addAttribute("fundProductList",list);
        model.addAttribute("activeUrl","indexActive");
        model.addAttribute("activeUrl1","financeActive");
        model.addAttribute("activeUrl2","fundProductActive");
        model.addAttribute("username","username");
        top.put("pageTopBarInfo","基金理财管理界面");
        //ModelAndView modelAndView=new ModelAndView("userinfo","list",userService.selectUserAll());

        return "user/finance/fundproduct";
    }
    @RequestMapping("/user/buyFundProduct")
    @ResponseBody
    public Msg insertFundMoney(UserFund userFund){
        int j=fundService.insertFlowOfFund(userFund);
        int i=fundService.addFundMoney(userFund);
        if(i==1&&j==1){
            return Msg.success();
        }else {
            return Msg.fail();
        }
    }

}
