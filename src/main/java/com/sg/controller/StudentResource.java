package com.sg.controller;


import java.util.List;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sg.dao.UserRepository;
import com.sg.model.Student;
import com.sg.model.User;
import com.sg.service.StudentService;

@Controller
@RequestMapping("/student")
public class StudentResource {
	private final Logger LOG = LoggerFactory.getLogger(StudentResource.class);
	private StudentService studService;
	private UserRepository userRepo;
	
	@Autowired
	public StudentResource(StudentService service, UserRepository userRepo ) {
		this.studService = service;
		this.userRepo = userRepo;
	}
	
	@GetMapping()
	public String showLogin(Model model) {
		User user = new User();
		model.addAttribute("user", user);
		return "login";
	}
		
	@PostMapping(path = "/checkLogin")
	public String validateLogin(@ModelAttribute("user") User user) {
		String formUsername = user.getUsername();
		String formPassword = user.getPassword();
		
		//check for valid user credential before passing data to Ajax call
		User daoUser = userRepo.findByUsernameAndPassword(formUsername, formPassword);
		
		if(daoUser != null) {
			return "redirect:/student/home";
		}
		return "redirect:/student?validUser=false";
	}

	@GetMapping(path = "/home")
	public  String getAllStudents(Model model) {
		List<Student> studList = studService.getAllStudents();
		model.addAttribute("students", studList);
		return "main";
	}
	
	@GetMapping("/signup")
	public String showRegisterForm(Model model) {
		Student student = new Student();
		model.addAttribute("student", student);
		return "register";
	}
	
	@PostMapping(path = "/new")
	public String createStudent(@Valid @ModelAttribute("student") Student stud, BindingResult result, Model model) {
		//returns to register form page and display validation message
		if(result.hasErrors()) {
			return "register";
		}
		
		//save student record in db and display status whether record can be inserted
		Student savedStud = studService.saveStudent(stud);
		String msg = "";
		String status = "";
		
		if(savedStud != null) {
			status = "success";
			msg += savedStud.getName() + " record has been successfully registered"; 
		}
		else {
			status = "failed";
			msg += stud.getName() + "record failed to update";
		}
		
		return "redirect:/student/signup?msg=" + msg + "&status=" + status;
	}
	
	
	@GetMapping(path = "update/{id}")
	public String showUpdateForm(@PathVariable int id, Model model) {
		Student stud = studService.getStudent(id);
		model.addAttribute("currStud", stud);
		return "update";
	}
	
	@PostMapping(path = "update/{id}")
	public String updateStudent(@Valid @ModelAttribute("currStud") Student stud, BindingResult result ,Model model, @PathVariable int id) {
		String msg = "";
		String status ="";
		
		System.out.println("BindingResult:" + result);
		//returns to update form page and display validation message
		if(result.hasErrors()) {
			return "update";
		}
		
		int num_record = studService.updateStudent(stud);
		
		//check whether record has been updated
		if(num_record == 1) {
			status = "success";
			msg += stud.getName() + " record has been successfully updated";
		}
		else {
			status = "failed";
			msg += stud.getName() + "record failed to update";
		}
		return "redirect:/student/update/"+ id + "?msg=" + msg + "&status=" + status;
	}
	
	@GetMapping(path="delete/{id}")
	public String deleteStudent(@PathVariable int id) {
		studService.removeStudent(id);
		return "redirect:/student/home";
	}
	
	@GetMapping(path="signout")
	public String logout() {
		return "redirect:/student";
	}
	
	@GetMapping(path="search")
	@ResponseBody
	public List<Student> ajaxSearch(@RequestParam("userInput") String userInput) {
		return studService.ajaxSearch(userInput);
		
	}
}
