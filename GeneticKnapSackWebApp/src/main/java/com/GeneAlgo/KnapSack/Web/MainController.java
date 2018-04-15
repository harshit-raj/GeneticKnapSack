package com.GeneAlgo.KnapSack.Web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {
	@RequestMapping("/")
    public String home() {
		//ModelAndView mv = new ModelAndView();
        //mv.setViewName(viewName);
        //mv.addObject(attributeValue);
        return "index";
    }
	

}
