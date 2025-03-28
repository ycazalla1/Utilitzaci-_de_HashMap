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
    
    public Empresa(Treballador t) {
        treballadors.put(t.getDni(), t);
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
    
    public void alçadaSuperior(double alçadaMin) {
        
        Treballador treballador;
        double alçada;
        
        ArrayList<Treballador> treballadorMajor = new ArrayList<>();
        
        for (Map.Entry<String, Treballador> t : treballadors.entrySet()) {
            treballador = t.getValue();
            alçada = treballador.getAlçada();
            if (alçada > alçadaMin) {
                treballadorMajor.add(treballador);
            }
            
        }
        
        System.out.println(treballadorMajor);
    }
    
    public void clauLliure() {
        
        boolean valorNull;
        
        valorNull = treballadors.containsKey(null);
        
        
        
    }
    
}
