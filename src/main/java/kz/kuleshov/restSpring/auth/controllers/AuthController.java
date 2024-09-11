package kz.kuleshov.restSpring.auth.controllers;

import kz.kuleshov.restSpring.auth.Users;
import kz.kuleshov.restSpring.auth.UsersRepository;
import kz.kuleshov.restSpring.auth.services.MyUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private MyUserService userService;
    @PostMapping("/register")
    public void registerUser(@RequestBody Users users){
        userService.registerUser(users);
    }
    @GetMapping("/verify")
    public void verifyUser(@RequestParam("email") String email,
                           @RequestParam("code") String code){
        Users checkUser = userService.getUserByEmail(email);
        if(checkUser != null){
            if(checkUser.getCode().equals(code)){
                checkUser.setStatus("activated");
                userService.updateUser(checkUser);
            }
        }
    }
}
