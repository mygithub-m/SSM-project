package cn.learn.controller;

import cn.learn.model.Manager;
import cn.learn.service.impl.ManagerService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/manager")
public class ManagerController {
    private ManagerService managerService;

    @Resource
    public void setManagerService(ManagerService managerService) {
        this.managerService = managerService;
    }

    //进入登录页面
    @RequestMapping("/loginPage")
    public String loginPage(){
        return "/manager/login";
    }

    //管理员登录
    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public String managerLogin(Manager manager, HttpServletRequest request){
        Manager manager1 = managerService.selectOne(manager);
        System.out.println(manager1);
        System.out.println("================");
        if (manager1 != null){
            //登录成功
            HttpSession session = request.getSession();
            session.setAttribute("manager",manager1);
            return "redirect:/employee/index";
        } else {
            //登录失败
            return "/manager/login";
        }

    }

    //管理员退出登录
    @RequestMapping("/exitLogin")
    public String exitLogin(HttpSession session){
        session.removeAttribute("manager");
        return "redirect:/manager/loginPage";
    }
}
