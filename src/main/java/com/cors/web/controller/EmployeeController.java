package com.cors.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.cors.web.entity.Employee;
import com.cors.web.service.IEmployeeService;
import com.cors.web.service.IOrgnizationService;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
	
	@Autowired
	private IEmployeeService employeeService; 
	
	@Autowired
	private IOrgnizationService orgnizationService;
	
	@RequestMapping("/list")
	public ModelAndView index() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("employees", employeeService.findAll());
		mav.setViewName("employee/list");
		return mav;
	}
	
	@RequestMapping("/add")
	public ModelAndView add() {
		Employee employee = new Employee();
		ModelAndView mav = new ModelAndView();
		mav.addObject("employee", employee);
		mav.addObject("orgnizations", orgnizationService.findAll());
		mav.setViewName("employee/add");
		return mav;
	}
	
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public String add(@ModelAttribute(value="employee")Employee employee,
					  @ModelAttribute(value="orgnizationId")String orgnizationId) {
		
		employeeService.add(employee, Integer.parseInt(orgnizationId));
		
//		System.out.println(employee.getOrgnization().getId());
		
//		return "redirect:list";
		return "forward:/employee/list";
	}
	
	@RequestMapping("/delete")
	public String delete(int id) {
		employeeService.delete(id);
		return "forward:/employee/list";
	}
	
	@GetMapping("/update")
	public ModelAndView update(int id) {
		Employee employee = employeeService.findById(id);
		ModelAndView mav = new ModelAndView();
		mav.addObject("employee", employee);
		mav.addObject("orgnizations", orgnizationService.findAll());
		mav.setViewName("employee/update");
		return mav;
	}
	
	@PostMapping("/update")
	public String update(Employee employee,String orgnizationId) {
		employeeService.add(employee, Integer.parseInt(orgnizationId));
		return "forward:/employee/list";
	}
	
	@RequestMapping("/findByName")
	public ModelAndView findByName(@ModelAttribute(value="name")String name) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("employees", employeeService.findByName(name));
		mav.setViewName("employee/list");
		return mav;
	}
	
}
