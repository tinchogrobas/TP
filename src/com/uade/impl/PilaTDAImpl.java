
package com.uade.impl;

import com.uade.api.PilaTDA;

public class PilaTDAImpl implements PilaTDA {
    private int[] elementos;
    private int indice;

    public PilaTDAImpl() {
        this.elementos = new int[100];
        this.indice = 0;
    }

    public void inicializarPila() {
        this.indice = 0;
    }


    public void apilar(int x) {
        if (indice < elementos.length) {
            elementos[indice] = x;
            indice++;
        }
    }

    public void desapilar() {
        if (!pilaVacia()) {
            indice--;
        }
    }

    public int tope() {
        if (!pilaVacia()) {
            return elementos[indice - 1];
        }
        throw new IllegalStateException("La pila está vacía.");
    }

    public boolean pilaVacia() {
        return indice == 0;
    }
}
