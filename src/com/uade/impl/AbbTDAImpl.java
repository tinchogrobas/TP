package com.uade.impl;

import com.uade.api.ABBTDA;

public class AbbTDAImpl implements ABBTDA {
    public class NodoABB{
        int dato;
        ABBTDA hijoIzq;
        ABBTDA hijoDer;
    }

    NodoABB raiz;

    public void inicializarArbol() {
        raiz=null;
    }
    public int raiz() {
        return raiz.dato;
    }
    public ABBTDA hijoIzq() {
        return raiz.hijoIzq;
    }
    public ABBTDA hijoDer() {
        return raiz.hijoDer;
    }
    public boolean arbolVacio() {
        return (raiz==null);
    }
    public void agregar(int x) {
        if (raiz==null) {
            raiz=new NodoABB();
            raiz.dato=x;
            raiz.hijoIzq=new AbbTDAImpl();
            raiz.hijoIzq.inicializarArbol();
            raiz.hijoDer=new AbbTDAImpl();
            raiz.hijoDer.inicializarArbol();
        } else if (raiz.dato>x) {
            raiz.hijoIzq.agregar(x);
        } else if (raiz.dato < x) {
            raiz.hijoDer.agregar(x);
        }
    }
    public void eliminar(int x) {
        if (raiz!=null) {
            if (raiz.dato==x && raiz.hijoIzq.arbolVacio() && raiz.hijoDer.arbolVacio()) {
                raiz = null;
            } else if (raiz.dato==x && !raiz.hijoIzq.arbolVacio()) {
                raiz.dato=this.mayor(raiz.hijoIzq);
                raiz.hijoIzq.eliminar(raiz.dato);
            } else if (raiz.dato==x && raiz.hijoIzq.arbolVacio()) {
                raiz.dato=this.menor(raiz.hijoDer);
                raiz.hijoDer.eliminar(raiz.dato);
            } else if (raiz.dato<x) {
                raiz.hijoDer.eliminar(x);
            } else {
                raiz.hijoIzq.eliminar(x);
            }
        }
    }

    private int mayor (ABBTDA a) {
        if (a.hijoDer().arbolVacio()) {
            return a.raiz();
        } else {
            return mayor(a.hijoDer());
        }
    }
    private int menor (ABBTDA a) {
        if (a.hijoIzq().arbolVacio()) {
            return a.raiz();
        }
        else {
            return menor(a.hijoIzq());
        }
    }
}
