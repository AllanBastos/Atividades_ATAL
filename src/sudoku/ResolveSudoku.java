package sudoku;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ResolveSudoku {

    private static final int TAMANHO_TABULEIRO = 9;
    private static final int SUBQUADRADO = TAMANHO_TABULEIRO != 0 ? (int) Math.sqrt(TAMANHO_TABULEIRO) : 3;
    private static final int VAZIO = 0;
    private static final int VALOR_MINIMO = 1;


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<List<List<Integer>>> listTabuleiros = new ArrayList<>();

        sc.nextLine();
        for (int tabelas = 0; tabelas < n; tabelas++) {
            List<List<Integer>> matriz = new ArrayList<>();

            for (int i = 0; i < TAMANHO_TABULEIRO; i++) {
               var linha = Arrays.stream(sc.nextLine().split("")).mapToInt(Integer::parseInt).toArray();
               ArrayList<Integer> linha2 = (ArrayList<Integer>) Arrays.stream(linha).boxed().collect(Collectors.toList());
               matriz.add(linha2);
            }
            listTabuleiros.add(matriz);
        }



        for (List<List<Integer>> soduku : listTabuleiros) {
            if(resolve(soduku)){
                imprimirSoduku(soduku);
            }else{
                System.out.println("Não deu :(");
            }
        }

        sc.close();
    }

    private static int[] posicaoLivre(List<List<Integer>> tabuleiro) {
        int[] posicao = new int[]{-1, -1};
        for (int linha = 0; linha < TAMANHO_TABULEIRO; linha++) {
            for (int coluna = 0; coluna < TAMANHO_TABULEIRO; coluna++) {
                if (tabuleiro.get(linha).get(coluna) == VAZIO) {
                    posicao = new int[]{linha, coluna};
                    return posicao;
                }
            }
        }
        return posicao;
    }

    private static boolean posicaoValida(List<List<Integer>> tabuleiro, int linha, int coluna, int num) {

        for (int i = 0; i < TAMANHO_TABULEIRO; i++) {
            if (num == tabuleiro.get(linha).get(i) || num == tabuleiro.get(i).get(coluna)) {
                return false;
            }
        }

        int linhaInicio = (linha / SUBQUADRADO) * SUBQUADRADO;
        int colunaInicio = (coluna / SUBQUADRADO) * SUBQUADRADO;
        for (int i = linhaInicio; i < linhaInicio + SUBQUADRADO; i++) {
            for (int j = colunaInicio; j < colunaInicio + SUBQUADRADO; j++) {
                if (tabuleiro.get(i).get(j).equals(num)) {
                    return false;
                }
            }
        }

        return true;
    }

    private static boolean resolve(List<List<Integer>> soduku){
        var pos = posicaoLivre(soduku);
        var linha = pos[0];
        var coluna= pos[1];
        if (linha == -1){
            return true;
        }

        for (int i = VALOR_MINIMO; i <= TAMANHO_TABULEIRO; i++) {
            if (posicaoValida(soduku, linha, coluna, i)){
                soduku.get(linha).set(coluna, i);
                if (resolve(soduku)){
                    return true;
                }
            }
            soduku.get(linha).set(coluna, VAZIO);
        }

        return false;
    }

    private static void imprimirSoduku(List<List<Integer>> soduku){
        for (int linha = 0; linha < TAMANHO_TABULEIRO ; linha++) {
            for (int coluna = 0; coluna < TAMANHO_TABULEIRO; coluna++) {
                System.out.printf("%d", soduku.get(linha).get(coluna));
            }
            System.out.println();
        }
    }

}
