package com.example.demo.model;

public class Numero {
    private Long id;
    private int numero;

    public Numero() {}

    public Numero(Long id, int numero) {
        this.id = id;
        this.numero = numero;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getValore() {
        return numero;
    }
}
