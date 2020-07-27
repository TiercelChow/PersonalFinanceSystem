package com.demo.controller;


import com.demo.common.Msg;
import com.demo.pojo.Bank;
import com.demo.service.BankService;
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
public class BankController {
    @Autowired
    private BankService bankService;

    @RequestMapping("/bank")
    public String  selectUserAll(@RequestParam(value = "pageNum",defaultValue = "1") Integer pageNum,
                                 @RequestParam(value = "pageSize",defaultValue = "5") Integer pageSize,
                                 Model model, Map<String,Object> top)
    {
        //
        PageHelper.startPage(pageNum,pageSize);
        List<Bank> list=bankService.selectBankAll();
        //
        PageInfo<Bank> pageInfo=new PageInfo<Bank>(list);
        model.addAttribute("finacnePageInfo",pageInfo);
        model.addAttribute("financeList",list);
        model.addAttribute("activeUrl","indexActive");
        model.addAttribute("activeUrl1","financeActive");
        model.addAttribute("activeUrl2","bankctive");
        model.addAttribute("username","username");
        top.put("pageTopBarInfo","推荐银行管理界面");
        //ModelAndView modelAndView=new ModelAndView("userinfo","list",userService.selectUserAll());

        return "admin/finance/bank";
    }
    @RequestMapping("/admin/addBank")
    @ResponseBody
    public Msg insertBank(Bank bank){
        int i=bankService.addBank(bank);
        if(i==1){
            return Msg.success();
        }else {
            return Msg.fail();
        }
    }
    @RequestMapping("/admin/getBankInfoById/{id}")
    @ResponseBody
    public Msg getBankInfoById(@PathVariable("id") Integer id) {
        Bank bank = bankService.selectBankById(id);
        return Msg.success().add("bank", bank);
    }
    @RequestMapping("/admin/updateBank/{id}")
    @ResponseBody
    public Msg updateBank(@PathVariable("id") Integer id,Bank bank) {
        bank.setId(id);
        int i=bankService.updateBank(bank);
        if(i==1){
            return Msg.success();
        }else {
            return Msg.fail();
        }
    }
    @RequestMapping("/admin/deleteBankById/{id}")
    @ResponseBody

    public Msg deleteBankById(@PathVariable("id") Integer id,Bank bank){
        int i=bankService.deleteBankById(bank);
        if(i==1){
            return Msg.success();
        }else {
            return Msg.fail();
        }
    }
    @RequestMapping("/userbank")
    public String  selectBankAll(@RequestParam(value = "pageNum",defaultValue = "1") Integer pageNum,
                                 @RequestParam(value = "pageSize",defaultValue = "5") Integer pageSize,
                                 Model model, Map<String,Object> top)
    {
        //
        PageHelper.startPage(pageNum,pageSize);
        List<Bank> list=bankService.selectBankAll();
        //
        PageInfo<Bank> pageInfo=new PageInfo<Bank>(list);

        model.addAttribute("bankList",list);
        model.addAttribute("activeUrl","indexActive");
        model.addAttribute("activeUrl1","financeActive");
        model.addAttribute("activeUrl2","bankActive");
        model.addAttribute("username","username");
        top.put("pageTopBarInfo","银行推荐界面");
        //ModelAndView modelAndView=new ModelAndView("userinfo","list",userService.selectUserAll());

        return "user/finance/bank";
    }
}
