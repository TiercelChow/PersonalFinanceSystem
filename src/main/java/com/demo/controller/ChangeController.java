package com.demo.controller;


import com.demo.common.Msg;
import com.demo.pojo.Change;
import com.demo.service.ChangeService;
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
public class ChangeController {
    @Autowired
    private ChangeService changeService;

//零钱理财管理界面
    @RequestMapping("/change")
    public String  selectUserAll(@RequestParam(value = "pageNum",defaultValue = "1") Integer pageNum,
                                 @RequestParam(value = "pageSize",defaultValue = "5") Integer pageSize,
                                 Model model, Map<String,Object> top)
    {
        //
        PageHelper.startPage(pageNum,pageSize);
        List<Change> list= changeService.selectChangeAll();
        //
        PageInfo<Change> pageInfo=new PageInfo<Change>(list);
        model.addAttribute("finacnePageInfo",pageInfo);
        model.addAttribute("financeList",list);
        model.addAttribute("activeUrl","indexActive");
        model.addAttribute("activeUrl1","financeActive");
        model.addAttribute("activeUrl2","changemoneyActive");
        model.addAttribute("username","username");
        top.put("pageTopBarInfo","零钱理财管理界面");
        //ModelAndView modelAndView=new ModelAndView("userinfo","list",userService.selectUserAll());

        return "admin/finance/changemoney";
    }

    @RequestMapping("/admin/addChangeMoney")
    @ResponseBody
    public Msg insertChange(Change change){
        int i=changeService.addChange(change);
        if(i==1){
            return Msg.success();
        }else {
            return Msg.fail();
        }
    }
    @RequestMapping("/admin/getChangeMoneyInfoById/{id}")
    @ResponseBody
    public Msg getChangeInfoById(@PathVariable("id") Integer id) {
        Change change = changeService.selectChangeById(id);
        return Msg.success().add("change", change);
    }
    @RequestMapping("/admin/updateChangeMoney/{id}")
    @ResponseBody
    public Msg updateChangeProfile(@PathVariable("id") Integer id, Change change) {
        change.setId(id);
        int i=changeService.updateChange(change);
        if(i==1){
            return Msg.success();
        }else {
            return Msg.fail();
        }
    }
    @RequestMapping("/admin/deleteChangeMoneyById/{id}")
    @ResponseBody

    public Msg deleteChangeById(@PathVariable("id") Integer id,Change change){
        int i=changeService.deleteChangeById(change);
        if(i==1){
            return Msg.success();
        }else {
            return Msg.fail();
        }
    }
}
