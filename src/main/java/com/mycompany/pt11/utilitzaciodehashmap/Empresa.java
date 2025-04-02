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
    Map<String, ArrayList> treballadors = new HashMap<>();
    private int edat, trbldr;

    /**
     * Constructor amb els comptadors inicialitzats a 0
     */
    public Empresa (){
        this.edat = 0; // Suma de totes les edats
        this.trbldr = 0; 
    }

    /**
     * Mètode per afegir treballadors a la col·lecció
     *
     * @param dni del treballador
     * @param t resta de dades del treballador
     */
    public void putTreballadors(Treballador trb) {
        ArrayList<Treballador> t = new ArrayList<>();
        t.add(trb);
        treballadors.put(trb.getDni(), t);
        trbldr++; // Increment treballadors
        edat += trb.getEdat(); // Increment edat
    }

    /**
     * Mètode per afegir els treballadors en la seva mateixa llista si no
     * és idèntic a la resta
     * @param trb Treballador a afegir i comparar 
     */
    public void modifyTreballadors(Treballador trb) {
        
        // Declaració de variables
        int i = 0; // comptador per anar passant per cada treballador
        boolean tRepetit = false; // boolean per saber si està repetit o no
        ArrayList<Treballador> t; // ArrayList per guardar les arrays
        // Guardem l'ArrayList que tingui el mateix dni
        t = treballadors.get(trb.getDni());
        /*
            while per mirar si està repetit, sortirà quan trobi un treballador
            repetit o hagi arribat al final de la llista
        */
        while (!tRepetit && i < t.size()) {
            // Compara si són iguals i guarda el resultat
            tRepetit = trb.equals(t.get(i));
            i++; // Increment per passar al següent treballador
        }
        
        // Condicional per saber si està repetit el treballador
        if (tRepetit) {
            // Si ho és, mostra un missatge de que està repetit i no l'afegeix
            System.out.println("Està repetit el treballador.");
        } else {
            // Si no, afegeix el treballador en la seva ArrayList existent
            treballadors.get(trb.getDni()).add(trb);
            // Mostra un missatge indicant-lo
            System.out.println("S'ha afegit el treballador a una llista existent.");
            trbldr++; // Increment treballadors
            edat += trb.getEdat(); // Increment edat
        }

    }

    /**
     * Mètode per obtenir la mitjana d'edat de l'empresa
     * @return mitjana obtinguda
     */
    public double getMitjana() {
        // Calcula la mitjana
        double mitjana = (double) edat/trbldr;
        
        return mitjana; // Retorna el resultat de la mitjana d'edat
    }

    /**
     * Mètode per llistar els treballador superiors a una alçada
     * @param alturaMin alçada mínima a superar
     * @return llista dels treballadors superior a l'alçada
     */
    public ArrayList alturaSuperior(double alturaMin) {
        
        // Declaració de variables
        // double per guarda l'alçada en metres
        double altura;
        // Declaració d'ArrayList per guardar els treballadors alts
        ArrayList<Treballador> treballadorMajor = new ArrayList<>();
        
        // for-each per recòrrer el HashMap treballadors
        for (ArrayList<Treballador> t : treballadors.values()) {
            // for per recòrrer cada llista
            for (int i = 0; i < t.size(); i++) {
                // Obté l'altura del treballador
                altura = t.get(i).getAltura();
                // Condicional per comprovar si supera l'alçada mínima
                if (altura >= alturaMin) {
                    // Si la supera la guarda afegeix el treballador en la llista
                    treballadorMajor.add(t.get(i));
                }
            }
        }
        return treballadorMajor; // Retorna el resultat de la llista
    }

    /**
     * Mètode per comprovar si el DNI està repetit
     * @param t Treballador
     * @return si està repetit el treballador o no
     */
    public boolean clauLliure(Treballador t) {

        // Declaració de variables
        // boolean que guarda si està repetit el dni o no
        boolean valorOcupat = treballadors.containsKey(t.getDni());
        
        return valorOcupat; // Resultat de la variable booleana

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
