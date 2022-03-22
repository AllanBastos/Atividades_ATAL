package Programacao_Dinamica.Mochila;

import java.util.ArrayList;
import java.util.Dictionary;
import java.util.List;

public class MochilaRecursivaMemoizado {


    public static int mochilaRecursivaMemoizado(int W, Dictionary<Integer, ItemMochila> s, List<List<Integer>> m, int i){
        int q;
        if(m.get(i).get(W) >= 0){
            return m.get(i).get(W);
        }
        if(i == 0){
           q = 0;
        }
        else if(s.get(i).peso <= W){
            q = Math.max(mochilaRecursivaMemoizado(W - s.get(i).peso, s, m, i-1) + s.get(i).valor,
                    mochilaRecursivaMemoizado(W, s, m, i-1)
            );
        }
        else{
            q = mochilaRecursivaMemoizado(W, s, m, i-1);
        }

        m.get(i).set(W, q);

        return q;
    }

    static void inicializaMatriz(List<List<Integer>> m, int n, int w) {
        for (int i = 0; i < n ; i++) {
            m.add(new ArrayList<>());
            for (int j = 0; j < w+1; j++) {
                    m.get(i).add(-1);
            }
        }
    }

}


