package com.example.libreria.service;

import com.example.libreria.repository.LibreriaRepository;
import com.example.libreria.model.Libro;
import org.springframework.stereotype.Service;

import java.util.*;

// Marca la classe come bean di servizio gestito da Spring
@Service                                     

// Definizione della classe di servizio per la logica business di Libreria
public class LibreriaService {                   

    // Repository JPA per operazioni CRUD sugli oggetti Libro
    private final LibreriaRepository repo;        

    // Costruttore che riceve il repository tramite dependency injection
    public LibreriaService(LibreriaRepository repo) {  
        
        // Inizializza il campo repo con l'istanza iniettata
        this.repo = repo;                         
    }

    // Metodo per recuperare tutti i libri dal database
    public List<Libro> getAll() {                
        
        // Crea una lista vuota di libri
        List<Libro> lista = new ArrayList<>();   
        
        // Aggiunge ogni libro trovato alla lista
        repo.findAll().forEach(lista::add);      
        
        // Restituisce la lista popolata di libri
        return lista;                            
    }

    // Metodo per recuperare un libro per chiave primaria
    public Optional<Libro> getById(Long id) {     
        
        // Restituisce Optional.empty() o Optional<Libro> se presente
        return repo.findById(id);                
    }

    
    // Metodo per salvare un nuovo libro nel database
    public Libro create(Libro nuovo) {            
        
        // Esegue l'INSERT e restituisce l'entità persistita
        return repo.save(nuovo);                 
    }

    
    // Metodo per aggiornare un libro esistente
    public Optional<Libro> update(Long id, Libro modificato) {  
        
        // Cerca il libro in base all'id
        return repo.findById(id)                
        
        // Se il libro esiste, esegue la lambda per modificarlo
                   .map(t -> {                  
                       
                    // Aggiorna il campo titolo
                       t.setTitolo(modificato.getTitolo());  
                       
                       // Aggiorna il campo autore
                       t.setAutore(modificato.getAutore());  
                       
                       // Aggiorna il campo prezzo
                       t.setPrezzo(modificato.getPrezzo()); 
                       
                       // Salva le modifiche e restituisce l'entità aggiornata
                       return repo.save(t);         
                       
                   });                            
    }

    // Metodo per eliminare un libro dal database
    public boolean delete(Long id) {              
        
        // Verifica se un libro con l'id specificato esiste
        if (repo.existsById(id)) {                
            
            // Esegue la cancellazione del libro
            repo.deleteById(id);                 
            
            // Restituisce true se l'eliminazione è avvenuta
            return true;                         
        }
        
        // Restituisce false se il libro non esisteva
        return false;                            
    }
}                                               

