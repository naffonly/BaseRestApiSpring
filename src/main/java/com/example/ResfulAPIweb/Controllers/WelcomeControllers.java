package com.example.ResfulAPIweb.Controllers;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/welcome")

public class WelcomeControllers {
    @GetMapping
    public String welcome(){
        return "Welcome to Spring boot API";
    }

//    @PostMapping
//    public  String other(){
//        return "Kembali";
//    }
//
//    @PutMapping
//    public  String dataUpdate(){
//        return "PUt";
//    }

}
