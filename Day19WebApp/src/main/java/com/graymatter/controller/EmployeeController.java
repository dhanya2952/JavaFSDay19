package com.graymatter.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.graymatter.model.Employee;
import com.graymatter.service.EmployeeService;

@Controller
public class EmployeeController {
	
	@Autowired
	private EmployeeService service;
	
	@RequestMapping("/doLogin")
	public String doLogin()
	{
		return "login";	
	}
	
	@RequestMapping("/home")
	public String home() {
	    return "home";
	}
	
	@RequestMapping("/add")
	public String add() {
		return "add";
	}
	
	@RequestMapping("/selectById")
	public String selectById() {
		return "byId";
	}
	
	@RequestMapping("/update")
	public String update() {
		return "update";
	}
	
	@RequestMapping("/delete")
	public String delete() {
		return "delete";
	}
	
	@RequestMapping("/login")
	public ModelAndView login(@RequestParam String username, @RequestParam String password) 
	{
		ModelAndView mv=null;
		if(username.equals("admin") && password.equals("1212")) 
		{
			mv=new ModelAndView("home");
			mv.addObject("name", username);
		} 
		else
			mv=new ModelAndView("login");
		return mv;
	}
	
	@RequestMapping("/getAll")
	public ModelAndView getAllEmployees(){
		List<Employee> empList = service.getAllEmployee();
		ModelAndView mv = new ModelAndView("employee");
		mv.addObject("emplist", empList);
		mv.addObject("test", "getAll");
		return mv;
	}
	
	@RequestMapping("/add/employee")
	public String addEmployee(@RequestParam String id, @RequestParam String name, @RequestParam String sal) {
		Employee e = new Employee(Integer.parseInt(id), name, Double.parseDouble(sal));
		service.addEmployee(e);
		return "redirect:/home";
	
	}
		
	@RequestMapping("/selectById/employee")
	public ModelAndView selectById(@RequestParam String id) {
		Employee e = service.selectEmpById(Integer.parseInt(id));
		ModelAndView mv = new ModelAndView("employee");
		mv.addObject("emp", e);
		mv.addObject("test", "one");
		return mv;
	}
	
	@RequestMapping("/update/employee")
	public String updateEmployee(@RequestParam String id,@RequestParam String name, @RequestParam String sal) {
		Employee e = new Employee(Integer.parseInt(id),name , Double.parseDouble(sal));
		service.updateEmployee(e);
		return "redirect:/home";
	}
	
	@RequestMapping("/delete/employee")
	public String deleteEmployee(@RequestParam String id) {
		service.deleteEmployee(Integer.parseInt(id));
		return "redirect:/home";
	}
}
