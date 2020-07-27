package com.demo.controller;

import com.demo.pojo.FundFlow;
import com.demo.service.FundFlowService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@Controller
public class FundFlowController {
    @Autowired
    private FundFlowService fundFlowService;


    @RequestMapping("/user/record")
    public String  selectFundFlowAll(@RequestParam(value = "pageNum",defaultValue = "1") Integer pageNum,
                                     @RequestParam(value = "pageSize",defaultValue = "5") Integer pageSize,
                                     Model model, HttpServletRequest request, Map<String,Object> top)
    {
        //
        Integer fundFlowId=(Integer) request.getSession().getAttribute("loginUser");
        PageHelper.startPage(pageNum,pageSize);
        List<FundFlow> list=fundFlowService.selectFundFlowAll(fundFlowId);
        //
        PageInfo<FundFlow> pageInfo=new PageInfo<FundFlow>(list);
        model.addAttribute("flowOfFundsPageInfo",pageInfo);
        model.addAttribute("flowList",list);
        model.addAttribute("activeUrl","indexActive");
        model.addAttribute("activeUrl1","toolsActive");
        model.addAttribute("activeUrl2","recordActive");
        model.addAttribute("username","username");
        top.put("pageTopBarInfo","资金记录界面");
        return "/user/tools/record";
    }
}
