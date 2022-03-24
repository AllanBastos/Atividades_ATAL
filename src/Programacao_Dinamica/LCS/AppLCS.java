package Programacao_Dinamica.LCS;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class AppLCS {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long tempoInicial = 0;

        System.out.print("Insira a sequencia A:");
        String X = sc.nextLine();//"ABCBDAB";
        System.out.print("Insira a sequencia B:");
        String Y = sc.nextLine();//"BDCABA";
        System.out.println("\nEscolha o algoritmo \n1 para recursivo\n2 para recursivo memoizado\n3 para programação dinamica");
        int op = sc.nextInt();

        System.out.println("Iniciando");
        switch (op){

            case 1: {
                tempoInicial = System.currentTimeMillis();
                System.out.println("LCS é: " + LCSREcursivo.lcsRecusivo(X.split(""), Y.split(""), X.length(), Y.length()));
                System.out.printf("Tempo de excecução: %f s", (System.currentTimeMillis() - tempoInicial) / 1000d);
                break;
            }
            case 2: {
                List<List<Integer>> m = new ArrayList<>();
                tempoInicial = System.currentTimeMillis();
                LCSRecursivoMemoizado.inicializarMatriz(m, X.length(), Y.length());
                System.out.println("\nLCS Memoizado é: " + LCSRecursivoMemoizado.lcsRecusivoMemoizado(X.split(""), Y.split(""), X.length(), Y.length(), m));
                System.out.printf("Tempo de excecução: %f s\n", (System.currentTimeMillis() - tempoInicial) / 1000d);
                break;
            }
            case 3:{
                tempoInicial = System.currentTimeMillis();
                LCS bottomUp = LCSBottomUp.lcsBottomUp(X.split(""), Y.split(""), X.length(), Y.length());
                System.out.println("LCS BottomUp: " + bottomUp.LCS);
                System.out.printf("Tempo de excecução: %f s\n", (System.currentTimeMillis() - tempoInicial) / 1000d);
                System.out.print("A Sequencia é: ");
                imprimeLCS(bottomUp.D, X.split(""), X.length(), Y.length());
                break;
            }
            default:
                System.out.println("Opção invalida");
        }
        System.out.println("\nFim");
        sc.close();
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
