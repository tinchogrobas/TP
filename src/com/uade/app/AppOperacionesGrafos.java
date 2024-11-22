package com.uade.app;

import com.uade.api.GrafoTDA;
import com.uade.api.ConjuntoTDA;
import com.uade.impl.GrafoTDALA;
import com.uade.util.OperacionesGrafos;

public class AppOperacionesGrafos {
    public static void main(String[] args) {
        GrafoTDA grafo = new GrafoTDALA();
        grafo.inicializarGrafo();

        // Agregar vértices
        grafo.agregarVertice(1);
        grafo.agregarVertice(2);
        grafo.agregarVertice(3);
        grafo.agregarVertice(4);
        grafo.agregarVertice(5);

        // Agregar aristas con peso
        grafo.agregarArista(1, 2, 10);
        grafo.agregarArista(1, 3, 15);
        grafo.agregarArista(2, 4, 5);
        grafo.agregarArista(3, 5, 20);
        grafo.agregarArista(4, 5, 25);

        System.out.println("Pruebas de OperacionesGrafos:");

        // Adyacentes dobles
        ConjuntoTDA adyacentesDobles = OperacionesGrafos.AdyacentesDobles(grafo, 1);
        System.out.print("Adyacentes dobles de 1: ");
        imprimirConjunto(adyacentesDobles);

        // Mayor costo de aristas salientes
        int mayorCosto = OperacionesGrafos.MayCost(grafo, 1);
        System.out.println("Mayor costo de aristas salientes de 1: " + mayorCosto);

        // Predecesores
        ConjuntoTDA predecesores = OperacionesGrafos.Predecesor(grafo, 5);
        System.out.print("Predecesores de 5: ");
        imprimirConjunto(predecesores);

        // Vértices aislados
        ConjuntoTDA aislados = OperacionesGrafos.Aislados(grafo);
        System.out.print("Vértices aislados: ");
        imprimirConjunto(aislados);

        // Puentes
        ConjuntoTDA puentes = OperacionesGrafos.Puentes(grafo, 1, 5);
        System.out.print("Puentes entre 1 y 5: ");
        imprimirConjunto(puentes);

        // Grado de un vértice
        int grado = OperacionesGrafos.Grado(grafo, 1);
        System.out.println("Grado de 1: " + grado);
    }

    private static void imprimirConjunto(ConjuntoTDA conjunto) {
        while (!conjunto.conjuntoVacio()) {
            int elemento = conjunto.elegir();
            System.out.print(elemento + " ");
            conjunto.sacar(elemento);
        }
        System.out.println();
    }
}
