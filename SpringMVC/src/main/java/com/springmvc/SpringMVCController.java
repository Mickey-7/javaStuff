package com.springmvc;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.time.Duration;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.logging.Handler;
import java.util.logging.LogRecord;


import javax.annotation.Resource;

@Controller
@RequestMapping("/springMVC")
public class SpringMVCController {



//    @Resource(name = "myBean")

    @Autowired
    private ComponentClass componentClass;


    @RequestMapping(value = "/spring_mvc",method = RequestMethod.GET)
    public String springMVC(Model model){
        model.addAttribute("message","Spring MVC Framework shit");

        EODProcessData eodProcessData = new EODProcessData();
        eodProcessData.setFirstName("firstName");
        eodProcessData.setLastName("lastName");
        eodProcessData.setMiddleName("middleName");

        model.addAttribute("eodProcessData", eodProcessData);




        return "spring_mvc";


    }

    @RequestMapping(value = "/inputDate", method = RequestMethod.POST)
    public void inputDate(@RequestBody String inputDate){
        System.out.println("---------------");
        System.out.println(inputDate);
        System.out.println("===================");
    }



}



