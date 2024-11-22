package com.uade.util;

import com.uade.api.ConjuntoTDA;
import com.uade.api.GrafoTDA;
import com.uade.impl.ConjuntoTDAImpl;

public class OperacionesGrafos {

    public static ConjuntoTDA AdyacentesDobles(GrafoTDA grafo, int v) {
        ConjuntoTDA aux = new ConjuntoTDAImpl();
        ConjuntoTDA aux2 = new ConjuntoTDAImpl();
        ConjuntoTDA c = new ConjuntoTDAImpl();
        aux.inicializarConjunto();
        aux2.inicializarConjunto();
        c.inicializarConjunto();
        aux = grafo.vertices();
        aux2 = grafo.vertices();
        aux.sacar(v);
        aux2.sacar(v);
        int v2;
        int v3;
        while (!aux.conjuntoVacio()) {
            v2 = aux.elegir();
            aux2 = grafo.vertices();
            aux2.sacar(v);
            if (grafo.ExisteArista(v, v2)) {
                while (!aux2.conjuntoVacio()) {
                    v3 = aux2.elegir();
                    if (grafo.ExisteArista(v2, v3) && v2 != v3) {
                        c.agregar(v3);
                    }
                    aux2.sacar(v3);
                }
            }
            aux.sacar(v2);
        }
        return c;
    }

    public static int MayCost(GrafoTDA grafo, int v) {
        ConjuntoTDA aux = new ConjuntoTDAImpl();
        aux.inicializarConjunto();
        aux = grafo.vertices();
        int v2;
        int mayor = 0;
        while (!aux.conjuntoVacio()) {
            v2 = aux.elegir();
            if (grafo.ExisteArista(v, v2)) {
                if (grafo.pesoArista(v, v2) > mayor) {
                    mayor = grafo.pesoArista(v, v2);
                }
            }
            aux.sacar(v2);
        }
        return mayor;
    }

    public static ConjuntoTDA Predecesor(GrafoTDA grafo, int v) {
        ConjuntoTDA aux = new ConjuntoTDAImpl();
        aux.inicializarConjunto();
        ConjuntoTDA c = new ConjuntoTDAImpl();
        c.inicializarConjunto();
        aux = grafo.vertices();
        int v2;
        while (!aux.conjuntoVacio()) {
            v2 = aux.elegir();
            if (grafo.ExisteArista(v2, v)) {
                c.agregar(v2);
            }
            aux.sacar(v2);
        }
        return c;
    }

    public static ConjuntoTDA Aislados(GrafoTDA grafo) {
        ConjuntoTDA aux = new ConjuntoTDAImpl();
        aux.inicializarConjunto();
        ConjuntoTDA c = new ConjuntoTDAImpl();
        c.inicializarConjunto();
        ConjuntoTDA aux2 = new ConjuntoTDAImpl();
        aux2.inicializarConjunto();
        aux = grafo.vertices();
        int v;
        int v2;
        boolean EsAislado;
        while (!aux.conjuntoVacio()) {
            aux2 = grafo.vertices();
            v = aux.elegir();
            EsAislado = true;
            while (EsAislado && !aux2.conjuntoVacio()) {
                v2 = aux2.elegir();
                if ((grafo.ExisteArista(v, v2) || grafo.ExisteArista(v2, v)) && (v != v2)) {
                    EsAislado = false;
                }
                aux2.sacar(v2);
            }
            if (EsAislado) {
                c.agregar(v);
            }
            aux.sacar(v);
        }
        return c;
    }

    public static ConjuntoTDA Puentes(GrafoTDA grafo, int v, int v2) {
        ConjuntoTDA c = new ConjuntoTDAImpl();
        c.inicializarConjunto();
        ConjuntoTDA aux = new ConjuntoTDAImpl();
        aux.inicializarConjunto();
        aux = grafo.vertices();
        int g;
        while (!aux.conjuntoVacio()) {
            g = aux.elegir();
            if (grafo.ExisteArista(v, g) && grafo.ExisteArista(g, v2) && v != v2) {
                c.agregar(g);
            }
            aux.sacar(g);
        }
        return c;
    }

    public static int Grado(GrafoTDA grafo, int v) {
        int grado = 0;
        int g;
        ConjuntoTDA aux = new ConjuntoTDAImpl();
        aux.inicializarConjunto();
        aux = grafo.vertices();
        while (!aux.conjuntoVacio()) {
            g = aux.elegir();
            if (grafo.ExisteArista(v, g)) {
                grado++;
            }
            if (grafo.ExisteArista(g, v)) {
                grado--;
            }
            aux.sacar(g);
        }
        return grado;
    }
}
