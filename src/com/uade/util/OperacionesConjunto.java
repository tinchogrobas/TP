
package com.uade.util;

import com.uade.api.ColaTDA;
import com.uade.api.ConjuntoTDA;
import com.uade.api.PilaTDA;
import com.uade.impl.ConjuntoTDADinamica;

public class OperacionesConjunto {

    // Unión de dos conjuntos
    public static ConjuntoTDA union(ConjuntoTDA a, ConjuntoTDA b) {
        ConjuntoTDA c = new ConjuntoTDADinamica();
        c.inicializarConjunto();

        ConjuntoTDA aux = new ConjuntoTDADinamica();
        aux.inicializarConjunto();

        // Agregar elementos de A
        while (!a.conjuntoVacio()) {
            int elemento = a.elegir();
            c.agregar(elemento);
            aux.agregar(elemento);
            a.sacar(elemento);
        }

        // Restaurar A
        while (!aux.conjuntoVacio()) {
            int elemento = aux.elegir();
            a.agregar(elemento);
            aux.sacar(elemento);
        }

        // Agregar elementos de B
        while (!b.conjuntoVacio()) {
            int elemento = b.elegir();
            if (!c.pertenece(elemento)) {
                c.agregar(elemento);
            }
            aux.agregar(elemento);
            b.sacar(elemento);
        }

        // Restaurar B
        while (!aux.conjuntoVacio()) {
            int elemento = aux.elegir();
            b.agregar(elemento);
            aux.sacar(elemento);
        }

        return c;
    }


    public static ConjuntoTDA interseccion(ConjuntoTDA a, ConjuntoTDA b) {
        ConjuntoTDA c = new ConjuntoTDADinamica();
        c.inicializarConjunto();

        ConjuntoTDA aux = new ConjuntoTDADinamica();
        aux.inicializarConjunto();

        while (!a.conjuntoVacio()) {
            int elemento = a.elegir();
            if (b.pertenece(elemento)) {
                c.agregar(elemento);
            }
            aux.agregar(elemento);
            a.sacar(elemento);
        }

        while (!aux.conjuntoVacio()) {
            int elemento = aux.elegir();
            a.agregar(elemento);
            aux.sacar(elemento);
        }

        return c;
    }

    public static ConjuntoTDA diferencia(ConjuntoTDA a, ConjuntoTDA b) {
        ConjuntoTDA c = new ConjuntoTDADinamica();
        c.inicializarConjunto();

        ConjuntoTDA aux = new ConjuntoTDADinamica();
        aux.inicializarConjunto();

        while (!a.conjuntoVacio()) {
            int elemento = a.elegir();
            if (!b.pertenece(elemento)) {
                c.agregar(elemento);
            }
            aux.agregar(elemento);
            a.sacar(elemento);
        }

        while (!aux.conjuntoVacio()) {
            int elemento = aux.elegir();
            a.agregar(elemento);
            aux.sacar(elemento);
        }

        return c;
    }

    public static ConjuntoTDA diferenciaSimetricaSinOperaciones(ConjuntoTDA a, ConjuntoTDA b) {
        ConjuntoTDA c = new ConjuntoTDADinamica();
        c.inicializarConjunto();

        ConjuntoTDA auxA = new ConjuntoTDADinamica();
        auxA.inicializarConjunto();

        while (!a.conjuntoVacio()) {
            int elemento = a.elegir();
            if (!b.pertenece(elemento)) {
                c.agregar(elemento);
            }
            auxA.agregar(elemento);
            a.sacar(elemento);
        }

        while (!b.conjuntoVacio()) {
            int elemento = b.elegir();
            if (!auxA.pertenece(elemento)) {
                c.agregar(elemento);
            }
            b.sacar(elemento);
        }

        while (!auxA.conjuntoVacio()) {
            int elemento = auxA.elegir();
            a.agregar(elemento);
            auxA.sacar(elemento);
        }

        return c;
    }

    public static ConjuntoTDA diferenciaSimetrica(ConjuntoTDA a, ConjuntoTDA b) {
        ConjuntoTDA union = OperacionesConjunto.union(a, b);
        ConjuntoTDA interseccion = OperacionesConjunto.interseccion(a, b);
        return OperacionesConjunto.diferencia(union, interseccion);
    }


    public static boolean sonIguales(ConjuntoTDA a, ConjuntoTDA b) {
        ConjuntoTDA auxA = new ConjuntoTDADinamica();
        auxA.inicializarConjunto();
        boolean iguales = true;

        while (!a.conjuntoVacio() && iguales) {
            int elemento = a.elegir();
            if (!b.pertenece(elemento)) {
                iguales = false;
            }
            auxA.agregar(elemento);
            a.sacar(elemento);
        }

        while (!auxA.conjuntoVacio()) {
            int elemento = auxA.elegir();
            a.agregar(elemento);
            auxA.sacar(elemento);
        }

        return iguales && !b.conjuntoVacio();
    }


    public static int cardinalidad(ConjuntoTDA conjunto) {
        int contador = 0;
        ConjuntoTDA aux = new ConjuntoTDADinamica();
        aux.inicializarConjunto();

        while (!conjunto.conjuntoVacio()) {
            int elemento = conjunto.elegir();
            contador++;
            aux.agregar(elemento);
            conjunto.sacar(elemento);
        }

        while (!aux.conjuntoVacio()) {
            int elemento = aux.elegir();
            conjunto.agregar(elemento);
            aux.sacar(elemento);
        }

        return contador;
    }


    public static ConjuntoTDA comunesPilaCola(PilaTDA p, ColaTDA c) {
        ConjuntoTDA conjuntoP = new ConjuntoTDADinamica();
        conjuntoP.inicializarConjunto();

        while (!p.pilaVacia()) {
            conjuntoP.agregar(p.tope());
            p.desapilar();
        }

        ConjuntoTDA conjuntoC = new ConjuntoTDADinamica();
        conjuntoC.inicializarConjunto();

        while (!c.colaVacia()) {
            conjuntoC.agregar(c.primero());
            c.desacolar();
        }

        return OperacionesConjunto.interseccion(conjuntoP, conjuntoC);
    }


    public static boolean mismosElementosPilaCola(PilaTDA p, ColaTDA c) {
        ConjuntoTDA conjuntoP = new ConjuntoTDADinamica();
        conjuntoP.inicializarConjunto();

        while (!p.pilaVacia()) {
            conjuntoP.agregar(p.tope());
            p.desapilar();
        }

        ConjuntoTDA conjuntoC = new ConjuntoTDADinamica();
        conjuntoC.inicializarConjunto();

        while (!c.colaVacia()) {
            conjuntoC.agregar(c.primero());
            c.desacolar();
        }

        return sonIguales(conjuntoP, conjuntoC);
    }
}
