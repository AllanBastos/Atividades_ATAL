package Gulosos;

import java.util.*;

public class ColetandoAssinaturas {
    public static void main(String[] args) {
        Integer[][] atividades = {{1,3}, {2,5}, {3,6}};

        List<Integer[]> hvisitas = maxAssinaturas(atividades);
        ordenar(atividades);
        System.out.println(hvisitas.size());
        hvisitas.forEach(e -> System.out.printf("%d ", e[1]));

        System.out.println("\n");

        atividades = new Integer[][]{{4, 7}, {1, 3}, {2, 5}, {5, 6}};
        ordenar(atividades);

        hvisitas = maxAssinaturas(atividades);
        System.out.println(hvisitas.size());
        hvisitas.forEach(e -> System.out.printf("%d ", e[1]));

    }

    private static void ordenar(Integer[][] array) {
        Arrays.sort(array, Comparator.comparingInt(a-> a[1]));
    }

    public static List<Integer[]> maxAssinaturas(Integer[][] horarios){
        int numeroHorarios = horarios.length;
        List<Integer[]> horarioVisitas = new ArrayList<>();
        horarioVisitas.add(horarios[0]);
        int k = 0;
        for (int i = 1; i < numeroHorarios-1; i++){
            if(horarios[i][0] >= horarios[k][1]){
                horarioVisitas.add(horarios[i]);
                k = i;
            }
        }
        return horarioVisitas;
    }

}
