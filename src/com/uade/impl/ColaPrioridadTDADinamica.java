package com.uade.impl;

import com.uade.api.ColaPrioridadTDA;

public class ColaPrioridadTDADinamica implements ColaPrioridadTDA {
    class NodoPrioridad {
        int info;
        int prioridad;
        NodoPrioridad sig;
    }

    NodoPrioridad primero;

    public void inicializarCola() {
        primero=null;
    }

    public void acolarPrioridad(int x, int prioridad) {
        NodoPrioridad nuevo = new NodoPrioridad();
        nuevo.info=x;
        nuevo.prioridad=prioridad;
        if (primero == null || primero.prioridad<prioridad){
            nuevo.sig=primero;
            primero=nuevo;
        } else {
            NodoPrioridad aux = primero;
            while (aux.sig!=null && aux.sig.prioridad>prioridad) {
                aux=aux.sig;
            }
            nuevo.sig=aux.sig;
            aux.sig=nuevo;
        }
    }

    public void desacolar() {
        primero=primero.sig;
    }
    public boolean colaVacia() {
        return(primero==null);
    }
    public int primero() {
        return primero.info;
    }
    public int prioridad() {
        return primero.prioridad;
    }

}
