package com.example.demo.controller;

import com.example.demo.model.Numero;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/numero")
public class NumeroController {   

    private List<Numero> numeri = new ArrayList<>();
    private Long idCounter = 1L;

    // GET /numero
    @GetMapping
    public List<Numero> getAll() {
        return numeri;
    }

    // POST /numero
    @PostMapping
    public Numero crea(@RequestBody Numero nuovo) {
        nuovo.setId(idCounter++);
        numeri.add(nuovo);
        return nuovo;
    }

    // GET /numero/{id}
    @GetMapping("/{id}")
    public Numero getById(@PathVariable Long id) {
        return numeri.stream()
                     .filter(n -> n.getId().equals(id))
                     .findFirst()
                     .orElse(null);
    }

    // GET /numero/somma
    @GetMapping("/somma")  
    public long calcolaSomma() {
        return numeri.stream()
                     .mapToLong(Numero::getValore)
                     .sum();
    }

    // DELETE /numero/{id}
    @DeleteMapping("/{id}")
    public String elimina(@PathVariable Long id) {
        numeri.removeIf(n -> n.getId().equals(id));
        return "Numero eliminato con successo.";
    }

} 
