package Programacao_Dinamica;

import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.List;

public class Mochila {

    public static void main(String[] args) {
        Dictionary<Integer, ItemMochila> s = new Hashtable<>();

        s.put(1, new ItemMochila(6,30));
        s.put(2, new ItemMochila(3,14));
        s.put(3, new ItemMochila(4,16));
        s.put(4, new ItemMochila(2,9));

        System.out.println(mochila(s, s.size(), 10));

    }

    public static Integer mochila(Dictionary<Integer, ItemMochila> S, int n, int W){

        List<List<Integer>> m = new ArrayList<>();
        inicializaMatriz(m, n, W);

        for (int i = 1; i < n+1; i++) {
            for (int w = 1; w < W+1; w++) {
                if (S.get(i).peso > w){
                    m.get(w).set(i, m.get(w).get(i-1));
                }
                else{
                    m.get(w).set(i, Math.max(m.get(w-S.get(i).peso).get(i-1) + S.get(i).valor, m.get(w).get(i-1)));
                }
            }
        }

        System.out.println(m);

        return m.get(W).get(n);
        

    }

    private static void inicializaMatriz(List<List<Integer>> m, int n, int w) {
        for (int i = 0; i < w+1 ; i++) {
            m.add(new ArrayList<>());
            for (int j = 0; j < n+1; j++) {
                if (i == 0 || j == 0){
                    m.get(i).add(0);
                }
                else{
                    m.get(i).add(-1);
                }

            }
        }
    }

}
