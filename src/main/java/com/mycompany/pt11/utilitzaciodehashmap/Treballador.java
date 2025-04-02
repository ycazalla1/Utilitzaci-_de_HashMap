/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pt11.utilitzaciodehashmap;

/**
 * Classe Treballador
 * @author Bea i Yamila
 */
public class Treballador {
    
    // Declaració d'atributs del treballador
    private String dni, nom; // String per guardar el dni i el nom
    private int edat; // int per guardar l'edat
    private double altura; // double per guarda l'alçada
    
    /**
     * Constructor parametritzat de Treballador
     * @param dni
     * @param nom
     * @param edat
     * @param altura 
     */
    public Treballador(String dni, String nom, int edat, double altura) {
        this.dni = dni;
        this.nom = nom;
        this.edat = edat;
        this.altura = altura;
    }

    /**
     * Getter del DNI
     * @return dni
     */
    public String getDni() {
        return dni;
    }
    
    /**
     * Getter del Nom
     * @return nom
     */
    public String getNom() {
        return nom;
    }

    /**
     * Getter de l'edat
     * @return edat
     */
    public int getEdat() {
        return edat;
    }

    /**
     * Getter de l'alçada
     * @return alçada
     */
    public double getAltura() {
        return altura;
    }

    /**
     * Mètode sobreescrit toString
     * @return informació del treballador
     */
    @Override
    public String toString() {
        return "{" + "Nom: " + nom + ", Edat: " + edat + ", Alçada: " + altura + '}';
    }
    
    /**
     * Mètode per comparar els treballadors
     * @param t Treballador a comparar
     * @return boolean per saber si és identic o no
     */
    public boolean equals(Treballador t){
        return this.dni.equals(t.getDni()) && this.nom.equals(t.getNom())
                && this.edat == t.getEdat() && this.altura == t.getAltura();
    }
}
