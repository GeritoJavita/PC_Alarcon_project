package edu.pc.alarcon.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthorController {

    /**
     * GET /autor
     * -----------------------------------
     * Devuelve el nombre completo de los autores
     * del proyecto.
     */
    @GetMapping("/autor")
    public String autor(){
        return "Gero Alarcon - Diego Bautista";
    }
}
