package com.uade.impl;

import com.uade.api.DiccionarioMultipleTDA;
import com.uade.api.ConjuntoTDA;

public class DiccionarioMultipleImpl implements DiccionarioMultipleTDA {
    class Elemento{
        int clave;
        int[] valores;
        int cantValores;
    }

    private Elemento[] elementos;
    private int cantClaves;

    public void inicializarDiccionario() {
        elementos = new Elemento[100];
        cantClaves=0;
    }

    public void agregar(int clave, int valor) {
        int PosC = clave2Indice(clave);
        if (PosC==-1) {
            PosC=cantClaves;
            elementos[PosC] = new Elemento();
            elementos[PosC].clave=clave;
            elementos[PosC].cantValores=0;
            elementos[PosC].valores=new int[100];
            cantClaves++;
        }
        Elemento e = elementos[PosC];
        int PosV = valor2Indice(e,valor);
        if (PosV==-1) {
            e.valores[e.cantValores]=valor;
            e.cantValores++;
        }

    }

    public void eliminar(int clave) {
        int PosC = clave2Indice(clave);
        if (PosC !=-1) {
            elementos[PosC]= elementos[cantClaves -1];
            cantClaves--;
        }
    }
    public void eliminarValor(int clave, int valor) {
        int PosC = clave2Indice(clave);
        if(PosC!=-1) {
            Elemento e = elementos[PosC];
            int PosV = valor2Indice(e,valor);
            if (PosV != -1) {
                e.valores[PosV]= e.valores[e.cantValores-1];
                e.cantValores--;
            }
            if (e.cantValores==0) {
                eliminar(clave);
            }
        }

    }
    private int clave2Indice(int clave) {
        int i = cantClaves-1;
        while (i>=0 && elementos[i].clave!=clave) {
            i--;
        }
        return i;
    }

    private int valor2Indice(Elemento e, int valor) {
        int i = e.cantValores-1;
        while (i>=0 && e.valores[i]!=valor) {
            i--;
        }
        return i;
    }

    public ConjuntoTDA recuperar(int clave) {
        ConjuntoTDA c = new ConjuntoTDAImpl();
        c.inicializarConjunto();
        int PosC = clave2Indice(clave);
        if (PosC!=-1) {
            Elemento e = elementos[PosC];
            for (int i=0;i<e.cantValores;i++) {
                c.agregar(e.valores[i]);
            }
        }
        return c;
    }
    public ConjuntoTDA claves() {
        ConjuntoTDA c = new ConjuntoTDAImpl();
        c.inicializarConjunto();
        for (int i=0; i<cantClaves;i++) {
            c.agregar(elementos[i].clave);
        }
        return c;
    }
}
