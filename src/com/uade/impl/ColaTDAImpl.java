
package com.uade.impl;

import com.uade.api.ColaTDA;

public class ColaTDAImpl implements ColaTDA {
    private int[] elementos;
    private int inicio;
    private int fin;

    public ColaTDAImpl() {
        elementos = new int[100];
        inicio = 0;
        fin = 0;
    }

    public void inicializarCola() {
        inicio = 0;
        fin = 0;
    }

    public void acolar(int x) {
        if ((fin + 1) % elementos.length != inicio) {
            elementos[fin] = x;
            fin = (fin + 1) % elementos.length;
        } else {
            throw new IllegalStateException("La cola está llena.");
        }
    }

    public void desacolar() {
        if (!colaVacia()) {
            inicio = (inicio + 1) % elementos.length;
        } else {
            throw new IllegalStateException("La cola está vacía.");
        }
    }

    public int primero() {
        if (!colaVacia()) {
            return elementos[inicio];
        } else {
            throw new IllegalStateException("La cola está vacía.");
        }
    }

    public boolean colaVacia() {
        return inicio == fin;
    }
}
