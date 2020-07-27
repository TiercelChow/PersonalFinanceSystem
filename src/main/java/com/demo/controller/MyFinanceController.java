package com.demo.controller;


import com.demo.common.Msg;
import com.demo.pojo.MyFinance.UserChange;
import com.demo.pojo.MyFinance.UserFund;
import com.demo.pojo.MyFinance.UserPay;
import com.demo.pojo.MyFinance.UserTerm;
import com.demo.service.MyFinanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@Controller
public class MyFinanceController {
    @Autowired
    private MyFinanceService myFinanceService;


    @RequestMapping("/myfinance")
    public String myFinance(Model model, HttpServletRequest request, Map<String,Object> top){
        Integer userId=(Integer) request.getSession().getAttribute("loginUser");
        List<UserChange> userChangeList = myFinanceService.selectUserChangeByuserId(userId);
        List<UserPay> userPayList = myFinanceService.selectUserPayByuserId(userId);
        List<UserTerm> userTermList = myFinanceService.selectUserTermByuserId(userId);
        List<UserFund> userFundList = myFinanceService.selectUserFundByuserId(userId);
        model.addAttribute("userChangeMoneyList",userChangeList);
        model.addAttribute("userPayMoneyList",userPayList);
        model.addAttribute("userTermFinancialList",userTermList);
        model.addAttribute("userFundProductList",userFundList);

        request.getSession().setAttribute("myFinanceActiveUrl","changeMoneyActive");


        model.addAttribute("activeUrl","indexActive");
        model.addAttribute("activeUrl1","personalActive");
        model.addAttribute("activeUrl2","myFinanceActive");
        model.addAttribute("username","username");
        top.put("pageTopBarInfo","我的理财界面");
        return  "/user/personal/myfinance";
    }

    @RequestMapping("/user/revokeUserChangeMoney")
    @ResponseBody
    public Msg updateChangeMoney(UserChange userChange){
        int i=myFinanceService.updateUserMoney(userChange);
        if(i==1){
            return Msg.success();
        }else {
            return Msg.fail();
        }
    }
    @RequestMapping("/user/revokeUserPayMoney")
    @ResponseBody
    public Msg updatePayMoney(UserPay userPay){
        int i=myFinanceService.updatePayMoney(userPay);
        if(i==1){
            return Msg.success();
        }else {
            return Msg.fail();
        }
    }
    @RequestMapping("/user/revokeUserTermFinancial")
    @ResponseBody
    public Msg updateTermMoney(UserTerm userTerm){
        int i=myFinanceService.updateTermMoney(userTerm);
        if(i==1){
            return Msg.success();
        }else {
            return Msg.fail();
        }
    }
    @RequestMapping("/user/revokeUserFundProduct")
    @ResponseBody
    public Msg updateFundMoney(UserFund userFund){
        int i=myFinanceService.updateFundMoney(userFund);
        if(i==1){
            return Msg.success();
        }else {
            return Msg.fail();
        }
    }

}
