package com.uade.impl;

import com.uade.api.PilaTDA;

public class PilaTDADinamica implements PilaTDA {
    class Nodo{
        int info;
        Nodo sig;
    }

    Nodo primero;

    public void inicializarPila() {
        primero=null;
    }

    public void apilar(int x) {
        Nodo nuevo = new Nodo();
        nuevo.info = x;
        nuevo.sig = primero;
        primero = nuevo;
    }

    public void desapilar() {
        primero = primero.sig;
    }

    public boolean pilaVacia() {
        return (primero==null);
    }

    public int tope() {
        return primero.info;
    }

}

