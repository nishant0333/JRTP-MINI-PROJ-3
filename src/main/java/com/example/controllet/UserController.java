package com.example.controllet;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.binding.Login;
import com.example.binding.Register;
import com.example.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	private HttpSession session;
	
	@Autowired
	private UserService userService;
	
	

	@GetMapping("/login")
	public String loadloginPage(Model model) {
		Login login =new Login();
		
		model.addAttribute("login", login);
		
		return "login";
	}
	
	@GetMapping("/register")
	public String loadRegisterPage(Model model) {
		
		Register register=new Register();
		model.addAttribute("register", register);
		return "register";
	}
	
	@GetMapping("/dashboard")
	public String loadDashboardPage(Model model) {
		
		
		//model.addAttribute("register", register);
		return "dashboard";
	}
	
	
	@PostMapping("/register")
	public String doRegistration(@ModelAttribute("register")  Register register , Model model) {
		System.out.println(register);
		
		Boolean status = userService.register(register);
		
		if (status) {
			model.addAttribute("succMsg", "Register successfully");
		}else {
			model.addAttribute("errMsg", "All ready register with given Email");
		}
		
		return "register";
	}
	
	@PostMapping("/login")
	public String doLogin(@ModelAttribute("login")  Login login , Model model) {
		System.out.println(login);
		
		
		String status = userService.login(login);
		
		if (status.contains("success")) {
			
			model.addAttribute("succMsg", "Login successfully");
			
			return "dashboard";
		} else {
   
			model.addAttribute("errMsg", status);
			
			return "login";
		}
		
	
	}
	
	
	@GetMapping("/logout")
	public String logout() {
		
		session.invalidate();
		
		return "index";
	}
	
}
