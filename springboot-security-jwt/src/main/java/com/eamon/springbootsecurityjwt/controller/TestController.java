package com.eamon.springbootsecurityjwt.controller;

import com.eamon.springbootsecurityjwt.dto.ViewData;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author eamon
 * @date 2019/08/15 17:41
 **/
@RestController
@RequestMapping("/api/v1/test")
public class TestController {

    @GetMapping("/info")
    public ViewData<String> info() {
        ViewData<String> viewData = new ViewData<>();
        viewData.setData("info");
        return viewData;
    }

}
