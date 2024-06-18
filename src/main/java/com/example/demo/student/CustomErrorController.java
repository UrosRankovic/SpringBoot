package com.example.demo.student;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CustomErrorController implements ErrorController {

    private static final String PATH = "/error";

    @RequestMapping(value = PATH, method = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
    public ModelAndView error() {
        ModelAndView mav = new ModelAndView("errorPage"); // Specify the name of your error page without ".html"
        mav.addObject("error", "Page doesn't exist or method not allowed");
        return mav;
    }

}
