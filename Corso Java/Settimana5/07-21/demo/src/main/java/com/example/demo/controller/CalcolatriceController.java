package com.example.demo.controller;

import org.springframework.web.bind.annotation.RestController;
import com.example.demo.service.CalcolatriceService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class CalcolatriceController {

    private final CalcolatriceService calcolatriceService;

    public CalcolatriceController(CalcolatriceService calcolatriceService) {
        this.calcolatriceService = calcolatriceService;
    }

    @GetMapping("/somma")
    public int somma(@RequestParam int a, @RequestParam int b) {
        return calcolatriceService.somma(a, b);
    }

}
