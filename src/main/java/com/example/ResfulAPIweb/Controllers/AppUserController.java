package com.example.ResfulAPIweb.Controllers;

import com.example.ResfulAPIweb.Models.entities.AppUser;
import com.example.ResfulAPIweb.Services.AppUserService;
import com.example.ResfulAPIweb.dto.AppUserData;
import com.example.ResfulAPIweb.dto.ResponsData;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public class AppUserController {

    @Autowired
    private AppUserService appUserService;

    @Autowired
    private ModelMapper modelMapper;

    @RequestMapping("/register")
    public ResponseEntity<ResponsData<AppUser>> register(@RequestBody AppUserData userData){
        ResponsData<AppUser> response = new ResponsData<>();
        AppUser appUser = modelMapper.map(userData, AppUser.class);
        response.setPayload(appUserService.registerAppUser(appUser));
        response.setStatus(true);
        response.getMessages().add("AppUser Save");
        return ResponseEntity.ok(response);

    }


}
