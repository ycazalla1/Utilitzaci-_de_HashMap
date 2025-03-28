/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pt11.utilitzaciodehashmap;

/**
 *
 * @author Bea i Yamila
 */
public class Treballador {
    
    private String nom, dni;
    private int edat;
    private double alçada;
    
    public Treballador(String dni, String nom, int edat, double alçada) {
        this.dni = dni;
        this.nom = nom;
        this.edat = edat;
        this.alçada = alçada;
    }

    public String getDni() {
        return dni;
    }

    public String getNom() {
        return nom;
    }

    public int getEdat() {
        return edat;
    }

    public double getAlçada() {
        return alçada;
    }

    @Override
    public String toString() {
        return "Treballador{" + "nom=" + nom + ", dni=" + dni + ", edat=" + edat + ", al\u00e7ada=" + alçada + '}';
    }
    
}
