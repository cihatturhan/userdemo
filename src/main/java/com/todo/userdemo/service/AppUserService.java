package com.todo.userdemo.service;

import com.todo.userdemo.model.AppUser;

import java.util.List;

public interface AppUserService {

    List<AppUser> getAll();
    AppUser findById(Long id);
    AppUser createNewAppUser(AppUser appUser);
    AppUser updateAppUser(AppUser appUser);
    void deleteAppUser(Long id);

}