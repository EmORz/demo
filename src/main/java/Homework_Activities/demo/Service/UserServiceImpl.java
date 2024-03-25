package Homework_Activities.demo.Service;

import Homework_Activities.demo.DTO.UserRegistrationDto;
import Homework_Activities.demo.Entity.User;
import Homework_Activities.demo.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class UserServiceImpl {


//    @Autowired
//    private UserRepository userRepository;
//
//
//    public BCryptPasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
//
//    @Override
//    public void registerUser(UserRegistrationDto userDto) {
//
//        User user = new User();
//        user.setUsername(userDto.getUsername());
//        user.setPassword(passwordEncoder().encode(userDto.getPassword()));
//        user.setRole(userDto.getRole());
//        user.setEnabled(true);
//
//        userRepository.save(user);
//
//    }
}
