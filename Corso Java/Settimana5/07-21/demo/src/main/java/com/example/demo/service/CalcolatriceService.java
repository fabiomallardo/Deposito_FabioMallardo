package com.example.demo.service;

import org.springframework.stereotype.Service;

@Service
public class CalcolatriceService {
    public int somma(int a, int b){
        int risultato = a + b;
       return risultato; 
    }
}
