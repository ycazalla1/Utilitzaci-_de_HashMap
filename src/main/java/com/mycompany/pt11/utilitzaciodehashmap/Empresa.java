/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pt11.utilitzaciodehashmap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Classe Empresa que guarda treballadors en la seva col·lecció
 * @author Bea i Yamila
 */
public class Empresa {
    
    // Declaració d'atribut HashMap
    Map<String, Treballador> treballadors = new HashMap<>();
    
    /**
     * Constructor buit, per poder instanciar-lo des del main
     */
    public Empresa() {
        
    }

    /**
     * Mètode per afegir treballadors a la col·lecció
     * @param dni del treballador
     * @param t resta de dades del treballador
     */
    public void putTreballadors(String dni, Treballador t) {
        treballadors.put(dni, t);
    }
    
    /**
     * Mètode per obtenir la mitjana d'edat de l'empresa
     * @return mitjana obtinguda
     */
    public int getMitjana() {
        
        // Declaració de variables
        int mitjana, edat = 0; // int per guarda la mitjana i l'edat
        
        // Declaració de l'instanció de la classe Treballador sense incialitzar
        Treballador treballador;
        
        // for per recòrrer el HashMap treballadors
        for (Map.Entry<String, Treballador> t : treballadors.entrySet()) {
            treballador = t.getValue(); // Guarda el treballador
            // Obté l'edat del treballador i l'incrementa
            edat += treballador.getEdat();
        }
        
        // Calcula la mitjana d'edat
        mitjana = edat / treballadors.size();
        
        return mitjana; // Retorna el resultat de mitjana
        
    }
    
    /**
     * Mètode per llistar els treballador superiors a una alçada
     * @param alturaMin alçada mínima a superar
     * @return llista dels treballadors superior a l'alçada
     */
    public ArrayList alturaSuperior(double alturaMin) {
        
        // Declaració de variables
        // Declaració de l'instanció de la classe Treballador sense incialitzar
        Treballador treballador;
        double altura; // double per guarda l'alçada
        
        // Declaració d'ArrayList per guardar els treballadors alts
        ArrayList<Treballador> treballadorMajor = new ArrayList<>();
        
        // for per recòrrer el HashMap treballadors
        for (Map.Entry<String, Treballador> t : treballadors.entrySet()) {
            // Guarda el treballador
            treballador = t.getValue();
            // Guarda l'alçada del treballador
            altura = treballador.getAltura();
            // Condicional per comprovar si supera l'alçada mínima
            if (altura >= alturaMin) {
                // Si la supera la guarda afegeix el treballador en la llista
                treballadorMajor.add(treballador);
            }
            
        }
        
        return treballadorMajor; // Retorna el resulta de la llista
    }
    
    /**
     * Mètode per comprovar si el DNI està repetit
     * @param dni
     * @param t
     */
    public void clauLliure(String dni, Treballador t) {
        
        // Declaració de variables
        // boolean que guarda si està repetit el dni o no
        boolean valorOcupat = treballadors.containsKey(dni);
        
        // Condional per comprovar si està repetit o no
        if (!valorOcupat) {
            // Si no està repetit l'afegeix a la col·lecció
            treballadors.put(dni, t);
            // I mostra un missatge de que s'ha afegit el treballador
            System.out.println("S'ha afegit el treballador.");
        } else {
            // Si està repetit no l'afegeix i mostra un missatge indicant-lo
            System.out.println("No s'ha afegit el treballador."
                    + "Està repetida la clau.");
        }
        
    }

    /**
     * Mètode sobreescrit toString
     * @return informació de l'empresa
     */
    @Override
    public String toString() {
        return "Treballador: " + treballadors;
    }
    
    
    
}
