package ListaDois;

import java.util.Scanner;

public class ExercicioSeis {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int[] vet= {1,2,3,4,5,6,7,8,9,10};
        int num = scanner.nextInt();
        boolean achou= false;

        for (int i=0; i<10; i++){
            if (vet[i]==num){
                achou= true;
                i=10;
            }
        }
        if(achou){
            System.out.println("Existe");
        } else {
            System.out.println("O número informado não existe.");
        }

    }
}
