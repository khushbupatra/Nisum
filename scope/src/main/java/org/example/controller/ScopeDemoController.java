package org.example.controller;

import org.example.beans.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ScopeDemoController {

    @Autowired
    private SingletonBean singletonBean;

    @Autowired
    private PrototypeBean prototypeBean;

    @Autowired
    private RequestScopeBean requestScopeBean;

    @Autowired
    private SessionScopeBean sessionScopeBean;

    @GetMapping("/scope")
    public String showScopeDemo(Model model) {
        // Increment all beans
        singletonBean.increment();
        prototypeBean.increment();
        requestScopeBean.increment();
        sessionScopeBean.increment();

        // Add attributes to model
        model.addAttribute("singletonValue", singletonBean.getValue());
        model.addAttribute("prototypeValue", prototypeBean.getValue());
        model.addAttribute("requestValue", requestScopeBean.getValue());
        model.addAttribute("sessionValue", sessionScopeBean.getValue());

        return "scope";
    }
}