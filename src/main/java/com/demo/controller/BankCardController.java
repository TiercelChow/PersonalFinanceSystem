package com.demo.controller;


import com.demo.common.Msg;
import com.demo.pojo.BankCard;
import com.demo.service.BankCardService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@Controller
public class BankCardController {
    @Autowired
    private BankCardService bankCardService;

//银行卡管理界面
    @RequestMapping("/bankcardlist")
    public String  selectUserAll(@RequestParam(value = "pageNum",defaultValue = "1") Integer pageNum,
                                 @RequestParam(value = "pageSize",defaultValue = "5") Integer pageSize,
                                 Model model, Map<String,Object> top)
    {
        //
        PageHelper.startPage(pageNum,pageSize);
        List<BankCard> list=bankCardService.selectBankCardAll();
        //
        PageInfo<BankCard> pageInfo=new PageInfo<BankCard>(list);
        model.addAttribute("bankcardPageInfo",pageInfo);
        model.addAttribute("bankcardlist",list);
        model.addAttribute("activeUrl","indexActive");
        model.addAttribute("activeUrl1","userInfoActive");
        model.addAttribute("activeUrl2","bankcardActive");
        model.addAttribute("username","username");
        top.put("pageTopBarInfo","银行卡管理界面");



        //ModelAndView modelAndView=new ModelAndView("userinfo","list",userService.selectUserAll());

        return "/admin/userinfo/bankcard";
    }
    @RequestMapping("/admin/getBankCardById/{id}")
    @ResponseBody
    public Msg selectUserById(@PathVariable("id") Integer id){
        BankCard bankCard = bankCardService.selectGetBankCardById(id);
        return Msg.success().add("bankcard",bankCard);
    }
    @RequestMapping("/admin/updateBankCard/{id}")
    @ResponseBody
    public Msg updateBankCard(@PathVariable("id") Integer id, BankCard bankCard) {
        bankCard.setId(id);
        int i=bankCardService.updateBankCard(bankCard);
        if(i==1){
            return Msg.success();
        }else {
            return Msg.fail();
        }
    }

    @RequestMapping("/admin/deleteBankCard/{id}")
    @ResponseBody

    public Msg deleteBankCard(@PathVariable("id") Integer id, BankCard bankCard){
        int i=bankCardService.deleteBankCard(bankCard);
        if(i==1){
            return Msg.success();
        }else {
            return Msg.fail();
        }
    }
    @RequestMapping("/mybankcard")
    public String  selectBankCardAll(@RequestParam(value = "pageNum",defaultValue = "1") Integer pageNum,
                                     @RequestParam(value = "pageSize",defaultValue = "5") Integer pageSize,
                                     Model model, HttpServletRequest request, Map<String,Object> top)
    {
        Integer userId=(Integer) request.getSession().getAttribute("loginUser");
        //
        PageHelper.startPage(pageNum,pageSize);
        List<BankCard> list=bankCardService.selectBankCardById(userId);
        //
        PageInfo<BankCard> pageInfo=new PageInfo<BankCard>(list);

        model.addAttribute("bankCardList",list);
        model.addAttribute("activeUrl","indexActive");
        model.addAttribute("activeUrl1","personalActive");
        model.addAttribute("activeUrl2","bankCardActive");
        model.addAttribute("username","username");
        top.put("pageTopBarInfo","银行卡管理界面");



        //ModelAndView modelAndView=new ModelAndView("userinfo","list",userService.selectUserAll());

        return "user/personal/bankcard";
    }
    @RequestMapping("/user/addBankCard")
    @ResponseBody
    public Msg insertBankCard(BankCard bankCard, HttpServletRequest request){
        Integer userId=(Integer) request.getSession().getAttribute("loginUser");
        bankCard.setUserId(userId);
        int i=bankCardService.insertBankCard(bankCard);
        if(i==1){
            return Msg.success();
        }else {
            return Msg.fail();
        }
    }

    @RequestMapping("/user/getUserBankCardById/{id}")
    @ResponseBody
    public Msg selectUserBankById(@PathVariable("id") Integer id){
        BankCard bankCard = bankCardService.selectUserBankCardById(id);
        return Msg.success().add("bankCard",bankCard);
    }
    @RequestMapping("/user/updateUserBankCard/{id}")
    @ResponseBody
    public Msg updateUserBankCard(@PathVariable("id") Integer id, BankCard bankCard) {
        bankCard.setId(id);
        int i=bankCardService.updateUserBankCard(bankCard);
        if(i==1){
            return Msg.success();
        }else {
            return Msg.fail();
        }
    }
    @RequestMapping("/user/deleteUserBankCard/{id}")
    @ResponseBody

    public Msg deleteUserBankCard(@PathVariable("id") Integer id, BankCard bankCard){
        int i=bankCardService.deleteUserBankCard(bankCard);
        if(i==1){
            return Msg.success();
        }else {
            return Msg.fail();
        }
    }


}
