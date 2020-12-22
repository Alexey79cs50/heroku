package com.generate.users.application.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import springfox.documentation.annotations.ApiIgnore;

@RestController
@ApiIgnore
public class MainController {

    @GetMapping
    public ModelAndView method() {
        return new ModelAndView("redirect:/swagger-ui.html");
    }
}
