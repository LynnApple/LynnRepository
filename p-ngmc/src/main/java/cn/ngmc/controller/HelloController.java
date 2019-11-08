package cn.ngmc.controller;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class HelloController implements Controller {

    public ModelAndView handleRequest(javax.servlet.http.HttpServletRequest httpServletRequest,
                                      javax.servlet.http.HttpServletResponse httpServletResponse) throws Exception {
        ModelAndView mv=new ModelAndView();
        mv.addObject("key","value");
        mv.setViewName("index");
        return mv;
    }
}
