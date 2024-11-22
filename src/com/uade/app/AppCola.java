
package com.uade.app;

import com.uade.api.ColaTDA;
import com.uade.impl.ColaTDAImpl;
import com.uade.util.OperacionesCola;

public class AppCola {
    public static void main(String[] args) {
        ColaTDA cola1 = new ColaTDAImpl();
        cola1.inicializarCola();
        cola1.acolar(10);
        cola1.acolar(20);
        cola1.acolar(30);

        ColaTDA cola2 = new ColaTDAImpl();
        cola2.inicializarCola();
        cola2.acolar(30);
        cola2.acolar(20);
        cola2.acolar(10);

        System.out.println("Probando métodos de OperacionesCola:");

        // a) Pasar una Cola a otra
        ColaTDA colaPasada = new ColaTDAImpl();
        colaPasada.inicializarCola();
        OperacionesCola.pasarCola(cola1, colaPasada);
        System.out.println("Pasar cola: ");
        imprimirCola(colaPasada);

        // b) Invertir cola con pila
        OperacionesCola.invertirColaConPila(colaPasada);
        System.out.println("Cola invertida con pila: ");
        imprimirCola(colaPasada);

        // c) Invertir cola sin pila
        OperacionesCola.invertirColaSinPila(colaPasada);
        System.out.println("Cola invertida sin pila: ");
        imprimirCola(colaPasada);

        // d) Final coincide
        boolean finalCoincide = OperacionesCola.finalCoincide(cola1, cola2);
        System.out.println("El final de cola1 coincide con cola2: " + finalCoincide);

        // e) Es capicúa
        boolean capicua = OperacionesCola.esCapicua(colaPasada);
        System.out.println("La cola es capicúa: " + capicua);

        // f) Son inversas
        boolean inversas = OperacionesCola.sonInversas(cola1, cola2);
        System.out.println("Cola1 y Cola2 son inversas: " + inversas);
    }

    private static void imprimirCola(ColaTDA cola) {
        ColaTDA aux = new ColaTDAImpl();
        aux.inicializarCola();

        while (!cola.colaVacia()) {
            int elemento = cola.primero();
            System.out.print(elemento + " ");
            aux.acolar(elemento);
            cola.desacolar();
        }

        System.out.println();

        while (!aux.colaVacia()) {
            cola.acolar(aux.primero());
            aux.desacolar();
        }
    }
}
