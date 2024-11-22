
package com.uade.app;

import com.uade.api.ColaPrioridadTDA;
import com.uade.impl.ColaPrioridadTDAImpl;
import com.uade.util.OperacionesColaPrioridad;

public class AppColaPrioridad {

    public static void main(String[] args) {
        ColaPrioridadTDA cp1 = new ColaPrioridadTDAImpl();
        ColaPrioridadTDA cp2 = new ColaPrioridadTDAImpl();

        // Inicializar las colas
        cp1.inicializarCola();
        cp2.inicializarCola();

        // Añadir elementos a las colas
        cp1.acolarPrioridad(10, 3);
        cp1.acolarPrioridad(20, 2);
        cp1.acolarPrioridad(30, 1);

        cp2.acolarPrioridad(10, 3);
        cp2.acolarPrioridad(20, 2);
        cp2.acolarPrioridad(30, 1);

        // Probar si las colas son idénticas
        boolean sonIdenticas = OperacionesColaPrioridad.sonIdenticas(cp1, cp2);
        System.out.println("¿Son idénticas las colas?: " + sonIdenticas);

        // Combinar las colas
        ColaPrioridadTDA colaCombinada = OperacionesColaPrioridad.combinarColas(cp1, cp2);
        System.out.println("Cola combinada:");
        while (!colaCombinada.colaVacia()) {
            System.out.println("Elemento: " + colaCombinada.primero() + ", Prioridad: " + colaCombinada.prioridad());
            colaCombinada.desacolar();
        }
    }
}
