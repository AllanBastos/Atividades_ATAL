package Programacao_Dinamica.LCS;

import java.util.ArrayList;
import java.util.List;

public class AppLCS {
    public static void main(String[] args) {
        String X = "ABCBDAB";
        String Y = "BDCABA";

        long tempoInicial = System.currentTimeMillis();
        System.out.println("LCS é: " + LCSREcursivo.lcsRecusivo(X.split(""), Y.split(""), X.length(), Y.length()));
        System.out.printf("%f ms%n", (System.currentTimeMillis() - tempoInicial) / 1000d);

        tempoInicial = System.currentTimeMillis();
        List<List<Integer>> m = new ArrayList<>();
        LCSRecursivoMemoizado.inicializarMatriz(m, X.length(), Y.length());
        System.out.println("\nLCS Memoizado é: " + LCSRecursivoMemoizado.lcsRecusivoMemoizado(X.split(""), Y.split(""), X.length(), Y.length(), m));
        System.out.printf("%f ms%n", (System.currentTimeMillis() - tempoInicial) / 1000d);

        tempoInicial = System.currentTimeMillis();
        System.out.println("\nLCS é Bottom Up: " + LCSBottomUp.lcsBottomUp(X.split(""), Y.split(""), X.length(), Y.length()));
        System.out.printf("%f ms%n", (System.currentTimeMillis() - tempoInicial) / 1000d);
    }
}
