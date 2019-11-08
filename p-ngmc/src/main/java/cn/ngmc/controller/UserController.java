package cn.ngmc.controller;

import cn.ngmc.entity.User;
import cn.ngmc.service.UserService;
import jdk.nashorn.internal.runtime.JSONFunctions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import com.alibaba.fastjson.JSON;

@Controller
@RequestMapping("/user")
public class UserController {

    //model
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/login",method = {RequestMethod.POST},params = {"uname","upwd"})
    public void login(String uname,String upwd,HttpServletResponse response) throws IOException {

        HashMap<String,String> map=new  HashMap<String,String>();
        map.put("uname",uname);
        map.put("upwd",upwd);
        response.getOutputStream().print(JSON.toJSONString(map));
    }

    @RequestMapping(value = "/regite" ,method = {RequestMethod.POST})
    public void regite(HttpServletRequest request, HttpServletResponse response) throws IOException{
//        //1、
//        //2
//        //3
//        ModelAndView mv= new ModelAndView();
//        mv.setViewName("regite.jsp");
//        return mv;
        response.getOutputStream().print("{\"key\":\"value\"}");
    }
//
//
    @RequestMapping(value = "/get",method = {RequestMethod.POST})
    public void getUser(@RequestParam(value = "uid",required = false) Long uid, HttpServletResponse response) throws IOException {
        User user=userService.getUser(uid);
        response.getOutputStream().print(JSON.toJSONString(user));
    }
}
