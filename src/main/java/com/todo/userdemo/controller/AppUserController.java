package com.todo.userdemo.controller;

import com.todo.userdemo.entity.AppUser;
import com.todo.userdemo.service.AppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
public class AppUserController {

    @Autowired
    AppUserService appUserService;

    @GetMapping
    public ResponseEntity<?> getAll(){
        return  new ResponseEntity<>(appUserService.getAll(), HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<?> findById(@PathVariable Long id){
        return  new ResponseEntity<>(appUserService.findById(id), HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<?> createNewAppUser(@RequestBody AppUser appUser){
        return new ResponseEntity<>(appUserService.createNewAppUser(appUser),HttpStatus.CREATED);
    }

    @PutMapping
    public  ResponseEntity<?> updateAppUser(@RequestBody AppUser appUser){

        return new ResponseEntity<>(appUserService.updateAppUser(appUser), HttpStatus.OK);
    }
    @DeleteMapping("{id}")
    public  ResponseEntity<?> deleteAppUser(@PathVariable Long id){
        appUserService.deleteAppUser(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }
}