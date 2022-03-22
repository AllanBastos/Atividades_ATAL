package Programacao_Dinamica;

import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.List;

public class MochilaRecursivaMemoizado {
    public static void main(String[] args) {

        Dictionary<Integer, ItemMochila> s = new Hashtable<>();

        s.put(1, new ItemMochila(6,30));
        s.put(2, new ItemMochila(3,14));
        s.put(3, new ItemMochila(4,16));
        s.put(4, new ItemMochila(2,9));

        System.out.println(mochila(s, 10));
    }

    public static int mochila(Dictionary<Integer, ItemMochila> s, int W){

        int n = s.size() -1 ;

        List<List<Integer>> m = new ArrayList<>();
        inicializaMatriz(m, n, W);

        return mochilaRecursivaMemoizado(W, s, m, n);
    }

    public static int mochilaRecursivaMemoizado(int W, Dictionary<Integer, ItemMochila> s, List<List<Integer>> m, int i){
        int q;
        if(m.get(i).get(W) >= 0){
            return m.get(i).get(W);
        }
        if(i == 0){
           q = 0;
        }
        else if(s.get(i).peso <= W){
            q = Math.max(
                    mochilaRecursivaMemoizado(W - s.get(i).peso, s, m, i-1) + s.get(i).valor,
                    mochilaRecursivaMemoizado(W, s, m, i-1)
            );
        }
        else{
            q = mochilaRecursivaMemoizado(W, s, m, i-1);
        }

        m.get(i).set(W, q);

        return q;
    }

    private static void inicializaMatriz(List<List<Integer>> m, int n, int w) {
        for (int i = 0; i < n+1 ; i++) {
            m.add(new ArrayList<>());
            for (int j = 0; j < w+1; j++) {
                    m.get(i).add(-1);
            }
        }
    }

}


