package com.demo.controller;

import com.demo.common.Msg;
import com.demo.pojo.Info;
import com.demo.service.InfoService;
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
public class InfoController {
    @Autowired
    private InfoService infoService;

    //我的消息界面
    @RequestMapping("/user/personal/myinfo")
    public String  selectInfoById(@RequestParam(value = "pageNum",defaultValue = "1") Integer pageNum,
                                  @RequestParam(value = "pageSize",defaultValue = "5") Integer pageSize,
                                  Model model, HttpServletRequest request, Map<String,Object> top)
    {
        //
        PageHelper.startPage(pageNum,pageSize);
        Integer InfoId=(Integer)request.getSession().getAttribute("loginUser");
        List<Info> list=infoService.SelectInfoById(InfoId);
        PageInfo<Info> pageInfo=new PageInfo<Info>(list);
        model.addAttribute("infoPageInfo",pageInfo);
        model.addAttribute("infoList",list);
        top.put("pageTopBarInfo","我的消息界面");
        return "user/personal/myinfo";
    }

    @RequestMapping("/user/personal/infoRead/{id}")
    @ResponseBody
    public Msg updateInfoStatus(@PathVariable("id") Integer id, Info info) {
        info.setId(id);
        int i=infoService.UpdateInfoStatus(info);
        if(i==1){
            return Msg.success();
        }else {
            return Msg.fail();
        }
    }

    @RequestMapping("/user/personal/infoDelete/{id}")
    @ResponseBody
    public Msg deleteInfo(@PathVariable("id") Integer id,Info info) {
        info.setId(id);
        int i=infoService.DeleteInfo(info);
        if(i==1){
            return Msg.success();
        }else{
            return Msg.fail();
        }
    }

}
