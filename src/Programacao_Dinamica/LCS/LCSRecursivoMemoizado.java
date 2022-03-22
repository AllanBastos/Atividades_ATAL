package Programacao_Dinamica.LCS;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class LCSRecursivoMemoizado {
    public static int lcsRecusivoMemoizado(String[] X, String[] Y, int m, int n, List<List<Integer>> M){
        if (m == 0 || n == 0) {
            return 0;
        }

        if(M.get(m - 1).get(n - 1) != -1){
            return M.get(m - 1).get(n - 1);
        }

        if (Objects.equals(X[m - 1], Y[n - 1])){
            M.get(m - 1).set(n - 1, 1 + lcsRecusivoMemoizado(X, Y, m - 1, n - 1, M));
            return M.get(m - 1).get(n - 1);
        }

        M.get(m - 1).set(n - 1, Math.max(lcsRecusivoMemoizado(X, Y, m, n - 1, M), lcsRecusivoMemoizado(X, Y, m - 1, n, M)));
        return M.get(m - 1).get(n - 1);

    }

    static void inicializarMatriz(List<List<Integer>> M, int m, int n){
        for (int i = 0; i < m; i++) {
            M.add(new ArrayList<>());
            for (int j = 0; j < n; j++) {
                M.get(i).add(-1);
            }
        }
    }
}
