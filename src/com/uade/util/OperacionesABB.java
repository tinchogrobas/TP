package com.uade.util;

import com.uade.api.ABBTDA;
import com.uade.impl.AbbTDAImpl;
import com.uade.api.ConjuntoTDA;
import com.uade.impl.ConjuntoTDADinamica;

public class OperacionesABB {

    public static boolean perteneceIterativo(ABBTDA abb, int elemento) {
        while (!abb.arbolVacio()) {
            if (abb.raiz() == elemento) return true;
            abb = elemento < abb.raiz() ? abb.hijoIzq() : abb.hijoDer();
        }
        return false;
    }


    public static boolean perteneceRecursivo(ABBTDA abb, int elemento) {
        if (abb.arbolVacio()) return false;
        if (abb.raiz() == elemento) return true;
        return perteneceRecursivo(elemento < abb.raiz() ? abb.hijoIzq() : abb.hijoDer(), elemento);
    }


    public static boolean esHoja(ABBTDA abb, int elemento) {
        if (abb.arbolVacio()) return false;
        if (abb.raiz() == elemento) return abb.hijoIzq().arbolVacio() && abb.hijoDer().arbolVacio();
        return esHoja(elemento < abb.raiz() ? abb.hijoIzq() : abb.hijoDer(), elemento);
    }


    public static int profundidad(ABBTDA abb, int elemento) {
        if (abb.arbolVacio()) return -1;
        if (abb.raiz() == elemento) return 0;
        int subProfundidad = profundidad(elemento < abb.raiz() ? abb.hijoIzq() : abb.hijoDer(), elemento);
        return subProfundidad == -1 ? -1 : subProfundidad + 1;
    }


    public static int menor(ABBTDA abb) {
        if (abb.arbolVacio()) throw new RuntimeException("El árbol está vacío");
        return abb.hijoIzq().arbolVacio() ? abb.raiz() : menor(abb.hijoIzq());
    }


    public static int cantidadElementos(ABBTDA abb) {
        if (abb.arbolVacio()) return 0;
        return 1 + cantidadElementos(abb.hijoIzq()) + cantidadElementos(abb.hijoDer());
    }


    public static int sumaElementos(ABBTDA abb) {
        if (abb.arbolVacio()) return 0;
        return abb.raiz() + sumaElementos(abb.hijoIzq()) + sumaElementos(abb.hijoDer());
    }


    public static int cantidadHojas(ABBTDA abb) {
        if (abb.arbolVacio()) return 0;
        if (abb.hijoIzq().arbolVacio() && abb.hijoDer().arbolVacio()) return 1;
        return cantidadHojas(abb.hijoIzq()) + cantidadHojas(abb.hijoDer());
    }


    public static int altura(ABBTDA abb) {
        if (abb.arbolVacio()) return 0;
        return 1 + Math.max(altura(abb.hijoIzq()), altura(abb.hijoDer()));
    }


    public static boolean mismaForma(ABBTDA abb1, ABBTDA abb2) {
        if (abb1.arbolVacio() && abb2.arbolVacio()) return true;
        if (abb1.arbolVacio() || abb2.arbolVacio()) return false;
        return mismaForma(abb1.hijoIzq(), abb2.hijoIzq()) && mismaForma(abb1.hijoDer(), abb2.hijoDer());
    }


    public static boolean sonIguales(ABBTDA abb1, ABBTDA abb2) {
        if (abb1.arbolVacio() && abb2.arbolVacio()) return true;
        if (abb1.arbolVacio() || abb2.arbolVacio()) return false;
        if (abb1.raiz() != abb2.raiz()) return false;
        return sonIguales(abb1.hijoIzq(), abb2.hijoIzq()) && sonIguales(abb1.hijoDer(), abb2.hijoDer());
    }


    public static int elementosEnNivel(ABBTDA abb, int nivel) {
        if (abb.arbolVacio()) return 0;
        if (nivel == 0) return 1;
        return elementosEnNivel(abb.hijoIzq(), nivel - 1) + elementosEnNivel(abb.hijoDer(), nivel - 1);
    }


    public static void inOrden(ABBTDA abb) {
        if (!abb.arbolVacio()) {
            inOrden(abb.hijoIzq());
            System.out.print(abb.raiz() + " ");
            inOrden(abb.hijoDer());
        }
    }

    public static void preOrden(ABBTDA abb) {
        if (!abb.arbolVacio()) {
            System.out.print(abb.raiz() + " ");
            preOrden(abb.hijoIzq());
            preOrden(abb.hijoDer());
        }
    }

    public static void postOrden(ABBTDA abb) {
        if (!abb.arbolVacio()) {
            postOrden(abb.hijoIzq());
            postOrden(abb.hijoDer());
            System.out.print(abb.raiz() + " ");
        }
    }


    public static ConjuntoTDA mayoresQue(ABBTDA abb, int k) {
        ConjuntoTDA conjunto = new ConjuntoTDADinamica();
        conjunto.inicializarConjunto();
        agregarMayores(abb, k, conjunto);
        return conjunto;
    }

    private static void agregarMayores(ABBTDA abb, int k, ConjuntoTDA conjunto) {
        if (!abb.arbolVacio()) {
            if (abb.raiz() > k) conjunto.agregar(abb.raiz());
            agregarMayores(abb.hijoIzq(), k, conjunto);
            agregarMayores(abb.hijoDer(), k, conjunto);
        }
    }


    public static int predecesor(ABBTDA abb, int v) {
        return predecesorRec(abb, v, null);
    }

    private static int predecesorRec(ABBTDA abb, int v, Integer predecesor) {
        if (abb.arbolVacio()) return predecesor == null ? -1 : predecesor;
        if (abb.raiz() < v) predecesor = abb.raiz();
        return predecesorRec(v < abb.raiz() ? abb.hijoIzq() : abb.hijoDer(), v, predecesor);
    }
}
