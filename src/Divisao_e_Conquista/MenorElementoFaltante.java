package Divisao_e_Conquista;

import java.util.Objects;

public class MenorElementoFaltante {

    public static void main(String[] args) {
        Integer[] A = {0, 1, 2, 6, 9, 11, 15};
        Integer[] B = {1, 2, 3, 4, 6, 9, 11, 15};
        Integer[] C = {0, 1, 2, 3, 4, 5, 6, 8};

        System.out.println(menorElementoFaltante(A, null, null));
        System.out.println(menorElementoFaltante(B, null, null));
        System.out.println(menorElementoFaltante(C, null, null));

    }

    public static Integer menorElementoFaltante(Integer[] array, Integer inicio, Integer fim){
        inicio = Objects.isNull(inicio) ? 0 : inicio;
        fim = Objects.isNull(fim) ? array.length : fim;

        if( inicio > fim){
            return fim + 1;
        }
        if(!inicio.equals(array[inicio])){
            return inicio;
        }
        int meio = (inicio + fim)/ 2;

        return array[meio].equals(meio)? menorElementoFaltante(array, meio + 1, fim) : menorElementoFaltante(array, inicio, meio);
    }
}

