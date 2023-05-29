package com.travel.travelapp.controller;

import com.travel.travelapp.model.UserDetails;
import com.travel.travelapp.service.UserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class UserDetailsController {

    @Autowired
    UserDetailService service;

    @CrossOrigin
    @GetMapping("/user/{id}")
    public UserDetails get(@PathVariable String id) {
        return service.get(id);
    }

    @CrossOrigin
    @PostMapping("/user")
    public String create(@RequestBody UserDetails details) {
        return service.create(details);
    }

}
