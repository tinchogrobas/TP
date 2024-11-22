
package com.uade.util;

import com.uade.api.PilaTDA;
import com.uade.impl.PilaTDAImpl;

public class OperacionesPila {

    public static void pasarPilaInvertida(PilaTDA origen, PilaTDA destino) {
        PilaTDA aux = new PilaTDAImpl();
        aux.inicializarPila();

        while (!origen.pilaVacia()) {
            aux.apilar(origen.tope());
            origen.desapilar();
        }

        while (!aux.pilaVacia()) {
            int elemento = aux.tope();
            destino.apilar(elemento);
            origen.apilar(elemento); // Restaurar origen
            aux.desapilar();
        }
    }

    public static void copiarPila(PilaTDA origen, PilaTDA destino) {
        PilaTDA aux = new PilaTDAImpl();
        aux.inicializarPila();

        while (!origen.pilaVacia()) {
            aux.apilar(origen.tope());
            origen.desapilar();
        }

        while (!aux.pilaVacia()) {
            int elemento = aux.tope();
            origen.apilar(elemento);
            destino.apilar(elemento);
            aux.desapilar();
        }
    }

    public static void invertirPila(PilaTDA pila) {
        PilaTDA aux1 = new PilaTDAImpl();
        PilaTDA aux2 = new PilaTDAImpl();
        aux1.inicializarPila();
        aux2.inicializarPila();

        while (!pila.pilaVacia()) {
            aux1.apilar(pila.tope());
            pila.desapilar();
        }

        while (!aux1.pilaVacia()) {
            aux2.apilar(aux1.tope());
            aux1.desapilar();
        }

        while (!aux2.pilaVacia()) {
            pila.apilar(aux2.tope());
            aux2.desapilar();
        }
    }

    public static int contarElementos(PilaTDA pila) {
        PilaTDA aux = new PilaTDAImpl();
        aux.inicializarPila();
        int contador = 0;

        while (!pila.pilaVacia()) {
            aux.apilar(pila.tope());
            pila.desapilar();
            contador++;
        }

        while (!aux.pilaVacia()) {
            pila.apilar(aux.tope());
            aux.desapilar();
        }

        return contador;
    }

    public static int sumarElementos(PilaTDA pila) {
        PilaTDA aux = new PilaTDAImpl();
        aux.inicializarPila();
        int suma = 0;

        while (!pila.pilaVacia()) {
            suma += pila.tope();
            aux.apilar(pila.tope());
            pila.desapilar();
        }

        while (!aux.pilaVacia()) {
            pila.apilar(aux.tope());
            aux.desapilar();
        }

        return suma;
    }

    public static double promedioElementos(PilaTDA pila) {
        int suma = sumarElementos(pila);
        int cantidad = contarElementos(pila);
        return cantidad == 0 ? 0 : (double) suma / cantidad;
    }

    public static boolean esCapicua(PilaTDA pila) {
        PilaTDA aux1 = new PilaTDAImpl();
        PilaTDA aux2 = new PilaTDAImpl();
        PilaTDA aux3 = new PilaTDAImpl();
        aux1.inicializarPila();
        aux2.inicializarPila();
        aux3.inicializarPila();
        boolean capicua = true;

        while (!pila.pilaVacia()) {
            aux1.apilar(pila.tope());
            aux2.apilar(pila.tope());
            pila.desapilar();
        }

        while (!aux1.pilaVacia()) {
            pila.apilar(aux1.tope());
            aux3.apilar(aux1.tope());
            aux1.desapilar();
        }

        while (!aux2.pilaVacia()) {
            if (aux2.tope() != aux3.tope()) {
                capicua = false;
            }
            aux2.desapilar();
            aux3.desapilar();
        }

        return capicua;
    }

    public static void eliminarRepetidos(PilaTDA pila) {
        PilaTDA aux = new PilaTDAImpl();
        aux.inicializarPila();
        int cant = 0;
        int g = 0;
        int j = 0;

        while (!pila.pilaVacia()) {
            aux.apilar(pila.tope());
            pila.desapilar();
            cant++;
        }

        while (cant > 0) {
            for (int i = j; i >= 0; i--) {
                g = aux.tope();
                pila.apilar(g);
                aux.desapilar();
            }
            while (!aux.pilaVacia()) {
                if (aux.tope() != g) {
                    pila.apilar(aux.tope());
                } else {
                    cant--;
                }
                aux.desapilar();
            }
            while (!pila.pilaVacia()) {
                aux.apilar(pila.tope());
                pila.desapilar();
            }
            cant--;
            j++;
        }

        while (!aux.pilaVacia()) {
            pila.apilar(aux.tope());
            aux.desapilar();
        }
    }


    public static void repartirMitades(PilaTDA p, PilaTDA m1, PilaTDA m2) {
        PilaTDA auxiliar = new PilaTDAImpl();
        auxiliar.inicializarPila();

        while (!p.pilaVacia()) {
            auxiliar.apilar(p.tope());
            p.desapilar();
        }

        int mitad = 0;
        while (!auxiliar.pilaVacia()) {
            p.apilar(auxiliar.tope());
            auxiliar.desapilar();
            mitad++;
        }
        mitad /= 2;

        while (mitad > 0) {
            m1.apilar(p.tope());
            p.desapilar();
            mitad--;
        }
        while (!p.pilaVacia()) {
            m2.apilar(p.tope());
            p.desapilar();
        }

        while (!m1.pilaVacia()) {
            auxiliar.apilar(m1.tope());
            m1.desapilar();
        }
        while (!auxiliar.pilaVacia()) {
            m1.apilar(auxiliar.tope());
            auxiliar.desapilar();
        }

        while (!m2.pilaVacia()) {
            auxiliar.apilar(m2.tope());
            m2.desapilar();
        }
        while (!auxiliar.pilaVacia()) {
            m2.apilar(auxiliar.tope());
            auxiliar.desapilar();
        }
    }
}
