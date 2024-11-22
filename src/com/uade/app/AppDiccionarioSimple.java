package com.uade.app;

import com.uade.api.DiccionarioSimpleTDA;
import com.uade.impl.DiccionarioSimpleImpl;

public class AppDiccionarioSimple {
    public static void main(String[] args) {
        DiccionarioSimpleTDA diccionario = new DiccionarioSimpleImpl();
        diccionario.InicializarDiccionario();

        // Agregar claves y valores
        diccionario.Agregar(1, 10);
        diccionario.Agregar(2, 20);
        diccionario.Agregar(3, 30);
        diccionario.Agregar(1, 15); // Reemplazo del valor

        // Mostrar claves
        System.out.println("Claves en el diccionario:");
        imprimirClaves(diccionario);

        // Recuperar valor por clave
        System.out.println("Valor asociado a la clave 1: " + diccionario.Recuperar(1));
        System.out.println("Valor asociado a la clave 2: " + diccionario.Recuperar(2));

        // Eliminar clave
        diccionario.Eliminar(2);
        System.out.println("Claves después de eliminar la clave 2:");
        imprimirClaves(diccionario);
    }

    private static void imprimirClaves(DiccionarioSimpleTDA diccionario) {
        com.uade.api.ConjuntoTDA claves = diccionario.Claves();
        while (!claves.conjuntoVacio()) {
            int clave = claves.elegir();
            System.out.print(clave + " ");
            claves.sacar(clave);
        }
        System.out.println();
    }
}
