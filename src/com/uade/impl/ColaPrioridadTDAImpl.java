
package com.uade.impl;

import com.uade.api.ColaPrioridadTDA;

public class ColaPrioridadTDAImpl implements ColaPrioridadTDA {
    int[] elementos;
    int[] prioridades;
    int indice;

    public void inicializarCola() {
        elementos = new int[100];
        prioridades = new int[100];
        indice = 0;
    }

    public void acolarPrioridad(int x, int prioridad) {
        int j = indice;
        while (j > 0 && prioridades[j - 1] > prioridad) {
            elementos[j] = elementos[j - 1];
            prioridades[j] = prioridades[j - 1];
            j--;
        }
        elementos[j] = x;
        prioridades[j] = prioridad;
        indice++;
    }

    public void desacolar() {
        indice--;
    }

    public boolean colaVacia() {
        return indice == 0;
    }

    public int primero() {
        return elementos[indice - 1];
    }

    public int prioridad() {
        return prioridades[indice - 1];
    }
}
