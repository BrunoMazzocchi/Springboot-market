package com.example.market.web.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/saludar")
public class HolaMundoController {

    @GetMapping("/hola")
    public String saludar(){
        return "Nunca pares de aprender";
    }
}
