package com.uade.impl;

import com.uade.api.ConjuntoTDA;

public class ConjuntoTDADinamica implements ConjuntoTDA {
    private class Nodo{
        int info;
        Nodo sig;
    }

    private Nodo c;

    public void inicializarConjunto() {
        c=null;
    }

    public int elegir() {
        return c.info;
    }

    public void sacar(int x) {
        if (c!=null) {
            if (c.info==x) {
                c=c.sig;
            } else {
                Nodo aux=c;
                while(aux.sig!=null && aux.sig.info!=x) {
                    aux=aux.sig;
                }
                if (aux.sig!=null) {
                    aux.sig=aux.sig.sig;
                }
            }
        }
    }

    public void agregar(int x) {
        if (!this.pertenece(x)) {
            Nodo nuevo = new Nodo();
            nuevo.info=x;
            nuevo.sig=c;
            c=nuevo;
        }
    }

    public boolean pertenece(int x) {
        Nodo aux = c;
        while(aux!=null && aux.info!=x) {
            aux = aux.sig;
        }
        return (aux!=null);
    }

    public boolean conjuntoVacio() {
        return (c==null);
    }
}
