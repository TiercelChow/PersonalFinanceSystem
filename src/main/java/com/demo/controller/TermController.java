package com.demo.controller;


import com.demo.common.Msg;
import com.demo.pojo.MyFinance.UserTerm;
import com.demo.pojo.Term;
import com.demo.service.TermService;
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
public class TermController {
    @Autowired
    private TermService termService;
//期限理财管理界面
    @RequestMapping("/term")
    public String  selectUserAll(@RequestParam(value = "pageNum",defaultValue = "1") Integer pageNum,
                                 @RequestParam(value = "pageSize",defaultValue = "5") Integer pageSize,
                                 Model model, Map<String,Object> top)
    {
        //
        PageHelper.startPage(pageNum,pageSize);
        List<Term> list=termService.selectTermAll();
        //
        PageInfo<Term> pageInfo=new PageInfo<Term>(list);
        model.addAttribute("finacnePageInfo",pageInfo);
        model.addAttribute("financeList",list);
        model.addAttribute("activeUrl","indexActive");
        model.addAttribute("activeUrl1","financeActive");
        model.addAttribute("activeUrl2","termfinancialActive");
        model.addAttribute("username","username");
        top.put("pageTopBarInfo","期限理财管理界面");
        //ModelAndView modelAndView=new ModelAndView("userinfo","list",userService.selectUserAll());

        return "admin/finance/termfinancial";
    }
    @RequestMapping("/admin/addTermFinancial")
    @ResponseBody
    public Msg insertTerm(Term term){
        int i=termService.addTerm(term);
        if(i==1){
            return Msg.success();
        }else {
            return Msg.fail();
        }
    }
    @RequestMapping("/admin/getTermFinancialInfoById/{id}")
    @ResponseBody
    public Msg getTermInfoById(@PathVariable("id") Integer id) {
        Term term = termService.selectTermById(id);
        return Msg.success().add("term", term);
    }
    @RequestMapping("/admin/updateTermFinancial/{id}")
    @ResponseBody
    public Msg updateTermProfile(@PathVariable("id") Integer id, Term term) {
        term.setId(id);
        int i=termService.updateTerm(term);
        if(i==1){
            return Msg.success();
        }else {
            return Msg.fail();
        }
    }
    @RequestMapping("/admin/deleteTermFinancialById/{id}")
    @ResponseBody

    public Msg deleteTermById(@PathVariable("id") Integer id,Term term){
        int i=termService.deleteTermById(term);
        if(i==1){
            return Msg.success();
        }else {
            return Msg.fail();
        }
    }
    @RequestMapping("/userterm")
    public String  selectTermAll(@RequestParam(value = "pageNum",defaultValue = "1") Integer pageNum,
                                 @RequestParam(value = "pageSize",defaultValue = "5") Integer pageSize,
                                 Model model, Map<String,Object> top)
    {
        //
        PageHelper.startPage(pageNum,pageSize);
        List<Term> list=termService.selectTermAll();
        //
        PageInfo<Term> pageInfo=new PageInfo<Term>(list);

        model.addAttribute("termFinancialList",list);
        model.addAttribute("activeUrl","indexActive");
        model.addAttribute("activeUrl1","financeActive");
        model.addAttribute("activeUrl2","termFinancialActive");
        model.addAttribute("username","username");
        top.put("pageTopBarInfo","期限理财界面");
        //ModelAndView modelAndView=new ModelAndView("userinfo","list",userService.selectUserAll());

        return "user/finance/termfinancial";
    }

    @RequestMapping("/user/buyTermFinancial")
    @ResponseBody
    public Msg insertTermMoney(UserTerm userTerm){
        int i=termService.addTermMoney(userTerm);
        if(i==1){
            return Msg.success();
        }else {
            return Msg.fail();
        }
    }
}
