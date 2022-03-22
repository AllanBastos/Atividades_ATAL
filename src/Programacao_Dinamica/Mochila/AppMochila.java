package Programacao_Dinamica.Mochila;

import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.List;

import static Programacao_Dinamica.Mochila.Mochila.mochila;
import static Programacao_Dinamica.Mochila.MochilaRecursiva.mochilaRecursiva;
import static Programacao_Dinamica.Mochila.MochilaRecursivaMemoizado.inicializaMatriz;
import static Programacao_Dinamica.Mochila.MochilaRecursivaMemoizado.mochilaRecursivaMemoizado;

public class AppMochila {

    public static void main(String[] args) {
        Dictionary<Integer, ItemMochila> s = new Hashtable<>();

        s.put(1, new ItemMochila(6,30));
        s.put(2, new ItemMochila(3,14));
        s.put(3, new ItemMochila(4,16));
        s.put(4, new ItemMochila(2,9));

        int W  = 10;

        long tempoInicial = System.currentTimeMillis();
        System.out.println("Algoritmo da mochila: " + mochila(s, s.size(), W));
        System.out.printf("%f ms%n", (System.currentTimeMillis() - tempoInicial) / 1000d);

        tempoInicial = System.currentTimeMillis();
        System.out.println("\nAlgoritmo da mochila recursivo: " + mochilaRecursiva(W, s, s.size()));
        System.out.printf("%f ms%n", (System.currentTimeMillis() - tempoInicial) / 1000d);

        tempoInicial = System.currentTimeMillis();
        List<List<Integer>> m = new ArrayList<>();
        inicializaMatriz(m, s.size(), W);
        System.out.println("\nAlgoritmo da mochila recursivo memoizado: " + mochilaRecursivaMemoizado(W, s, m, s.size()-1));
        System.out.printf("%f ms%n", (System.currentTimeMillis() - tempoInicial) / 1000d);
    }
}
