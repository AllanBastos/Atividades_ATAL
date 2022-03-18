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


        for (int tabelas = 0; tabelas < n; tabelas++) {
            List<List<Integer>> matriz = new ArrayList<>();
            sc.nextLine();
            for (int i = 0; i < TAMANHO_TABULEIRO; i++) {
               var linha = Arrays.stream(sc.nextLine().split("")).mapToInt(Integer::parseInt).toArray();
               ArrayList<Integer> linha2 = (ArrayList<Integer>) Arrays.stream(linha).boxed().collect(Collectors.toList());
               matriz.add(linha2);
            }
            listTabuleiros.add(matriz);
        }


//        for (Integer[][] soduku : listTabuleiros) {
//            if(resolve(soduku)){
//                imprimirSoduku(soduku);
//            }else{
//                System.out.println("Não deu :(");
//            }
//        }

        sc.close();
    }

    private static int[] posicaoLivre(Integer[][] tabuleiro) {
        int[] posicao = new int[]{VAZIO, VAZIO};
        for (int linha = 0; linha < TAMANHO_TABULEIRO; linha++) {
            for (int coluna = 0; coluna < TAMANHO_TABULEIRO; coluna++) {
                if (tabuleiro[linha][coluna] == VAZIO) {
                    posicao = new int[]{linha, coluna};
                    return posicao;
                }
            }
        }
        return posicao;
    }

    private static boolean posicaoValida(Integer[][] tabuleiro, int linha, int coluna, int num) {

        for (int i = 0; i < TAMANHO_TABULEIRO; i++) {
            if (num == tabuleiro[linha][i] || num == tabuleiro[i][coluna]) {
                return false;
            }
        }

        int linhaInicio = (linha / SUBQUADRADO) * SUBQUADRADO;
        int colunaInicio = (coluna / SUBQUADRADO) * SUBQUADRADO;
        for (int i = linhaInicio; i < linhaInicio + SUBQUADRADO; i++) {
            for (int j = colunaInicio; j < colunaInicio + SUBQUADRADO; j++) {
                if (tabuleiro[i][j] == num) {
                    return false;
                }
            }
        }

        return true;
    }

    private static boolean resolve(Integer[][] soduku){
        var pos = posicaoLivre(soduku);
        var linha = pos[0];
        var coluna= pos[1];
        if (linha == VAZIO){
            return true;
        }

        for (int i = VALOR_MINIMO; i <= TAMANHO_TABULEIRO; i++) {
            if (posicaoValida(soduku, linha, coluna, i)){
                soduku[linha][coluna] = i;
                if (resolve(soduku)){
                    return true;
                }
            }
            soduku[linha][coluna] = VAZIO;
        }

        return false;
    }

    private static void imprimirSoduku(List<List<Integer>> soduku){
        for (int linha = 0; linha < TAMANHO_TABULEIRO ; linha++) {
            for (int coluna = 0; coluna < TAMANHO_TABULEIRO; coluna++) {
                System.out.printf("%d%s", soduku.get(linha).get(coluna), (linha != TAMANHO_TABULEIRO-1 && coluna == TAMANHO_TABULEIRO-1) ? " " : "");
            }
            System.out.println();
        }
    }

}
