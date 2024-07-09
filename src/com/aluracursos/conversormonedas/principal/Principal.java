/*
Autora: Andrea Rivas G.
Proyecto: CONVERSOR DE MONEDAS
Fecha de creacion: 08/07/24 -- 8:30pm
Modificaciones:
10:30pm termine.
09/07/24 -- 10:30am: agregue el README.
 */
package com.aluracursos.conversormonedas.principal;
import com.aluracursos.conversormonedas.modelos.ConversorAPI;

import java.util.Scanner;

public class Principal {
    /* INSTRUCCIONES
    Usando GSON, API= ExchangeRate-API.
    Menu con 6 opciones de cambio de moneda + 1 opcion de salir.
    Despues de realizar una conversion debe de volver a salir el menu.
     */
    public static double valor;
    public static Scanner sc = new Scanner(System.in);
    public static int msgs() {
        int op;
        System.out.println("----- MENU CONVERSOR DE MONEDAS -----");
        System.out.println("[1] Dolares a pesos argentinos");
        System.out.println("[2] Peso argentino a dolar");
        System.out.println("[3] Dolar a real brasileño");
        System.out.println("[4] Real brasileño a dolar");
        System.out.println("[5] Dolar a peso colombiano");
        System.out.println("[6] Peso colombiano a dolar");
        System.out.println("[7] Salir");
        System.out.println("ELIJE UNA OPCION VALIDA: ");
        System.out.println(" ------------------------------------");
        op = sc.nextInt();
        return op;
    }

    public static int opcion(){
        return msgs();
    }

    public static void main(String[] args) {
        int opcionn;
        ConversorAPI conversor = new ConversorAPI(); // Crear una instancia de ConversorAPI
        do {
            opcionn = opcion();
            switch (opcionn) {
                case 1: {
                    // Dolar a peso argentino
                    valor = cifraConvertir();
                    conversor.convertir(opcionn, valor); // Llamar al método convertir con el valor ingresado
                    System.out.println("Aqui esta la conversion de dolares a pesos argentinos. ");
                    break;
                }
                case 2: {
                    // peso argentino a dolar
                    conversor.convertir(opcionn, valor);
                    System.out.println(" Aqui esta la conversion de pesos argentinos a dolares.");
                    break;
                }
                case 3: {
                    // dolar a real brasileño
                    conversor.convertir(opcionn, valor);
                    System.out.println(" Aqui esta la conversion de dolar a real brasileño: ");
                    break;
                }
                case 4: {
                    // real brasileño a dolar
                    conversor.convertir(opcionn, valor);
                    System.out.println(" Aqui esta la conversion de real brasileños a dolares: ");
                    break;
                }
                case 5: {
                    // dolar a peso colombiano
                    System.out.println(" Aqui esta la conversion de dolar a peso colombiano: ");
                    break;
                }
                case 6: {
                    // peso colombiano a dolar
                    conversor.convertir(opcionn, valor);
                    System.out.println(" Aqui esta la conversion de pesos colombianos a dolares: ");
                    break;
                }
                case 7: {
                    // salir
                    System.out.println("GRACIAS POR UTILIZAR MI CONVERSOR DE MONEDAS :) ");
                    break;
                }
            }
        } while (opcionn != 7);
    }

    public static double cifraConvertir() {
        System.out.println("Ingresa el valor que deseas convertir:");
        valor = sc.nextDouble();
        return valor;
    }

}