package com.example.libreria.controller;

import com.example.libreria.model.Libro;
import com.example.libreria.service.LibreriaService;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


// Indica che questa classe è un controller REST
@RestController              

// Prefisso comune a tutti gli endpoint: /api/libri
@RequestMapping("/api/libri")         

// Definizione della classe controller
public class LibreriaController {                 

    // Dipendenza verso il service che contiene la logica di business
    private final LibreriaService service;        

    // Iniezione del service via costruttore
    public LibreriaController(LibreriaService service) {  
        this.service = service;                   
    }

    // GET /api/libri
    @GetMapping                                   
    
    // Metodo per recuperare tutti i libri
    public List<Libro> getAll() {                 
        
        // Delega al service la lettura di tutti i record
        return service.getAll();                  
    }

    // GET /api/libri/{id}
    @GetMapping("/{id}")                         
    
    // @PathVariable estrae il valore di {id} dall’URL  
    public ResponseEntity<Libro> getById(@PathVariable Long id) {  
        return service.getById(id)                
        
        // Se il libro esiste, restituisce HTTP 200 con il corpo
                      .map(ResponseEntity::ok)    
                     
                      // Altrimenti, restituisce HTTP 404 Not Found
                      .orElse(ResponseEntity.notFound().build());  
    }

    @PostMapping                                  
    
    // @RequestBody deserializza il JSON della richiesta in un oggetto Libro
    public ResponseEntity<Libro> create(@RequestBody Libro nuovo) {  
        
        // Chiama il service per salvare il nuovo libro
        Libro creato = service.create(nuovo);     
        return ResponseEntity
        
        // HTTP 201 Created
                   .status(HttpStatus.CREATED)   
                   
                   // Restituisce l’entità creata nel corpo della risposta
                   .body(creato);                
    }

    @PutMapping("/{id}")                          
    public ResponseEntity<Libro> update(
            @PathVariable Long id, 
            
            // Riceve l’id da URL e i dati modificati in JSON
            @RequestBody Libro modificato) {      
        return service.update(id, modificato)     
        
        // Se l’update ha successo, 200 OK con il libro aggiornato
                      .map(ResponseEntity::ok)    
                     
                      // Se non esiste un libro con quell’id, 404 Not Found
                      .orElse(ResponseEntity.notFound().build());  
    }

    @DeleteMapping("/{id}")                       
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        
        // Chiama il service per eliminare il libro
        boolean rimosso = service.delete(id);      
        return rimosso 
        
        // Se eliminato, 204 No Content
               ? ResponseEntity.noContent().build()   
               
               // Se non trovato, 404 Not Found
               : ResponseEntity.notFound().build();   
    }
    
} 


    