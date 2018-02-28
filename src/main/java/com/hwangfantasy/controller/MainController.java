package com.hwangfantasy.controller;

import com.hwangfantasy.service.MainService;
import com.hwangfantasy.service.QqService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author hwangfantasy
 * @since 2018/2/28
 */
@Controller
public class MainController {
    @Autowired
    private QqService qqService;

    @RequestMapping("/printproperties")
    @ResponseBody
    public String printProperties(){
        return qqService.getConfig().toString();
    }

}
