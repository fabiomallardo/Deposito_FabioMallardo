package com.example.todolist.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


import jakarta.annotation.Nonnull;
import jakarta.persistence.Column;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity // Dichiara che la classe Todo è un'entità JPA
@Data // Evita di scrivere i metodi get e setter
@NoArgsConstructor // Costruttore senza parametri di default
@Table(name = "todo")
public class Todo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "descrizione")
    private String descrizione;

    @Nonnull 
    private boolean completato;

    public Todo(String descrizione, boolean completato) {
        this.descrizione = descrizione;
        this.completato = completato;
    }
}