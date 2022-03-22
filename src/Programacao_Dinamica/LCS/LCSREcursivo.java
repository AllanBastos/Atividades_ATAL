package Programacao_Dinamica.LCS;

import java.util.Objects;

public class LCSREcursivo {

    public static int lcsRecusivo(String X[], String Y[], int m, int n){
        if (m == 0 || n == 0) {
            return 0;
        }

        if(Objects.equals(X[m - 1], Y[n - 1])) {
            return lcsRecusivo(X, Y, m-1, n-1) + 1;
        }

        return Math.max(lcsRecusivo(X, Y, m, n-1), lcsRecusivo(X, Y, m-1, n));

    }
}
