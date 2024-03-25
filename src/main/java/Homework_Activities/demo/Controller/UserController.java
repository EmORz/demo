package Homework_Activities.demo.Controller;

import Homework_Activities.demo.DTO.UserLoginDto;
import Homework_Activities.demo.DTO.UserRegistrationDto;
import Homework_Activities.demo.Entity.User;
import Homework_Activities.demo.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class UserController {

    @Autowired
    private UserRepository userRepository;

    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @GetMapping("/user-details")
    @PreAuthorize("isAuthenticated()")
    public String showUserDetails(Model model) {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        var authentication1 = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        model.addAttribute("authentication", authentication);

        return "user-details";
    }


    @GetMapping("/login")
    public String showLogin(Model model, Authentication authentication){

        if (authentication != null && authentication.isAuthenticated()) {
            return "user-details";
        }


        model.addAttribute("user", new UserLoginDto());
       return "login";
    }

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new UserRegistrationDto());
        return "registration";
    }

    @PostMapping("/register")
    public String registerUser( UserRegistrationDto userDto) {
        User user = new User();
        user.setUsername(userDto.getUsername());
        user.setPassword(passwordEncoder().encode(userDto.getPassword()));
        user.setRole(userDto.getRole());
        user.setEnabled(true);

        userRepository.save(user);

        return "Успешна регистрация!";

    }


}
