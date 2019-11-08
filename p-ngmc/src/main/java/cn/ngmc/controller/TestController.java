package cn.ngmc.controller;

import cn.ngmc.entity.User;
import com.alibaba.fastjson.JSON;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Controller
@RequestMapping("/test")
public class TestController {

    private Long uid;

    @RequestMapping("/view")
    public String toView(Model model){
        model.addAttribute("key","value");
        return "index";
    }

    @RequestMapping("/redirect")
    public String toRedirect(){
        return "redirect:/test/view.do";
    }

    @RequestMapping("/forward")
    public String toforward(){
        return "forward:/test/view.do";
    }

    @RequestMapping("/index")
    public String test(){
        return "login";
    }

    @RequestMapping("/login")
    public void login(User user, HttpServletResponse response) throws IOException {
        response.getOutputStream().print(JSON.toJSONString(user));
    }
}
