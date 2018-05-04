package com.cors.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.cors.web.entity.Orgnization;
import com.cors.web.service.IOrgnizationService;

@Controller
@RequestMapping("/orgnization")
public class OrgnizationController {
	
	@Autowired
	private IOrgnizationService orgnizationService; 
	
	@RequestMapping("/list")
	public ModelAndView index() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("orgnizations", orgnizationService.findAll());
		mav.setViewName("orgnization/list");
		return mav;
	}
	
	@RequestMapping("/add")
	public ModelAndView add() {
		Orgnization orgnization = new Orgnization();
		ModelAndView mav = new ModelAndView();
		mav.addObject("orgnization", orgnization);
		mav.setViewName("orgnization/add");
		return mav;
	}
	
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public String add(@ModelAttribute(value="orgnization")Orgnization orgnization) {
		orgnizationService.add(orgnization);
//		return "redirect:list";
		return "forward:/orgnization/list";
	}
	
	@RequestMapping("/delete")
	public String delete(int id) {
		orgnizationService.delete(id);
		return "forward:/orgnization/list";
	}
	
	@GetMapping("/update")
	public ModelAndView update(int id) {
		Orgnization orgnization = orgnizationService.findById(id);
		ModelAndView mav = new ModelAndView();
		mav.addObject("orgnization", orgnization);
		mav.setViewName("orgnization/update");
		return mav;
	}
	
	@PostMapping("/update")
	public String update(Orgnization orgnization) {
		orgnizationService.add(orgnization);
		return "forward:/orgnization/list";
	}
	
	@RequestMapping("/findByName")
	public ModelAndView findByName(@ModelAttribute(value="name")String name) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("orgnizations", orgnizationService.findByName(name));
		mav.setViewName("orgnization/list");
		return mav;
	}
	
}
