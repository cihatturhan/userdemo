package com.todo.userdemo.service;

import com.todo.userdemo.model.AppUser;
import com.todo.userdemo.repository.AppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;


import java.util.List;


@Service
public class AppUserServiceImp implements  AppUserService{
    @Autowired
    AppUserRepository appUserRepository;

    @Override
    public List<AppUser> getAll() {
        return appUserRepository.findAll();
    }

    @Override
    public AppUser findById(Long id) {



        return appUserRepository.findById(id).orElseThrow(()->new RuntimeException("User not Found"));
    }

    @Override
    public AppUser createNewAppUser(AppUser appUser) {

        return  appUserRepository.save(appUser);
    }

    @Override
    public AppUser updateAppUser(AppUser appUser) {

        return appUserRepository.save(appUser);
    }

    @Override
    public void deleteAppUser(Long id) {
        if(appUserRepository.findById(id)==null){
            throw new RuntimeException("User Not Found");
        }else {
            appUserRepository.deleteById(id);
        }


    }
}