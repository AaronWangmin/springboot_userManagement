package com.cors.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.cors.web.entity.MountPoint;
import com.cors.web.service.IMountPointService;

@Controller
@RequestMapping("/mountPoint")
public class MountPointController {
	
	@Autowired
	private IMountPointService mountPointService; 
	
	@RequestMapping("/list")
	public ModelAndView index() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("mountPoints", mountPointService.findAll());
		mav.setViewName("mountPoint/list");
		return mav;
	}
	
	@RequestMapping("/add")
	public ModelAndView add() {
		MountPoint mountPoint = new MountPoint();
		ModelAndView mav = new ModelAndView();
		mav.addObject("mountPoint", mountPoint);
		mav.setViewName("mountPoint/add");
		return mav;
	}
	
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public String add(@ModelAttribute(value="mountPoint")MountPoint mountPoint) {
		mountPointService.add(mountPoint);
//		return "redirect:list";
		return "forward:/mountPoint/list";
	}
	
	@RequestMapping("/delete")
	public String delete(int id) {
		mountPointService.delete(id);
		return "forward:/mountPoint/list";
	}
	
	@GetMapping("/update")
	public ModelAndView update(int id) {
		MountPoint mountPoint = mountPointService.findById(id);
		ModelAndView mav = new ModelAndView();
		mav.addObject("mountPoint", mountPoint);
		mav.setViewName("mountPoint/update");
		return mav;
	}
	
	@PostMapping("/update")
	public String update(MountPoint mountPoint) {
		mountPointService.add(mountPoint);
		return "forward:/mountPoint/list";
	}
	
	@RequestMapping("/findByName")
	public ModelAndView findByName(@ModelAttribute(value="name")String name) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("mountPoints", mountPointService.findByName(name));
		mav.setViewName("mountPoint/list");
		return mav;
	}
	
}
