package com.example.libreria.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


import jakarta.persistence.Column;
import lombok.Data;
import lombok.NoArgsConstructor;

// Marca la classe come entità JPA, mappata a una tabella nel database
@Entity                                 

// Lombok: genera automaticamente getter, setter, toString, equals e hashCode
@Data                                   

// Lombok: genera un costruttore senza argomenti
@NoArgsConstructor                      

// Specifica il nome della tabella a cui l'entità è associata
@Table(name = "libro")                  
public class Libro {

    // Definisce il campo come chiave primaria della tabella
    @Id                                  
    
    // Strategia di generazione dell'ID: AUTO_INCREMENT nel database
    @GeneratedValue(strategy = GenerationType.IDENTITY)  
    
    // Identificatore univoco del libro
    private Long id;                     

    // Mappa il campo "titolo" alla colonna "titolo" nel DB
    @Column(name = "titolo")            
    
    // Titolo del libro
    private String titolo;               

    // Mappa il campo "autore" alla colonna "autore" nel DB
    @Column(name = "autore")            
    
    // Autore del libro
    private String autore;               

    // Mappa il campo "prezzo" alla colonna "prezzo" nel DB
    @Column(name = "prezzo")            
    
    // Prezzo del libro
    private double prezzo;               
}
