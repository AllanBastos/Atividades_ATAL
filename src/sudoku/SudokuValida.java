package sudoku;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SudokuValida {
    public static void main(String[] args) {
        int n;
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        List<List<Integer>> sudoku = new ArrayList<>();
        Integer[][] matriz = new Integer[n][n];
        for (int i=0; i<n; i++){
            for (int j = 0; j < n; j++) {
                matriz[i][j] = sc.nextInt();
            }
        }

        for (Integer[] array : matriz) {
            sudoku.add(List.of(array));
        }


        if(verificandoSudoku(sudoku)){
            System.out.println("YES");
        }
        else{
            System.out.println("NO");
        }
        sc.close();
    }

    private static boolean verificandoSudoku(List<List<Integer>> matriz) {
        return  verificarColunaLinha(matriz) &&
                verificarQuadrande(matriz);

    }

    private static boolean verificarQuadrande(List<List<Integer>> matriz) {
        ArrayList<Integer> listQuadrantes = new ArrayList<>();
        int intQuadrante = (int) Math.sqrt(matriz.size());
        int tamanhoMatriz = matriz.size();
        for (int i = 0; i < tamanhoMatriz; i+=intQuadrante) {
            for (int j = 0; j < tamanhoMatriz; j+=intQuadrante) {
                for (int k = i; k < intQuadrante+i ; k++) {
                    for (int l = j; l < intQuadrante+j; l++) {
                        int numeroAtual = matriz.get(k).get(l);
                        if (listQuadrantes.contains(numeroAtual)){
                            return false;
                        }
                        listQuadrantes.add(numeroAtual);
                    }
                }
                listQuadrantes.clear();
            }
        }

        return true;

    }

    private static boolean verificarColunaLinha(List<List<Integer>> matriz) {
        List<Integer> linhas = new ArrayList<>();
        List<Integer> colunas = new ArrayList<>();
        int tamanhoMatriz = matriz.size();
        for (int i = 0; i < tamanhoMatriz; i++) {
            for (int j = 0; j < tamanhoMatriz; j++) {
                int num = matriz.get(i).get(j);
                if(colunas.contains(num)){
                    return false;
                }
                colunas.add(num);
                num = matriz.get(j).get(i);
                if (linhas.contains(num)) {
                    return false;
                }
                linhas.add(num);

            }
            linhas.clear();
            colunas.clear();
        }

        return true;
    }

}

