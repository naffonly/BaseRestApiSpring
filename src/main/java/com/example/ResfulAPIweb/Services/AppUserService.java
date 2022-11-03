package com.example.ResfulAPIweb.Services;

import com.example.ResfulAPIweb.Models.Repositorys.AppUserRepo;
import com.example.ResfulAPIweb.Models.entities.AppUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class AppUserService implements UserDetailsService {
    @Autowired
    private AppUserRepo appUserRepo;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        return appUserRepo.findByEmail(email)
                .orElseThrow(() ->
                    new UsernameNotFoundException(
                            String.format("User with Email '%s' not Found ",email)));
    }

    public AppUser registerAppUser(AppUser user){
        boolean userExist = appUserRepo.findByEmail(user.getEmail()).isPresent();
        if (userExist){
            throw  new RuntimeException(
                String.format("User with Email '%s' Alredy exist",user.getEmail()));
        }
        String encodePassword = bCryptPasswordEncoder.encode(user.getPassword());
        user.setPassword(encodePassword);
        return appUserRepo.save(user);
    }
}
