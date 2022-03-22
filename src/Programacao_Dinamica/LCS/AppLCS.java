package Programacao_Dinamica.LCS;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class AppLCS {
    public static void main(String[] args) {
        String X = "ABCBDAB";
        String Y = "BDCABA";

        long tempoInicial = System.currentTimeMillis();
        System.out.println("LCS é: " + LCSREcursivo.lcsRecusivo(X.split(""), Y.split(""), X.length(), Y.length()));
        System.out.printf("Tempo de excecução:%f ms%n", (System.currentTimeMillis() - tempoInicial) / 1000d);

        tempoInicial = System.currentTimeMillis();
        List<List<Integer>> m = new ArrayList<>();
        LCSRecursivoMemoizado.inicializarMatriz(m, X.length(), Y.length());
        System.out.println("\nLCS Memoizado é: " + LCSRecursivoMemoizado.lcsRecusivoMemoizado(X.split(""), Y.split(""), X.length(), Y.length(), m));
        System.out.printf("Tempo de excecução: %f ms%n\n", (System.currentTimeMillis() - tempoInicial) / 1000d);

        tempoInicial = System.currentTimeMillis();
        LCS bottomUp = LCSBottomUp.lcsBottomUp(X.split(""), Y.split(""), X.length(), Y.length());
        System.out.println("LCS BottomUp: " + bottomUp.LCS);
        System.out.print("A Sequencia é: ");
        imprimeLCS(bottomUp.D, X.split(""), X.length(), Y.length());
        System.out.printf("\nTempo de excecução:%f ms%n", (System.currentTimeMillis() - tempoInicial) / 1000d);
    }

    static void imprimeLCS(List<List<String>> b, String[] X, int i, int j){
        if (i == 0 || j == 0){
            return;
        }

        if(Objects.equals(b.get(i).get(j), Constants.DIAGONAL)){
            imprimeLCS(b, X, i-1, j-1);
            System.out.print(X[i-1]);
        }else if (Objects.equals(b.get(i).get(j), Constants.UP)){
            imprimeLCS(b, X, i-1, j);
        }else {
            imprimeLCS(b, X, i, j - 1);
        }

    }

}
