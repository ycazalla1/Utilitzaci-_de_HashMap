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
    private String dni, nom;
    private int edat;
    private double altura;
    
    public Treballador(String dni, String nom, int edat, double altura) {
        this.dni = dni;
        this.nom = nom;
        this.edat = edat;
        this.altura = altura;
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

    public double getAltura() {
        return altura;
    }

    @Override
    public String toString() {
        return "Treballador{" + "nom=" + nom + ", edat=" + edat + ", alçada=" + altura + '}';
    }
    
}
