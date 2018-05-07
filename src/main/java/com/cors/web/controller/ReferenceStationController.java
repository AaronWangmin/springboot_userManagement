package com.cors.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.cors.web.entity.ReferenceStation;
import com.cors.web.service.IReferenceStationService;
import com.cors.web.service.IOrgnizationService;

@Controller
@RequestMapping("/referenceStation")
public class ReferenceStationController {
	
	@Autowired
	private IReferenceStationService referenceStationService; 
	
	@Autowired
	private IOrgnizationService orgnizationService;
	
	@RequestMapping("/list")
	public ModelAndView index() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("referenceStations", referenceStationService.findAll());
		mav.setViewName("referenceStation/list");
		return mav;
	}
	
	@RequestMapping("/add")
	public ModelAndView add() {
		ReferenceStation referenceStation = new ReferenceStation();
		ModelAndView mav = new ModelAndView();
		mav.addObject("referenceStation", referenceStation);
		mav.addObject("orgnizations", orgnizationService.findAll());
		mav.setViewName("referenceStation/add");
		return mav;
	}
	
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public String add(@ModelAttribute(value="referenceStation")ReferenceStation referenceStation,
					  @ModelAttribute(value="orgnizationId")String orgnizationId) {
		
		referenceStationService.add(referenceStation, Integer.parseInt(orgnizationId));
		
//		System.out.println(referenceStation.getOrgnization().getId());
		
//		return "redirect:list";
		return "forward:/referenceStation/list";
	}
	
	@RequestMapping("/delete")
	public String delete(int id) {
		referenceStationService.delete(id);
		return "forward:/referenceStation/list";
	}
	
	@GetMapping("/update")
	public ModelAndView update(int id) {
		ReferenceStation referenceStation = referenceStationService.findById(id);
		ModelAndView mav = new ModelAndView();
		mav.addObject("referenceStation", referenceStation);
		mav.addObject("orgnizations", orgnizationService.findAll());
		mav.setViewName("referenceStation/update");
		return mav;
	}
	
	@PostMapping("/update")
	public String update(ReferenceStation referenceStation,String orgnizationId) {
		referenceStationService.add(referenceStation, Integer.parseInt(orgnizationId));
		return "forward:/referenceStation/list";
	}
	
	@RequestMapping("/findByName")
	public ModelAndView findByName(@ModelAttribute(value="name")String name) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("referenceStations", referenceStationService.findByName(name));
		mav.setViewName("referenceStation/list");
		return mav;
	}
	
}
