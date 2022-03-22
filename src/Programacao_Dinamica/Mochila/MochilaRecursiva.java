package Programacao_Dinamica.Mochila;

import java.util.Dictionary;


public class MochilaRecursiva {

    static int mochilaRecursiva(int W, Dictionary<Integer, ItemMochila> s, int n) {
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
