
package com.uade.app;

import com.uade.api.ConjuntoTDA;
import com.uade.api.ColaTDA;
import com.uade.api.PilaTDA;
import com.uade.impl.ConjuntoTDADinamica;
import com.uade.impl.ColaTDAImpl;
import com.uade.impl.PilaTDAImpl;
import com.uade.util.OperacionesConjunto;

public class AppConjunto {
    public static void main(String[] args) {
        // Crear conjuntos A y B
        ConjuntoTDA conjuntoA = new ConjuntoTDADinamica();
        conjuntoA.inicializarConjunto();
        conjuntoA.agregar(1);
        conjuntoA.agregar(2);
        conjuntoA.agregar(3);

        ConjuntoTDA conjuntoB = new ConjuntoTDADinamica();
        conjuntoB.inicializarConjunto();
        conjuntoB.agregar(3);
        conjuntoB.agregar(4);
        conjuntoB.agregar(5);

        // a) Diferencia simétrica sin operaciones
        ConjuntoTDA diferenciaSimetrica = OperacionesConjunto.diferenciaSimetricaSinOperaciones(conjuntoA, conjuntoB);
        System.out.print("Diferencia simétrica sin operaciones: ");
        imprimirConjunto(diferenciaSimetrica);

        // b) Diferencia simétrica con operaciones
        diferenciaSimetrica = OperacionesConjunto.diferenciaSimetrica(conjuntoA, conjuntoB);
        System.out.print("Diferencia simétrica con operaciones: ");
        imprimirConjunto(diferenciaSimetrica);

        // c) Verificar si dos conjuntos son iguales
        boolean iguales = OperacionesConjunto.sonIguales(conjuntoA, conjuntoB);
        System.out.println("¿Conjuntos A y B son iguales? " + iguales);

        // d) Cardinalidad
        int cardinalidad = OperacionesConjunto.cardinalidad(conjuntoA);
        System.out.println("Cardinalidad de A: " + cardinalidad);

        // e) Elementos comunes entre Pila y Cola
        PilaTDA pila = new PilaTDAImpl();
        pila.inicializarPila();
        pila.apilar(1);
        pila.apilar(2);
        pila.apilar(3);

        ColaTDA cola = new ColaTDAImpl();
        cola.inicializarCola();
        cola.acolar(3);
        cola.acolar(4);
        cola.acolar(5);

        ConjuntoTDA comunes = OperacionesConjunto.comunesPilaCola(pila, cola);
        System.out.print("Elementos comunes entre Pila y Cola: ");
        imprimirConjunto(comunes);

        // f) Verificar si los elementos de Pila y Cola son iguales
        boolean mismos = OperacionesConjunto.mismosElementosPilaCola(pila, cola);
        System.out.println("¿Elementos de Pila y Cola son iguales? " + mismos);
    }

    private static void imprimirConjunto(ConjuntoTDA conjunto) {
        ConjuntoTDA aux = new ConjuntoTDADinamica();
        aux.inicializarConjunto();

        while (!conjunto.conjuntoVacio()) {
            int elemento = conjunto.elegir();
            System.out.print(elemento + " ");
            aux.agregar(elemento);
            conjunto.sacar(elemento);
        }
        System.out.println();

        while (!aux.conjuntoVacio()) {
            int elemento = aux.elegir();
            conjunto.agregar(elemento);
            aux.sacar(elemento);
        }
    }
}
