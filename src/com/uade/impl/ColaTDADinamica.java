package com.uade.impl;

import com.uade.api.ColaTDA;

public class ColaTDADinamica implements ColaTDA {
        class Nodo{
            int info;
            Nodo sig;
        }

        Nodo primero;
        Nodo ultimo;

        public void inicializarCola() {
            primero=null;
            ultimo=null;
        }

        public void acolar(int x) {
            Nodo nuevo = new Nodo();
            nuevo.info = x;
            nuevo.sig  = null;
            if (ultimo != null) {
                ultimo.sig=nuevo;
            }
            ultimo = nuevo;
            if (primero==null) {
                primero=ultimo;
            }
        }

        public void desacolar() {
            primero = primero.sig;
            if (primero == null) {
                ultimo = null;
            }
        }
        public boolean colaVacia() {
            return (ultimo==null);
        }

        public int primero() {
            return primero.info;
        }

    }

