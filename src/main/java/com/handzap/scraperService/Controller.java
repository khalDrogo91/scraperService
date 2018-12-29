package com.handzap.scraperService;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
   
	@RequestMapping(method = RequestMethod.GET, value="/authors/articles")
    @ResponseBody
    public String welcomeUser(String name) {
		System.out.println("got here");
        return "hello";
    }
}
