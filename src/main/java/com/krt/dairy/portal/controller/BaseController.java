package com.krt.dairy.portal.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class BaseController {
    @ModelAttribute
    public void initPath(HttpServletRequest request, HttpServletResponse response, ModelMap model){
        String base = request.getContextPath();

        String fullPath = request.getScheme()+"://"+request.getServerName()
                +":" +request.getLocalPort() +base;
        String backstage = request.getScheme()+"://"+request.getServerName()
                +":" +request.getLocalPort()+"/h";
        model.addAttribute("pathUrl", fullPath);
        model.addAttribute("backstage", backstage);
        model.addAttribute("fullPath", fullPath);

    }
}
