/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.pt11.utilitzaciodehashmap;

import java.util.Scanner;

/**
 *
 * @author Bea i Yamila
 */
public class PT113UtilitzaciodeHashMap {

    public static void main(String[] args) {

        double altura, alturaSup;
        int i = 1, edat;
        String dni, nom, resposta;
        boolean mapOmplert = false;

        Empresa e = new Empresa();

        do {
            boolean respostaCorrecte = false;
            Scanner sc = new Scanner(System.in);

            System.out.println("--- Treballador " + i + " ---");

            dni = demanarDni();
            nom = demanarNom();
            edat = demanarEdat();
            altura = demanarAltura();

            Treballador t = new Treballador(dni, nom, edat, altura);

            e.clauLliure(t.getDni(), t);

            do {
                System.out.print("Vols afegir un altre treballador(S/N)? ");
                resposta = sc.nextLine();

                if (resposta.equalsIgnoreCase("S")) {

                    respostaCorrecte = true;
                    i++;

                } else if (resposta.equalsIgnoreCase("N")) {

                    respostaCorrecte = true;
                    mapOmplert = true;

                } else {
                    System.out.println("ERROR. Respota incorrecte. Torna a respondre.");
                }
            } while (!respostaCorrecte);

        } while (!mapOmplert);

        System.out.println("--- Calcular edat mitjana de l'empresa ---");
        int mitjana = e.getMitjana();
        System.out.println("La edat mijana de l'empresa és: " + mitjana);

        System.out.println("--- Llista dels treballadors que superen l'alçada especificada ---");
        alturaSup = demanarAltura();

        if (e.alturaSuperior(alturaSup) == null) {
            System.out.println("Cap treballador supera els " + alturaSup + ".");
        } else {
            System.out.println(e.alturaSuperior(alturaSup));
        }

        System.out.println("--- Plantilla de tota l'empresa ---");
        System.out.println(e.toString());

    }

    public static String demanarDni() {

        int numDni, i = 0, comptador = 0;
        char lletra = ' ';
        String dni = "", lletresDni;
        boolean dniCorrecte = false, lletraTrobada = false;
        final int LONGITUD_DNI = 8;
        final String NUMEROS_DNI = "1234567890", LLETRA_DNI = "TRWAGMYFPDXBNJZSQVHLCKE";

        System.out.print("Introdueix el DNI: ");

        while (!dniCorrecte) {
            Scanner sc = new Scanner(System.in);
            dni = sc.nextLine();

            if (dni.length() == 9) {
                while (!lletraTrobada && i < 7) {
                    lletra = dni.charAt(i);
                    if (NUMEROS_DNI.indexOf(lletra) == -1) {
                        lletraTrobada = true;
                    }
                    i++;
                }
                if (!lletraTrobada) {

                    lletresDni = dni.substring(0, 8);
                    lletra = dni.charAt(8);
                    numDni = Integer.parseInt(lletresDni);

                    numDni %= 23;

                    if (LLETRA_DNI.charAt(numDni) != lletra) {
                        System.out.print("El DNI no és correcte. Escriu-lo de nou: ");
                    } else {
                        dniCorrecte = true;
                    }

                } else {
                    System.out.println("El DNI no és correcte. Escriu-lo de nou: ");
                }
            } else {
                System.out.println("El DNI no és correcte. Escriu-lo de nou: ");
            }
        }

        return dni;
    }

    public static String demanarNom() {

        Scanner sc = new Scanner(System.in);

        String nom;

        System.out.print("Introdueix el nom: ");
        nom = sc.nextLine();

        return nom;
    }

    public static int demanarEdat() {

        int edat = 0;
        boolean edatCorrecte = false;
        final int NOMBRE_NEGATIU = 0;

        System.out.print("Introdueix l'edat: ");

        while (!edatCorrecte) {
            Scanner sc = new Scanner(System.in);

            if (sc.hasNextInt()) {
                edat = sc.nextInt();
                if (edat < NOMBRE_NEGATIU) {
                    System.out.print("ERROR. El nombre és negatiu."
                            + "\nTorna a introduir-lo de nou: ");
                } else {
                    edatCorrecte = true;
                }
            } else {
                System.out.print("ERROR. El nombre no és enter."
                        + "\nTorna a introduir-lo de nou: ");
            }
        }
        return edat;
    }

    public static double demanarAltura() {

        double altura = 0;
        boolean alturaCorrecte = false;
        final double NOMBRE_NEGATIU = 0;

        System.out.print("Introdueix l'alçada: ");

        while (!alturaCorrecte) {
            Scanner sc = new Scanner(System.in);
            if (sc.hasNextDouble()) {
                altura = sc.nextDouble();
                if (altura <= NOMBRE_NEGATIU) {
                    System.out.print("ERROR. El nombre és negatiu."
                            + "\nTorna a introduir-lo de nou: ");
                } else {
                    alturaCorrecte = true;
                }
            } else {
                System.out.print("ERROR. El nombre no és decimal."
                        + "\nTorna a introduir-lo de nou: ");
            }
        }

        return altura;
    }

}
