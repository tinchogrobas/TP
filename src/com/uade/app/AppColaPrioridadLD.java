
package com.uade.app;

import com.uade.api.ColaPrioridadTDA;
import com.uade.impl.ColaPrioridadTDADinamica;

public class AppColaPrioridadLD {

    public static void main(String[] args) {
        ColaPrioridadTDA cola = new ColaPrioridadTDADinamica();

        // Inicializar la cola
        cola.inicializarCola();

        // Acolar elementos con prioridades
        cola.acolarPrioridad(10, 3);
        cola.acolarPrioridad(20, 5);
        cola.acolarPrioridad(30, 1);
        cola.acolarPrioridad(40, 4);

        // Mostrar elementos en orden de prioridad
        System.out.println("Elementos en la cola con prioridad:");
        while (!cola.colaVacia()) {
            System.out.println("Elemento: " + cola.primero() + ", Prioridad: " + cola.prioridad());
            cola.desacolar();
        }
    }
}
