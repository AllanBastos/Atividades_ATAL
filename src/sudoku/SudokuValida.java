package sudoku;
import java.util.*;

public class SudokuValida {
    public static void main(String[] args) {
        int n;
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        Integer[][] matriz = new Integer[n][n];

        for (int i=0; i<n; i++){
            for (int j = 0; j < n; j++) {
                matriz[i][j] = sc.nextInt();
            }
        }

        if(verificandoSudoku(matriz)){
            System.out.println("YES");
        }
        else{
            System.out.println("NO");
        }
        sc.close();
    }

    private static boolean verificandoSudoku(Integer[][] matriz) {
        return  verificarColunaLinha(matriz) &&
                verificarQuadrande(matriz);

    }

    private static boolean verificarQuadrande(Integer[][] matriz) {
        ArrayList<Integer> listQuadrantes = new ArrayList<>();
        int intQuadrante = (int) Math.sqrt(matriz.length);

        for (int i = 0; i < matriz.length; i+=intQuadrante) {
            for (int j = 0; j < matriz.length; j+=intQuadrante) {
                for (int k = i; k < intQuadrante+i ; k++) {
                    for (int l = j; l < intQuadrante+j; l++) {
                        int numeroAtual = matriz[k][l];
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

    private static boolean verificarColunaLinha(Integer[][] matriz) {
        List<Integer> linhas = new ArrayList<>();
        List<Integer> colunas = new ArrayList<>();

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz.length; j++) {
                int num = matriz[i][j];
                if(colunas.contains(num)){
                    return false;
                }
                colunas.add(num);
                num = matriz[j][i];
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

