package Programacao_Dinamica.LCS;

import java.util.*;

public class LCSBottomUp {
    static LCS lcsBottomUp(String[] X, String[] Y, int m, int n){
        List<List<Integer>> M = new ArrayList<>();
        List<List<String>> D = new ArrayList<>();
        inicializarMatrizes(M, D, m, n);

        for (int i = 0; i < m+1; i++) {
            for (int j = 0; j < n + 1; j++) {
                if (i == 0 || j == 0){
                    M.get(i).set(j, 0);
                }
                else if(Objects.equals(X[i - 1], Y[j - 1])){
                    M.get(i).set(j, M.get(i-1).get(j-1) + 1);
                    D.get(i).set(j, Constants.DIAGONAL);
                }
                else if(M.get(i-1).get(j) >= M.get(i).get(j-1)){
                    M.get(i).set(j, M.get(i-1).get(j));
                    D.get(i).set(j, Constants.UP);
                }else {
                    M.get(i).set(j, M.get(i).get(j-1));
                    D.get(i).set(j, Constants.LEFT);
                }
            }
        }
        return new LCS(M.get(m).get(n), D);

    }

    static void inicializarMatrizes(List<List<Integer>> M, List<List<String>> D, int m, int n){
        for (int i = 0; i <= m; i++) {
            M.add(new ArrayList<>());
            D.add(new ArrayList<>());
            for (int j = 0; j <= n; j++) {
                M.get(i).add(-1);
                D.get(i).add("-");
            }
        }
    }
}
