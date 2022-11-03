package com.example.ResfulAPIweb.Models.Repositorys;

import com.example.ResfulAPIweb.Models.entities.AppUser;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Optional;

public interface AppUserRepo extends PagingAndSortingRepository<AppUser,Long> {
    Optional<AppUser>findByEmail(String email);


}
