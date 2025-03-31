/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.pt11.utilitzaciodehashmap;

import java.util.Scanner;

/**
 * Classe principal per provar les classes de Treballador i Empresa
 * @author Bea i Yamila
 */
public class PT113UtilitzaciodeHashMap {
    
    public static void main(String[] args) {

        // Declaració de variables
        double altura; // Variable que recull l'alçada i l'alçada mínima a superar
        int i = 1, edat; // Varible d'increment i d'edat
        /* 
            Variables per recollir el dni, el nom i per saber si es volen afegir
            més treballadors
        */
        String dni, nom, resposta;
        // Boolean per comprovar que s'ha omplert correctament la col·lecció
        boolean mapOmplert = false;

        // Declaració d'instància de la classe Empresa
        Empresa e = new Empresa();

        // do-while per comprovar que s'ha omplert correctament la col·leció
        do {
            // boolean per comprovar que la resposta és correcte
            boolean respostaCorrecte = false;
            // Declaració de l'escàner
            Scanner sc = new Scanner(System.in);
            
            // Crida dels mètodes per obtenir la informació d'un treballador
            System.out.println("--- Treballador " + i + " ---");
            dni = demanarDni(); // Mètode per obtenir el dni
            nom = demanarNom(); // Mètode per obtenir el nom
            edat = demanarEdat(); // Mètode per obtenir l'edat
            altura = demanarAltura(); // Mètode per obtenir l'alçada

            // Declaració de l'instància de la classe treballador amb els valor d'abans
            Treballador t = new Treballador(dni, nom, edat, altura);

            // Crida del mètode per afegir el treballador si el DNI no està duplicat
            e.clauLliure(t.getDni(), t);

            // do-while per comprovar si la resposta a la pregunta és correcte
            do {
                // Es pregunta a l'usuari si vol afegir més treballadors
                System.out.print("Vols afegir un altre treballador(S/N)? ");
                // Es guarda la resposta
                resposta = sc.nextLine();

                //Condicional per saber si vol afegir més o no
                if (resposta.equalsIgnoreCase("S")) {
                    /*
                        Si vol afegir més, surt només d'aquest bucle intern i
                        incrementa la i
                    */
                    respostaCorrecte = true;
                    i++;

                } else if (resposta.equalsIgnoreCase("N")) {
                    // Si no, surt dels dos bucles finalitzant l'omplerta de la col·lecció
                    respostaCorrecte = true;
                    mapOmplert = true;

                } else {
                    // Si la resposta és incorrecte, només mostra un misstge d'error.
                    System.out.println("ERROR. Respota incorrecte. Torna a respondre.");
                }
            } while (!respostaCorrecte);

        } while (!mapOmplert);

        // Missatge per indicar que es calcula l'edat mitjana de l'empresa
        System.out.println("--- Calcular edat mitjana de l'empresa ---");
        // Es mostra el resultat després de cridar el mètode que calcula la mitjana
        System.out.println("La edat mijana de l'empresa és: " + e.getMitjana());

        /*
            Missatge per indicar que es llistaran els treballadors que només
            superin una alçada
        */
        System.out.println("--- Llista dels treballadors que superen l'alçada"
                + "especificada ---");
        // Es guarda el resultat en la varible del mètode per demanar l'alçada
        altura = demanarAltura();

        /*
            Condicional per comprovar si hi ha algun treballador que superi
            l'altura o no
        */
        if (e.alturaSuperior(altura).isEmpty()) {
            // Si cap la supera, mostra un missatge indicant-lo
            System.out.println("Cap treballador supera els " + altura + ".");
        } else {
            // Si algú la supera, mostra el llistat dels que la superen
            System.out.println(e.alturaSuperior(altura));
        }

        // Missatge per indicar que es mostra la col·leció sencera de l'empresa
        System.out.println("--- Plantilla de tota l'empresa ---");
        // Ho mostrem cridant el mètode toString()
        System.out.println(e.toString());

    }

    /**
     * Mètode per demanar el número de DNI del treballador
     * @return el dni obtingut
     */
    public static String demanarDni() {

        // Declaració de variables
        /*
            Variables de tipus enter, per guardar el número dni i incialitzar el
            comptador
        */
        int numDni, i = 1;
        char caracter; // Variable per guarda cada caràcter del dni
        // Variables per guardar el dni sencer i la cadena dels números d'aquest
        String dni = "", lletresDni;
        /*
            booleans per comprovar que el dni és correcte i que no s'ha trobat
            cap lletra entre els números
        */
        boolean dniCorrecte = false, lletraTrobada;
        /* finals enters amb els valor de la longitud amb lletra i sense, i
           el número per fer la divisió per comprovar la lletra del DNI
        */
        final int LONGITUD_DNI = 9, LONGITUD_NUM  = 8, DIVISOR_LLETRA = 23;
        // finals String amb els valors de tots els números d'un dni i les lletres
        final String NUMEROS_DNI = "1234567890", LLETRA_DNI = "TRWAGMYFPDXBNJZSQVHLCKE";

        // Missatge per demanar el DNI
        System.out.print("Introdueix el DNI: ");
        // while per comprovar que el dni és correcte
        while (!dniCorrecte) {
            // Declaració de l'escàner
            Scanner sc = new Scanner(System.in);
            dni = sc.nextLine(); // Es guarda el valor del dni
            // Es reseteja la variable lletraTrobada a false
            lletraTrobada = false;

            // Condicional per comprovar si la longitud és correcte
            if (dni.length() == LONGITUD_DNI) {
                /*
                    while intern per comprovar que entre els números no hi cap
                    lletra
                    Finalitza quan lletraTrobada és cert o arribar el final de
                    la cadena de números
                */
                while (!lletraTrobada && i < LONGITUD_NUM) {
                    // Es guarda el valor del caràcter
                    caracter = dni.charAt(i);
                    // Condicional per mirar si es troba amb alguna lletra
                    if (NUMEROS_DNI.indexOf(caracter) == -1) {
                        // Si troba una lletra, fica com true la variable lletraTrobada
                        lletraTrobada = true;
                    }
                    // Incrementa el valor per continuar
                    i++;
                }
                
                // Comprova si lletraTrobada és falsa
                if (!lletraTrobada) {
                    /*
                        Si ho és, comença a fer el següent per veure si la lletra
                        és correcte
                    */
                    // Separa els números del DNI
                    lletresDni = dni.substring(0, 8);
                    // Pasa la cadena de números a tipus enter
                    numDni = Integer.parseInt(lletresDni);
                    // Afgafa la lletra del DNI
                    caracter = dni.charAt(8);

                    // Guarda el mòdul del DNI dividit per 23
                    numDni %= DIVISOR_LLETRA;

                    /*
                        Es comprova si el mòdul coincideix amb la posició del
                        conjunt de lletres
                    */
                    if (LLETRA_DNI.charAt(numDni) != caracter) {
                        // Si no coincideix mostra un missatge d'error
                        System.out.print("La lletra del DNI no és correcte."
                                + "\nEscriu-lo de nou: ");
                    } else {
                        // Si coincideix surt del bucle
                        dniCorrecte = true;
                    }

                } else {
                    // Si és certa mostra un missatge d'error
                    System.out.print("El DNI no és correcte. Escriu-lo de nou: ");
                }
            } else {
                // Si no ho és, mostra un missatge d'error
                System.out.print("El DNI no compte amb 9 dígits. Escriu-lo de nou: ");
            }
        }

        return dni; // Retorna el resultat del dni
    }

    /**
     * Mètode per demanar el nom del treballador
     * @return el nom obtingut
     */
    public static String demanarNom() {

        // Declaració de l'escàner
        Scanner sc = new Scanner(System.in);

        // Missatge per demanar el nom
        System.out.print("Introdueix el nom: ");
        String nom = sc.nextLine(); // Guarda el resultat

        return nom; // Retorna el resultat del nom
    }

    /**
     * Mètode per demanar l'edat del treballador
     * @return l'edat obtinguda
     */
    public static int demanarEdat() {
        
        // Declarció de variables
        int edat = 0; // Guarda l'edat
        // boolean per comprovar que l'edat és correcte
        boolean edatCorrecte = false;
        // final enter amb el valor d'edat negativa
        final int NOMBRE_NEGATIU = 0;

        // Missatge per demanar l'edat
        System.out.print("Introdueix l'edat: ");
        // while per comprovar que l'edat és correcte
        while (!edatCorrecte) {
            // Declaració d'escàner
            Scanner sc = new Scanner(System.in);
            // Condicional per comprovar si és enter el nombre introduït
            if (sc.hasNextInt()) {
                // El guarda si és enter
                edat = sc.nextInt();
                // Condicional intern per comprovar si és negatiu
                if (edat < NOMBRE_NEGATIU) {
                    // Si és negatiu, mostra un missatge d'error
                    System.out.print("ERROR. El nombre és negatiu."
                            + "\nTorna a introduir-lo de nou: ");
                } else {
                    // Si és positiu, surt del bucle
                    edatCorrecte = true;
                }
            } else {
                // Si no és enter, mostra un missatge d'error
                System.out.print("ERROR. El nombre no és enter."
                        + "\nTorna a introduir-lo de nou: ");
            }
        }
        
        return edat; // Retorna el resultat de l'edat
    }

    /**
     * Mètode per demanar l'alçada del treballador
     * @return l'alçada obtinguda
     */
    public static double demanarAltura() {

        // Declaració de variables
        double altura = 0; // Guarda l'alçada
        // boolean per comprovar si és correcte l'alçada
        boolean alturaCorrecte = false;
        // final decimal amb el valor d'alçada negativa
        final double NOMBRE_NEGATIU = 0;

        // Missatge per demanar l'alçada
        System.out.print("Introdueix l'alçada: ");
        // while per comprovar si l'alçada és correcte
        while (!alturaCorrecte) {
            // Declaració de l'escàner
            Scanner sc = new Scanner(System.in);
            // Condicional per comprovar si és decimal el nombre introduït
            if (sc.hasNextDouble()) {
                // Si és decimal el guarda
                altura = sc.nextDouble();
                // Condicional intern per comprovar si és negatiu
                if (altura <= NOMBRE_NEGATIU) {
                    // Si és negatiu el nombre, mostra un missatge d'error
                    System.out.print("ERROR. El nombre és negatiu."
                            + "\nTorna a introduir-lo de nou: ");
                } else {
                    // Si és positiu surt del bucle
                    alturaCorrecte = true;
                }
            } else {
                // Si no és decimal, mostra un missatge d'error
                System.out.print("ERROR. El nombre no és decimal."
                        + "\nTorna a introduir-lo de nou: ");
            }
        }

        return altura; // Retornar el resultat de l'alçada
    }

}
