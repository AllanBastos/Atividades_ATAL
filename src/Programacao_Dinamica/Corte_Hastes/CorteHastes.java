package Programacao_Dinamica.Corte_Hastes;

public class CorteHastes {

    public static void main(String[] args) {
        Integer[] preco = {1, 5, 8, 9, 10, 17, 17, 20, 24, 30, 50, 60, 70, 80, 90, 100};

        long tempoInicial = System.currentTimeMillis();
        System.out.println(CortaHastes(preco, 10));
        System.out.printf("%f ms%n", (System.currentTimeMillis() - tempoInicial) / 1000d);


        tempoInicial = System.currentTimeMillis();
        System.out.println(CortaHastesBottomUp(preco, 10));
        System.out.printf("%f ms%n", (System.currentTimeMillis() - tempoInicial) / 1000d);


    }

    private static int CortaHastesBottomUp(Integer[] p, int n) {
        Integer[] r = new Integer[n+1];
        r[0] = 0;
        int q = 0;
        for (int j=1; j<=n; j++){
            q = 0;
            for(int i=1; i<=j; i++){
                q = Math.max(q, p[i] + r[j-i]);
            }
            r[j] = q;
        }
        return  q;
    }

    private static int CortaHastes(Integer[] p, Integer n) {
        if (n == 0){
            return 0;
        }

        int q = 0;

        for(int i=1; i <= n; i++){
            q = Math.max(q, p[i] + CortaHastes(p, n-i));
        }
        return q;
    }




}
