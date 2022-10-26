package com.todo.userdemo.service;

import com.todo.userdemo.model.AppUser;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AppUserServiceImp implements  AppUserService{
    List<AppUser> appUserList= new ArrayList<>();
    Long idToSet=0L;

    @Override
    public List<AppUser> getAll() {
        return appUserList;
    }

    @Override
    public AppUser findById(Long id) {
        AppUser appUser=appUserList.stream().filter(a->a.getId()==id).collect(Collectors.toList()).get(0);

        return appUser;
    }

    @Override
    public AppUser createNewAppUser(AppUser appUser) {
        idToSet++;
        appUser.setId(idToSet);
        appUserList.add(appUser);

        return appUserList.stream().filter(a->a.getId()== appUser.getId()).collect(Collectors.toList()).get(0);
    }

    @Override
    public AppUser updateAppUser(AppUser appUser) {
        AppUser appUser1=  appUserList.stream().filter(a->a.getId()== appUser.getId()).collect(Collectors.toList()).get(0);
        appUserList.set(appUserList.indexOf(appUser1), appUser);
        return appUser;
    }

    @Override
    public void deleteAppUser(Long id) {
        AppUser appUser1=  appUserList.stream().filter(a->a.getId()== id).collect(Collectors.toList()).get(0);


        appUserList.remove(appUserList.indexOf(appUser1));


    }
}