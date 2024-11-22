
package com.uade.app;

import com.uade.impl.AbbTDAImpl;
import com.uade.api.ABBTDA;

public class AppABB {
    public static void main(String[] args) {
        ABBTDA abb = new AbbTDAImpl();
        abb.inicializarArbol();

        // Agregar elementos al ABB
        abb.agregar(10);
        abb.agregar(5);
        abb.agregar(15);
        abb.agregar(2);
        abb.agregar(7);
        abb.agregar(12);
        abb.agregar(20);

        System.out.println("Árbol inicial:");
        imprimirArbol(abb);

        // Eliminar un elemento
        abb.eliminar(10);
        System.out.println("Árbol después de eliminar la raíz (10):");
        imprimirArbol(abb);

        // Eliminar un elemento sin hijos
        abb.eliminar(2);
        System.out.println("Árbol después de eliminar una hoja (2):");
        imprimirArbol(abb);

        // Eliminar un elemento con un solo hijo
        abb.eliminar(15);
        System.out.println("Árbol después de eliminar un nodo con un hijo (15):");
        imprimirArbol(abb);
    }

    private static void imprimirArbol(ABBTDA arbol) {
        if (!arbol.arbolVacio()) {
            System.out.print(arbol.raiz() + " ");
            imprimirArbol(arbol.hijoIzq());
            imprimirArbol(arbol.hijoDer());
        }
    }
}
