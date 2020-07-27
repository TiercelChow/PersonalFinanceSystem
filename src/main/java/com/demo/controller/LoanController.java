package com.demo.controller;

import com.demo.common.Msg;
import com.demo.pojo.Info;
import com.demo.pojo.Loan;
import com.demo.pojo.MyFinance.UserLoan;
import com.demo.service.InfoService;
import com.demo.service.LoanService;
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
public class LoanController {
    @Autowired
    private LoanService loanService;
    @Autowired
    private InfoService infoService;

    @RequestMapping("/loanexam")
    public String  selectUserAllExam(@RequestParam(value = "pageNum",defaultValue = "1") Integer pageNum,
                                     @RequestParam(value = "pageSize",defaultValue = "5") Integer pageSize,
                                     Model model, Map<String,Object> top)
    {
        //
        PageHelper.startPage(pageNum,pageSize);
        List<Loan> list=loanService.selectLoanAll();
        //
        PageInfo<Loan> pageInfo=new PageInfo<Loan>(list);
        model.addAttribute("loanPageInfo",pageInfo);
        model.addAttribute("loanlist",list);
        model.addAttribute("activeUrl","indexActive");
        model.addAttribute("activeUrl1","loanActive");
        model.addAttribute("activeUrl2","loanexamActive");
        model.addAttribute("username","username");
        top.put("pageTopBarInfo","网贷审核界面");

        //ModelAndView modelAndView=new ModelAndView("userinfo","list",userService.selectUserAll());

        return "/admin/loan/loanexam";
    }
    @RequestMapping("/loan/passApplyStatus/{id}")
    @ResponseBody
    public Msg PassApplyStatus(@PathVariable("id") Integer id,Loan loan,HttpServletRequest request){
        Integer examId=(Integer)request.getSession().getAttribute("loginUser");
        loan.setId(id);
        loan.setExamineid(examId);
        int i=loanService.updateLoan2(loan);
        Integer receiveId=loanService.SelectLoneById(id).getLoanid();
        Double amount=loanService.SelectLoneById(id).getAmount();
        Info info=new Info();
        info.setSendId(examId);
        info.setReceiveId(receiveId);
        info.setTitle("网贷审核通过");
        String username=loanService.SelectUserByLoanId(receiveId);
        String adminame=(String) request.getSession().getAttribute("username");
        String infDesc="用户"+username+"的"+amount+"元网贷申请审核通过！审核人为："+adminame;
        info.setInfoDesc(infDesc);
        int j=infoService.AddInfo(info);
        if(i+j==2){
            return Msg.success();
        }else{
            return Msg.fail();
        }
    }

    @RequestMapping("/loan/notPassApplyStatus/{id}")
    @ResponseBody
    public Msg NotPassApplyStatus(@PathVariable("id") Integer id,Loan loan,HttpServletRequest request){
        Integer examId=(Integer)request.getSession().getAttribute("loginUser");
        loan.setId(id);
        loan.setExamineid(examId);
        int i=loanService.updateLoan1(loan);
        Integer receiveId=(Integer) loanService.SelectLoneById(id).getLoanid();
        Double amount=(Double) loanService.SelectLoneById(id).getAmount();
        Info info=new Info();
        info.setSendId(examId);
        info.setReceiveId(receiveId);
        info.setTitle("网贷审核未通过");
        String username=loanService.SelectUserByLoanId(receiveId);
        String adminame=(String) request.getSession().getAttribute("username");
        String infDesc="用户"+username+"的"+amount+"元网贷申请审核未通过！审核人为："+adminame;
        info.setInfoDesc(infDesc);
        int j=infoService.AddInfo(info);
        if(i+j==2){
            return Msg.success();
        }else{
            return Msg.fail();
        }
    }
    @RequestMapping("/loaninfo")
    public String  selectUserAllInfo(@RequestParam(value = "pageNum",defaultValue = "1") Integer pageNum,
                                 @RequestParam(value = "pageSize",defaultValue = "5") Integer pageSize,
                                 Model model, Map<String,Object> top)
    {
        //
        PageHelper.startPage(pageNum,pageSize);
        List<Loan> list=loanService.selectLoanAll();
        //
        PageInfo<Loan> pageInfo=new PageInfo<Loan>(list);
        model.addAttribute("loanPageInfo",pageInfo);
        model.addAttribute("loanList",list);
        model.addAttribute("activeUrl","indexActive");
        model.addAttribute("activeUrl1","loanActive");
        model.addAttribute("activeUrl2","loaninfoActive");
        model.addAttribute("username","username");
        top.put("pageTopBarInfo","网贷信息界面");

        //ModelAndView modelAndView=new ModelAndView("userinfo","list",userService.selectUserAll());

        return "/admin/loan/loaninfo";
    }

    @RequestMapping("/loan/remindPay/{id}")
    @ResponseBody
    public Msg addLoanremind(@PathVariable("id") Integer id,HttpServletRequest request)
    {

        Integer examId=(Integer)request.getSession().getAttribute("loginUser");
        Integer receiveId=(Integer) loanService.SelectLoneById(id).getLoanid();
        Double amount=(Double) loanService.SelectLoneById(id).getAmount();
        Info info=new Info();
        info.setSendId(examId);
        info.setReceiveId(receiveId);
        info.setTitle("还款通知");
        String username=loanService.SelectUserByLoanId(receiveId);
        String adminame=(String) request.getSession().getAttribute("username");
        String infDesc="用户"+username+"的"+amount+"元网贷该还款了！该提醒发送人为："+adminame;
        info.setInfoDesc(infDesc);
        int i=infoService.AddInfo(info);
        if(i==1){
            return Msg.success();
        }else{
            return Msg.fail();
        }
    }

    
    @RequestMapping("/user/applyLoan")
    public String  selectUserAllInfo(Model model, Map<String,Object> top)
    {
        model.addAttribute("activeUrl","indexActive");
        model.addAttribute("activeUrl1","toolsActive");
        model.addAttribute("activeUrl2","applyLoanActive");
        model.addAttribute("username","username");
        top.put("pageTopBarInfo","安全网贷界面");
        return "/user/tools/applyloan";
    }
    @RequestMapping("/user/addLoanApply")
    @ResponseBody
    public Msg insertLoanApply(Loan loan, HttpServletRequest request){
        Integer loanId=(Integer)request.getSession().getAttribute("loginUser");
        loan.setLoanid(loanId);
        int i=loanService.addLoanApply(loan);
        if(i==1){
            return Msg.success();
        }else {
            return Msg.fail();
        }
    }
    @RequestMapping("/myloan")
    public String  selectLoanAll(@RequestParam(value = "pageNum",defaultValue = "1") Integer pageNum,
                                 @RequestParam(value = "pageSize",defaultValue = "5") Integer pageSize,
                                 Model model, HttpServletRequest request, Map<String,Object> top)
    {
        Integer loanId=(Integer) request.getSession().getAttribute("loginUser");
        //
        PageHelper.startPage(pageNum,pageSize);
        List<UserLoan> list=loanService.selectLoanByuserId(loanId);
        System.out.println(loanId);
        PageInfo<UserLoan> pageInfo=new PageInfo<UserLoan>(list);
        model.addAttribute("myLoansPageInfo",pageInfo);
        model.addAttribute("loansList",list);
        model.addAttribute("activeUrl","indexActive");
        model.addAttribute("activeUrl1","personalActive");
        model.addAttribute("activeUrl2","myLoanActive");
        model.addAttribute("username","username");
        top.put("pageTopBarInfo","我的借贷界面");

        //ModelAndView modelAndView=new ModelAndView("userinfo","list",userService.selectUserAll());

        return "user/personal/myloan";
    }
    @RequestMapping("/user/repayment/{id}")
    @ResponseBody
    public Msg updateloanstatus(@PathVariable("id") Integer id, Loan loan){
        loan.setId(id);
        int i=loanService.updateUserLoan(loan);
        if(i==1){
            return Msg.success();
        }else{
            return Msg.fail();
        }
    }


}
