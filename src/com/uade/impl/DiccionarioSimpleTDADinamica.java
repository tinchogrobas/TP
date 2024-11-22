package com.uade.impl;

import com.uade.api.DiccionarioSimpleTDA;
import com.uade.api.ConjuntoTDA;

public class DiccionarioSimpleTDADinamica implements DiccionarioSimpleTDA {
    private class NodoClave{
        int clave;
        int valor;
        NodoClave sigClave;
    }
    private NodoClave origen;
    public void InicializarDiccionario() {
        origen=null;
    }
    public void Agregar(int clave,int valor) {
        NodoClave nc = Clave2NodoClave(clave);
        if (nc == null) {
            nc = new NodoClave();
            nc.clave = clave;
            nc.sigClave = origen;
            origen = nc;
        }
        nc.valor = valor;
    }
    private NodoClave Clave2NodoClave(int clave) {
        NodoClave aux = origen;
        while (aux!= null && aux.clave!=clave) {
            aux=aux.sigClave;
        }
        return aux;
    }
    public void Eliminar(int clave) {
        if(origen!=null) {
            if (origen.clave == clave) {
                origen = origen.sigClave;
            } else {
                NodoClave aux = origen;
                while (aux.sigClave!=null && aux.sigClave.clave != clave) {
                    aux=aux.sigClave;
                }
                if (aux.sigClave!=null) {
                    aux.sigClave=aux.sigClave.sigClave;
                }
            }
        }
    }

    public int Recuperar(int clave) {
        NodoClave nc = Clave2NodoClave(clave);
        return nc.valor;
    }

    public ConjuntoTDA Claves() {
        ConjuntoTDA c = new ConjuntoTDAImpl();
        c.inicializarConjunto();
        NodoClave aux = origen;
        while (aux!=null) {
            c.agregar(aux.clave);
            aux=aux.sigClave;
        }
        return c;
    }

}
