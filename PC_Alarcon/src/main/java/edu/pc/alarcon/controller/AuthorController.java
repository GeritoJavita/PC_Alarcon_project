package edu.pc.alarcon.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthorController {
    @GetMapping("/autor")
    public String autor(){
        return "Gero Alarcon" + " Diego Bautista"; 
    }
}