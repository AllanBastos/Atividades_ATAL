package Divisao_e_Conquista;

public class MedianaDeDoisArrays {

    public static void main(String[] args) {

        int n = 5;
        Integer[] arrayA = {0, 1, 2, 4, 5};
        Integer[] arrayB = {8, 9, 10, 12, 13};

        System.out.println(medianaDeDoisArrays(n, arrayA, arrayB));

    }

    public static Integer medianaDeDoisArrays(int n, Integer[] arrayA, Integer[] arrayB){

        Integer indexArrayA = 0;
        Integer indexArrayB = 0;

        Integer medianaArrayA = -1;
        Integer medianaArrayB = -1;

        for(int i=0; i <= n; ++i){

            if(indexArrayA.equals(n)){
                medianaArrayA = medianaArrayB;
                medianaArrayB = arrayB[0];
                break;
            }
            else if(indexArrayB.equals(n)){
                medianaArrayA = medianaArrayB;
                medianaArrayB = arrayA[0];
                break;
            }

            if(arrayA[indexArrayA] <= arrayB[indexArrayB]){
                medianaArrayA = medianaArrayB;
                medianaArrayB = arrayA[indexArrayA];
                indexArrayA++;
            }
            else{
                medianaArrayA = medianaArrayB;
                medianaArrayB = arrayB[indexArrayB];
                indexArrayB++;
            }
        }
        return ((medianaArrayA + medianaArrayB) / 2) ;
    }
}
