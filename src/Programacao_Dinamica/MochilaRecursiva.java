package Programacao_Dinamica;

import java.util.Dictionary;
import java.util.Hashtable;


public class MochilaRecursiva {

    public static void main(String[] args) {
        Dictionary<Integer, ItemMochila> s = new Hashtable<>();

        s.put(1, new ItemMochila(6,30));
        s.put(2, new ItemMochila(3,14));
        s.put(3, new ItemMochila(4,16));
        s.put(4, new ItemMochila(2,9));

        System.out.println(mochilaRecursiva(10, s, s.size()));
    }

    private static int mochilaRecursiva(int W, Dictionary<Integer, ItemMochila> s,  int n) {
        if (n == 0 || W ==0){
            return 0;
        }

        if(s.get(n).peso > W){
            return  mochilaRecursiva(W, s, n-1);
        }
        else {
            return Math.max(s.get(n).valor + mochilaRecursiva(W - s.get(n).peso, s, n-1), mochilaRecursiva(W, s, n-1));
        }
    }

}
