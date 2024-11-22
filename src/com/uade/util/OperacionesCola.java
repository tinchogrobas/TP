
package com.uade.util;

import com.uade.api.ColaTDA;
import com.uade.api.ConjuntoTDA;
import com.uade.api.PilaTDA;
import com.uade.impl.ColaTDAImpl;
import com.uade.impl.ConjuntoTDADinamica;

public class OperacionesCola {


    public static void pasarCola(ColaTDA origen, ColaTDA destino) {
        ColaTDA aux = new ColaTDAImpl();
        aux.inicializarCola();

        while (!origen.colaVacia()) {
            int elemento = origen.primero();
            destino.acolar(elemento);
            aux.acolar(elemento);
            origen.desacolar();
        }

        while (!aux.colaVacia()) {
            origen.acolar(aux.primero());
            aux.desacolar();
        }
    }


    public static void invertirColaConPila(ColaTDA cola) {
        PilaTDA pila = new com.uade.impl.PilaTDAImpl();
        pila.inicializarPila();

        while (!cola.colaVacia()) {
            pila.apilar(cola.primero());
            cola.desacolar();
        }

        while (!pila.pilaVacia()) {
            cola.acolar(pila.tope());
            pila.desapilar();
        }
    }


    public static void invertirColaSinPila(ColaTDA cola) {
        ColaTDA aux1 = new ColaTDAImpl();
        ColaTDA aux2 = new ColaTDAImpl();
        aux1.inicializarCola();
        aux2.inicializarCola();

        while (!cola.colaVacia()) {
            aux1.acolar(cola.primero());
            cola.desacolar();
        }

        while (!aux1.colaVacia()) {
            aux2.acolar(aux1.primero());
            aux1.desacolar();
        }

        while (!aux2.colaVacia()) {
            cola.acolar(aux2.primero());
            aux2.desacolar();
        }
    }


    public static boolean finalCoincide(ColaTDA c1, ColaTDA c2) {
        ColaTDA aux1 = new ColaTDAImpl();
        ColaTDA aux2 = new ColaTDAImpl();
        aux1.inicializarCola();
        aux2.inicializarCola();

        while (!c1.colaVacia()) {
            aux1.acolar(c1.primero());
            c1.desacolar();
        }

        while (!c2.colaVacia()) {
            aux2.acolar(c2.primero());
            c2.desacolar();
        }

        boolean coincide = true;

        while (!aux1.colaVacia() && !aux2.colaVacia()) {
            int elem1 = aux1.primero();
            int elem2 = aux2.primero();
            if (elem1 != elem2) {
                coincide = false;
            }
            c1.acolar(elem1);
            c2.acolar(elem2);
            aux1.desacolar();
            aux2.desacolar();
        }

        return coincide && aux1.colaVacia() && aux2.colaVacia();
    }


    public static boolean esCapicua(ColaTDA cola) {
        PilaTDA pila = new com.uade.impl.PilaTDAImpl();
        pila.inicializarPila();
        ColaTDA aux = new ColaTDAImpl();
        aux.inicializarCola();

        while (!cola.colaVacia()) {
            int elemento = cola.primero();
            pila.apilar(elemento);
            aux.acolar(elemento);
            cola.desacolar();
        }

        boolean capicua = true;
        while (!aux.colaVacia()) {
            int frente = aux.primero();
            int finalPila = pila.tope();
            if (frente != finalPila) {
                capicua = false;
            }
            cola.acolar(frente);
            aux.desacolar();
            pila.desapilar();
        }

        return capicua;
    }


    public static boolean sonInversas(ColaTDA c1, ColaTDA c2) {
        PilaTDA pila = new com.uade.impl.PilaTDAImpl();
        pila.inicializarPila();

        ColaTDA aux1 = new ColaTDAImpl();
        ColaTDA aux2 = new ColaTDAImpl();
        aux1.inicializarCola();
        aux2.inicializarCola();

        while (!c1.colaVacia()) {
            int elemento = c1.primero();
            pila.apilar(elemento);
            aux1.acolar(elemento);
            c1.desacolar();
        }

        while (!c2.colaVacia()) {
            int elemento = c2.primero();
            aux2.acolar(elemento);
            c2.desacolar();
        }

        boolean inversas = true;
        while (!aux2.colaVacia() && !pila.pilaVacia()) {
            if (aux2.primero() != pila.tope()) {
                inversas = false;
            }
            c1.acolar(aux1.primero());
            c2.acolar(aux2.primero());
            aux1.desacolar();
            aux2.desacolar();
            pila.desapilar();
        }

        return inversas && pila.pilaVacia() && aux2.colaVacia();
    }

    public static void eliminarRepetidos(ColaTDA cola) {
        ConjuntoTDA elementosUnicos = new ConjuntoTDADinamica();
        elementosUnicos.inicializarConjunto();
        ColaTDA auxiliar = new ColaTDAImpl();
        auxiliar.inicializarCola();

        while (!cola.colaVacia()) {
            int elemento = cola.primero();
            cola.desacolar();
            if (!elementosUnicos.pertenece(elemento)) {
                elementosUnicos.agregar(elemento);
                auxiliar.acolar(elemento);
            }
        }

        while (!auxiliar.colaVacia()) {
            cola.acolar(auxiliar.primero());
            auxiliar.desacolar();
        }
    }


    public static void repartirMitades(ColaTDA cola, ColaTDA m1, ColaTDA m2) {
        int cantidad = 0;
        ColaTDA auxiliar = new ColaTDAImpl();
        auxiliar.inicializarCola();

        while (!cola.colaVacia()) {
            cantidad++;
            auxiliar.acolar(cola.primero());
            cola.desacolar();
        }

        cantidad /= 2;
        while (!auxiliar.colaVacia()) {
            int elemento = auxiliar.primero();
            auxiliar.desacolar();
            cola.acolar(elemento);
            if (cantidad > 0) {
                m1.acolar(elemento);
                cantidad--;
            } else {
                m2.acolar(elemento);
            }
        }
    }

    public static ConjuntoTDA elementosRepetidos(ColaTDA cola) {
        ConjuntoTDA elementos = new ConjuntoTDADinamica();
        elementos.inicializarConjunto();
        ConjuntoTDA repetidos = new ConjuntoTDADinamica();
        repetidos.inicializarConjunto();
        ColaTDA auxiliar = new ColaTDAImpl();
        auxiliar.inicializarCola();

        while (!cola.colaVacia()) {
            int elemento = cola.primero();
            cola.desacolar();
            if (elementos.pertenece(elemento)) {
                repetidos.agregar(elemento);
            } else {
                elementos.agregar(elemento);
            }
            auxiliar.acolar(elemento);
        }

        while (!auxiliar.colaVacia()) {
            cola.acolar(auxiliar.primero());
            auxiliar.desacolar();
        }

        return repetidos;
    }
}
