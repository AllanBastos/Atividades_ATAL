package Gulosos;

public class MiminizandoParadas {
    public static void main(String[] args) {

        int distancia, kmPorTanque, qtdParadas;
        distancia = 950;
        kmPorTanque = 400;
        qtdParadas = 4;
        Integer[] paradas = {200, 375, 550, 750, distancia};

        System.out.println(miminizandoParadas(kmPorTanque, qtdParadas, paradas));

        distancia = 10;
        kmPorTanque = 3;
        qtdParadas = 4;
        paradas = new Integer[]{1, 2, 5, 9, distancia};

        System.out.println(miminizandoParadas(kmPorTanque, qtdParadas, paradas));

    }

    public static int miminizandoParadas(int kmPorTanque, int qtdParadas, Integer[] paradas){
        int tanque = kmPorTanque;

        int minParadas = 0;
        int posicaoAtual = 0;

        for (int i=0; i < qtdParadas; i++){
            tanque = Math.abs(tanque - (paradas[i] - posicaoAtual));
            int distanciaPostos = paradas[i+1] - paradas[i];
            if(distanciaPostos > tanque){
                tanque = kmPorTanque;
                if(distanciaPostos > tanque){
                    return -1;
                }
                minParadas++;
            }
            posicaoAtual = paradas[i];
        }

        return minParadas;
    }


}
