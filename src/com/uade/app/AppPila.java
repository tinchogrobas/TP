
package com.uade.app;

import com.uade.api.PilaTDA;
import com.uade.impl.PilaTDAImpl;
import com.uade.util.OperacionesPila;

public class AppPila {
    public static void main(String[] args) {
        PilaTDA pila = new PilaTDAImpl();
        pila.inicializarPila();

        pila.apilar(1);
        pila.apilar(2);
        pila.apilar(3);
        pila.apilar(2);
        pila.apilar(1);
        System.out.println("Pila cargada con elementos.");

        boolean capicua = OperacionesPila.esCapicua(pila);
        System.out.println("¿La pila es capicúa? " + capicua);

        // Probar eliminarRepetidos
        OperacionesPila.eliminarRepetidos(pila);
        System.out.println("Pila después de eliminar elementos repetidos:");
        imprimirPila(pila);

        // Probar repartirMitades
        PilaTDA mitad1 = new PilaTDAImpl();
        PilaTDA mitad2 = new PilaTDAImpl();
        mitad1.inicializarPila();
        mitad2.inicializarPila();

        pila.apilar(4);
        pila.apilar(5);
        OperacionesPila.repartirMitades(pila, mitad1, mitad2);
        System.out.println("Mitad 1:");
        imprimirPila(mitad1);
        System.out.println("Mitad 2:");
        imprimirPila(mitad2);
    }

    private static void imprimirPila(PilaTDA pila) {
        PilaTDA auxiliar = new PilaTDAImpl();
        auxiliar.inicializarPila();
        while (!pila.pilaVacia()) {
            System.out.print(pila.tope() + " ");
            auxiliar.apilar(pila.tope());
            pila.desapilar();
        }
        System.out.println();
        while (!auxiliar.pilaVacia()) {
            pila.apilar(auxiliar.tope());
            auxiliar.desapilar();
        }
    }
}
