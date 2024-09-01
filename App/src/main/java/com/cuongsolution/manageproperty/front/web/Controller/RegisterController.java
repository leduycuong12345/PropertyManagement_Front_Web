package com.cuongsolution.manageproperty.front.web.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.cuongsolution.manageproperty.front.web.DTO.Register_UserDTO;
import com.cuongsolution.manageproperty.front.web.Service.Account.Register_AccountServiceImpl;
import com.cuongsolution.manageproperty.front.web.Service.User.Register_UserServiceImpl;
@Controller
public class RegisterController {

	@Autowired
	private Register_AccountServiceImpl accountService;
	@Autowired
	private Register_UserServiceImpl userService;
	// handler method to handle user registration form request
    @GetMapping("/register")
    public String showRegistrationForm(Model model){
        // create model object to store form data
        Register_UserDTO user = new Register_UserDTO();
        model.addAttribute("user", user);
        return "register";
    }

    // handler method to handle user registration form submit request
    @PostMapping("/register/save")
    public String registration(@Validated @ModelAttribute("user") Register_UserDTO userDto,
                               BindingResult result,
                               Model model){
        boolean existingEmail = userService.existsByEmail(userDto.getEmail());
        if(existingEmail){
            result.rejectValue("email", null,
                    "There is already an account registered with the same email");
            System.out.println("email exist");
        }
        boolean existingPhoneNumber = userService.existsByPhoneNumber(userDto.getPhoneNumber());
        if(existingPhoneNumber){
            result.rejectValue("phoneNumber", null,
                    "There is already an account registered with the same phone number");
            System.out.println("phoneNumber exist");
        }
        boolean existingUsername = accountService.existsByUsername(userDto.getUsername());
        if(existingUsername){
            result.rejectValue("username", null,
                    "There is already an account registered with the same username");
            
        }
        if(result.hasErrors()){
            model.addAttribute("user", userDto);
            return "register";
        }

        userService.createNewUser(userDto);
        return "redirect:/register?success";
    }
}
