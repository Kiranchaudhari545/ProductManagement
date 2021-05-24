package com.codejava.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.context.request.WebRequest;

import com.codejava.services.UserService;
import com.codejava.web.dto.UserRegistrationDto;

@Controller
public class UserRegistationController {
	
	private UserService userService;
    
	public UserRegistationController(UserService userService) {
		super();
		this.userService = userService;
	}
		
	@ModelAttribute
	public UserRegistrationDto userRegistrationDto() {
		return new UserRegistrationDto();
	}
	
	@GetMapping("/registration")
	public String showRegistrationForm(WebRequest request, Model model) {
	    UserRegistrationDto userDto = new UserRegistrationDto();
	    model.addAttribute("user", userDto);
	    return "registration";
	}
    
	@PostMapping("/registration")
	public String registerUserAccount(@ModelAttribute("user") UserRegistrationDto registrationDto) {
		userService.save(registrationDto);
		return "redirect:/registration?success";
	}
}
