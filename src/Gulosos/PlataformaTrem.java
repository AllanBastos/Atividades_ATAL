package Gulosos;

import java.util.HashMap;
import java.util.Map;

public class PlataformaTrem {
    public static void main(String[] args) {
        Double[] chegada = {2.00, 2.10, 3.00, 3.20, 3.50, 5.00};
        Double[] saida   = {2.30, 3.40, 3.20, 4.30, 4.00, 5.20};

        System.out.println(minimaPlataformasTrem(chegada, saida));
    }

    private static int minimaPlataformasTrem(Double[] chegada, Double[] saida) {
        Map<Integer, Double[]> trilhos = new HashMap<>();
        trilhos.put(1, new Double[]{chegada[0], saida[0]});

        for(int i=1; i < chegada.length; i++){
            colocaTrem(chegada[i], saida[i], trilhos);
        }
        return trilhos.size();
    }

    private static void colocaTrem(Double chegada, Double saida, Map<Integer, Double[]> trilhos) {
        boolean condicao = false;

        for (int i: trilhos.keySet()){
            if(chegada >= trilhos.get(i)[1]){
                trilhos.put(i, new Double[]{chegada, saida});
                condicao = true;
                break;
            }
        }
        if(!condicao){
            trilhos.put(trilhos.size()+1, new Double[]{chegada, saida});
        }
    }


}
