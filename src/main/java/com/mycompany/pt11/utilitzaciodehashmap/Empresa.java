/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pt11.utilitzaciodehashmap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Bea i Yamila
 */
public class Empresa {
    
    Map<String, Treballador> treballadors = new HashMap<>();
    
    public Empresa() {
        
    }

    public void putTreballadors(String dni, Treballador t) {
        treballadors.put(dni, t);
    }
    
    
    public int getMitjana() {
        
        int mitjana, edat = 0;
        Treballador treballador;
        
        
        for (Map.Entry<String, Treballador> t : treballadors.entrySet()) {
            treballador = t.getValue();
            edat += treballador.getEdat();
        }
        
        mitjana = edat / treballadors.size();
        
        
        return mitjana;
        
    }
    
    public ArrayList alturaSuperior(double alturaMin) {
        
        Treballador treballador;
        double altura;
        
        ArrayList<Treballador> treballadorMajor = new ArrayList<>();
        
        for (Map.Entry<String, Treballador> t : treballadors.entrySet()) {
            treballador = t.getValue();
            altura = treballador.getAltura();
            if (altura >= alturaMin) {
                treballadorMajor.add(treballador);
            }
            
        }
        
        return treballadorMajor;
    }
    
    public boolean clauLliure(String dni, Treballador t) {
        
        boolean valorOcupat = treballadors.containsKey(dni);
        
        if (!valorOcupat) {
            treballadors.put(dni, t);
            System.out.println("S'ha afegit el treballador.");
        } else {
            System.out.println("No s'ha afegit el treballador.");
        }
        
        return valorOcupat;
        
    }

    @Override
    public String toString() {
        return "Empresa{" + "treballadors=" + treballadors + '}';
    }
    
    
    
}
