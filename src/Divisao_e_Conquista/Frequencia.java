package Divisao_e_Conquista;

import java.util.*;

public class Frequencia {
    public static void main(String[] args) {
        Integer[] a = {2, 2, 2, 4, 4, 4, 5, 5, 6, 8, 8, 9};

        ocorrencia(a);

    }

    private static void ocorrencia(Integer[] array) {

        List<Integer> auxiliar = new ArrayList<>();

        for (int elemento : array) {
            if (!auxiliar.contains(elemento)) {
                int posicaoPrimeiraOcorrencia = primeiraOcorrencia(array, elemento );
                int posicaoUltimaOcorrencia = ultimaOcorrencia(array, elemento);
                int ocorrencias = (posicaoUltimaOcorrencia - posicaoPrimeiraOcorrencia) + 1;
                System.out.printf("%d ocorre %d vez%s\n", elemento, ocorrencias, ocorrencias > 1 ? "es" : "");
                auxiliar.add(elemento);
            }
        }
    }

    private static int primeiraOcorrencia(Integer[] array, int n) {
        int inicioArray = 0;
        int fimArray = array.length - 1;
        int posicaoAtual = -1;

        while (inicioArray <= fimArray) {

            int meioArray = (inicioArray + fimArray) / 2;

            if (n == array[meioArray]) {
                posicaoAtual = meioArray;
                fimArray = meioArray - 1;
            }

            else if (n < array[meioArray]) {
                fimArray = meioArray - 1;
            }
            else {
                inicioArray = meioArray + 1;
            }
        }

        return posicaoAtual;
    }

    private static int ultimaOcorrencia(Integer[] array, int n) {

        int inicioArray = 0;
        int fimArray = array.length - 1;
        int posicaoAtual = -1;

        while (inicioArray <= fimArray) {

            int meioArray = (inicioArray + fimArray) / 2;

            if (n == array[meioArray]) {
                posicaoAtual = meioArray;
                inicioArray = meioArray + 1;
            }
            else if (n < array[meioArray]) {
                fimArray = meioArray - 1;
            }
            else {
                inicioArray = meioArray + 1;
            }
        }
        return posicaoAtual;
    }

}

