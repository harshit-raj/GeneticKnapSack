package com.GeneAlgo.KnapSack.Web;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.GeneAlgo.KnapSack.AlgoService.Generation;
import com.GeneAlgo.KnapSack.AlgoService.ItemList;
import com.GeneAlgo.KnapSack.AlgoService.RunAlgorithmService;
import com.GeneAlgo.KnapSack.Entity.AlgoControls;

@Controller
public class MainController {
	
	@Autowired
	RunAlgorithmService service;
	
	@RequestMapping("/")
    public String home() {
		//ModelAndView mv = new ModelAndView();
        //mv.setViewName(viewName);
        //mv.addObject(attributeValue);
        return "index";
    }
	
	@RequestMapping(value = "/runAlgorithm", method = RequestMethod.GET)
	public ModelAndView runDefault(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
		ItemList il = ItemList.getInstance();
		//AlgoControls ac = new AlgoControls(50000, 10, 5,100);
		Generation generation=service.runAlgorithm();
		//mv.addObject("controls",ac);
		mv.addObject("generation", generation);
		mv.addObject("itemList", il);
		/*for(int i=0; i<generation.getPopList().size();i++)
		System.out.println(generation.getPopList().get(i).getAveFitness());*/
		mv.setViewName("result");
		System.out.println("----------------------------get get get get ");
		
		return mv;
	}
	
	@RequestMapping(value = "/runAlgorithm", method = RequestMethod.POST)
	public ModelAndView runCustom(@ModelAttribute AlgoControls cVal, BindingResult result,HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
		ItemList il = ItemList.getInstance();
		//AlgoControls ac = new AlgoControls(50000, 10, 5,100);
		
		Generation generation=service.customRunAlgorithm(cVal);
		//mv.addObject("controls",ac);
		mv.addObject("generation", generation);
		mv.addObject("itemList", il);
		/*for(int i=0; i<generation.getPopList().size();i++)
		System.out.println(generation.getPopList().get(i).getAveFitness());*/
		mv.setViewName("result");
		System.out.println("----------------------------Post request");
		
		return mv;
	}
	
	@RequestMapping(value = "/customAlgorithm", method = RequestMethod.GET)
	public ModelAndView controlForm() {
		ModelAndView mv = new ModelAndView();
		AlgoControls alc = new AlgoControls(5000, 10, 5, 70);
		mv.addObject("alc", alc);
		//mv.addObject("itemList", il);
		/*for(int i=0; i<generation.getPopList().size();i++)
		System.out.println(generation.getPopList().get(i).getAveFitness());*/
		mv.setViewName("control");
		
		
		return mv;
	}
	
	
	
	

}
