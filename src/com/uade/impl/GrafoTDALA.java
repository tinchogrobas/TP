package com.uade.impl;

import com.uade.api.ConjuntoTDA;
import com.uade.api.GrafoTDA;

public class GrafoTDALA implements GrafoTDA {
    class NodoVertice{
        int nodo;
        NodoArista arista;
        NodoVertice sigNodo;
    }
    class NodoArista{
        int peso;
        NodoVertice nodoDestino;
        NodoArista sigArista;
    }

    NodoVertice origen;

    public void inicializarGrafo() {
        origen = null;
    }

    public void agregarVertice(int x) {
        NodoVertice nuevo = new NodoVertice();
        nuevo.nodo = x;
        nuevo.arista = null;
        nuevo.sigNodo = origen;
        origen = nuevo;
    }


    public void eliminarVertice(int x) {
        if (origen.nodo == x)
            origen = origen.sigNodo;
        NodoVertice aux = origen;
        while (aux != null) {
            this.EliminarAristaEnNodo(aux, x);
            if (aux.sigNodo != null && aux.sigNodo.nodo == x) {
                aux.sigNodo = aux.sigNodo.sigNodo;
            }
            aux = aux.sigNodo;
        }
    }

    private void EliminarAristaEnNodo(NodoVertice nodo, int v) {
        NodoArista aux = nodo.arista;
        if (aux != null) {
            if (aux.nodoDestino.nodo == v) {
                nodo.arista = aux.sigArista;
            } else {
                while(aux.sigArista != null && aux.sigArista.nodoDestino.nodo != v)
                    aux = aux.sigArista;
                if (aux.sigArista != null)
                    aux.sigArista = aux.sigArista.sigArista;
            }
        }
    }

    private NodoVertice Vertice2Nodo(int x) {
        NodoVertice aux = origen;
        while(aux !=null && aux.nodo != x)
            aux = aux.sigNodo;
        return aux;
    }

    public void agregarArista(int x, int y, int w) {
        NodoVertice n1 = Vertice2Nodo(x);
        NodoVertice n2 = Vertice2Nodo(y);
        NodoArista nuevo = new NodoArista();
        nuevo.peso = w;
        nuevo.nodoDestino = n2;
        nuevo.sigArista = n1.arista;
        n1.arista = nuevo;
    }


    public void eliminarArista(int x, int y) {
        NodoVertice n1 = Vertice2Nodo(x);
        EliminarAristaEnNodo(n1,y);

    }

    public int pesoArista(int x, int y) {
        NodoVertice nodo = Vertice2Nodo(x);
        NodoArista aux = nodo.arista;
        while (aux.nodoDestino.nodo != y)
            aux = aux.sigArista;
        return aux.peso;
    }

    public boolean ExisteArista(int x, int y) {
        NodoVertice nodo = Vertice2Nodo(x);
        NodoArista aux = nodo.arista;
        while (aux != null && aux.nodoDestino.nodo != y)
            aux = aux.sigArista;
        return (aux != null);
    }

    public ConjuntoTDA vertices() {
        ConjuntoTDA CNodos = new ConjuntoTDAImpl();
        CNodos.inicializarConjunto();
        NodoVertice aux = origen;
        while (aux != null) {
            CNodos.agregar(aux.nodo);
            aux = aux.sigNodo;
        }
        return CNodos;
    }
}
