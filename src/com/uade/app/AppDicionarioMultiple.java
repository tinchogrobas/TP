package com.uade.app;

import com.uade.api.ConjuntoTDA;
import com.uade.impl.DiccionarioMultipleImpl;

public class AppDicionarioMultiple {
    public static void main(String[] args) {
        DiccionarioMultipleImpl diccionario = new DiccionarioMultipleImpl();

        // Inicializar el diccionario
        diccionario.inicializarDiccionario();
        System.out.println("Diccionario inicializado.");

        // Agregar claves y valores
        diccionario.agregar(1, 10);
        diccionario.agregar(1, 20);
        diccionario.agregar(2, 30);
        diccionario.agregar(2, 40);
        diccionario.agregar(3, 50);
        System.out.println("Claves y valores agregados.");

        // Recuperar y mostrar valores asociados a una clave
        ConjuntoTDA valoresClave1 = diccionario.recuperar(1);
        System.out.print("Valores para la clave 1: ");
        while (!valoresClave1.conjuntoVacio()) {
            int valor = valoresClave1.elegir();
            System.out.print(valor + " ");
            valoresClave1.sacar(valor);
        }
        System.out.println();

        ConjuntoTDA valoresClave2 = diccionario.recuperar(2);
        System.out.print("Valores para la clave 2: ");
        while (!valoresClave2.conjuntoVacio()) {
            int valor = valoresClave2.elegir();
            System.out.print(valor + " ");
            valoresClave2.sacar(valor);
        }
        System.out.println();

        // Eliminar un valor específico
        diccionario.eliminarValor(1, 20);
        System.out.println("Valor 20 eliminado de la clave 1.");

        ConjuntoTDA valoresActualizadosClave1 = diccionario.recuperar(1);
        System.out.print("Valores para la clave 1 tras eliminación: ");
        while (!valoresActualizadosClave1.conjuntoVacio()) {
            int valor = valoresActualizadosClave1.elegir();
            System.out.print(valor + " ");
            valoresActualizadosClave1.sacar(valor);
        }
        System.out.println();

        // Eliminar una clave entera
        diccionario.eliminar(2);
        System.out.println("Clave 2 eliminada.");

        ConjuntoTDA clavesActuales = diccionario.claves();
        System.out.print("Claves actuales: ");
        while (!clavesActuales.conjuntoVacio()) {
            int clave = clavesActuales.elegir();
            System.out.print(clave + " ");
            clavesActuales.sacar(clave);
        }
        System.out.println();
    }

}
