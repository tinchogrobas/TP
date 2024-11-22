
package com.uade.util;

import com.uade.api.ColaPrioridadTDA;
import com.uade.impl.ColaPrioridadTDAImpl;

public class OperacionesColaPrioridad {

    public static ColaPrioridadTDA combinarColas(ColaPrioridadTDA cp1, ColaPrioridadTDA cp2) {
        ColaPrioridadTDA nuevaCola = new ColaPrioridadTDAImpl();
        nuevaCola.inicializarCola();

        ColaPrioridadTDA copia1 = new ColaPrioridadTDAImpl();
        ColaPrioridadTDA copia2 = new ColaPrioridadTDAImpl();
        copia1.inicializarCola();
        copia2.inicializarCola();

        while (!cp1.colaVacia()) {
            nuevaCola.acolarPrioridad(cp1.primero(), cp1.prioridad());
            copia1.acolarPrioridad(cp1.primero(), cp1.prioridad());
            cp1.desacolar();
        }

        while (!cp2.colaVacia()) {
            nuevaCola.acolarPrioridad(cp2.primero(), cp2.prioridad());
            copia2.acolarPrioridad(cp2.primero(), cp2.prioridad());
            cp2.desacolar();
        }

        while (!copia1.colaVacia()) {
            cp1.acolarPrioridad(copia1.primero(), copia1.prioridad());
            copia1.desacolar();
        }

        while (!copia2.colaVacia()) {
            cp2.acolarPrioridad(copia2.primero(), copia2.prioridad());
            copia2.desacolar();
        }

        return nuevaCola;
    }


    public static boolean sonIdenticas(ColaPrioridadTDA cp1, ColaPrioridadTDA cp2) {
        ColaPrioridadTDA copia1 = new ColaPrioridadTDAImpl();
        ColaPrioridadTDA copia2 = new ColaPrioridadTDAImpl();
        copia1.inicializarCola();
        copia2.inicializarCola();

        boolean sonIdenticas = true;

        while (!cp1.colaVacia() && !cp2.colaVacia()) {
            if (cp1.primero() != cp2.primero() || cp1.prioridad() != cp2.prioridad()) {
                sonIdenticas = false;
            }
            copia1.acolarPrioridad(cp1.primero(), cp1.prioridad());
            copia2.acolarPrioridad(cp2.primero(), cp2.prioridad());
            cp1.desacolar();
            cp2.desacolar();
        }

        if (!cp1.colaVacia() || !cp2.colaVacia()) {
            sonIdenticas = false;
        }

        while (!copia1.colaVacia()) {
            cp1.acolarPrioridad(copia1.primero(), copia1.prioridad());
            copia1.desacolar();
        }

        while (!copia2.colaVacia()) {
            cp2.acolarPrioridad(copia2.primero(), copia2.prioridad());
            copia2.desacolar();
        }

        return sonIdenticas;
    }
}
