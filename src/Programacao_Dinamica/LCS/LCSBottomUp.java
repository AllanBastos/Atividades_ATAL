package Programacao_Dinamica.LCS;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class LCSBottomUp {
    static int lcsBottomUp(String[] X, String[] Y, int m, int n){
        List<List<Integer>> M = new ArrayList<>();
        inicializarMatriz(M, m, n);

        for (int i = 0; i < m+1; i++) {
            for (int j = 0; j < n + 1; j++) {
                if (i == 0 || j == 0){
                    M.get(i).set(j, 0);
                }
                else if(Objects.equals(X[i - 1], Y[j - 1])){
                    M.get(i).set(j, M.get(i-1).get(j-1) + 1);
                }
                else {
                    M.get(i).set(j, Math.max(M.get(i-1).get(j), M.get(i).get(j-1)));
                }
            }
        }
        return M.get(m).get(n);
    }

    static void inicializarMatriz(List<List<Integer>> M, int m, int n){
        for (int i = 0; i <= m; i++) {
            M.add(new ArrayList<>());
            for (int j = 0; j <= n; j++) {
                M.get(i).add(-1);
            }
        }
    }
}
