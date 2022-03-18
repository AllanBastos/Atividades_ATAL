package Divisao_e_Conquista;

public class TetoPiso {
    public static void main(String[] args){

        Integer[] A = {1, 4, 6, 8, 9};
        int k = 10;

        for (int i = 0; i <= k; i++) {
            System.out.printf("k = %d -> teto = %d, piso = %d\n", i, teto(A, i), piso(A, i));
        }
    }

    private static int piso(Integer[] a, int k) {
        int piso = -1;
        if(k == a[0]){
            return a[0];
        }else if(k < a[0]){
            return -1;
        }

        int inicio  = 0;
        int fim = a.length-1;

        while (inicio <= fim){
            int meio = (inicio + fim) / 2;

            if (a[meio] == k){
                return a[meio];
            }
            else if(k < a[meio]){
                fim = meio - 1;
            }
            else{
                piso = a[meio];
                inicio = meio + 1;
            }
        }

        return piso;
    }

    private static int teto(Integer[] a, int k) {
        if(k > a[a.length-1]){
            return -1;
        }
        else if(k == a[a.length-1]){
            return a[a.length-1];
        }

        for (int elemento : a) {
            if(k <= elemento){
                return elemento;
            }
        }
        return -1;
    }

}
