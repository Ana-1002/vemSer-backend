package ListaDois;

import java.util.Scanner;

public class ExOito {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int x = 5;
        double[][] matriz = new double[5][4];
        double maiorN = 0, media = 0, aux=0;
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < 3; j++) {
                switch(j) {
                    case 0: {
                        System.out.println("Infome o numero da mátricula");
                        matriz[i][j] = scanner.nextInt();
                        scanner.nextLine();
                        break;
                    }
                    case 1: {
                        System.out.println("Infome o numero da média provas");
                        matriz[i][j] = scanner.nextInt();
                        scanner.nextLine();
                        matriz[i][3] = (matriz[i][1]) * 0.6;
                        break;
                    }
                    case 2: {
                        System.out.println("Infome o numero da média trabalhos");
                        matriz[i][j] = scanner.nextInt();
                        scanner.nextLine();
                        matriz[i][3] += (matriz[i][2]) * 0.4;
                        if (i == 0) {
                            aux = matriz[i][3];
                            maiorN = matriz[i][0];
                        } else {
                            if (matriz[i][3] > aux) {
                                aux = matriz[i][3];
                                maiorN = matriz[i][0];
                            }
                        }
                        media += matriz[i][3];
                        break;
                    }
                    default:{
                        break;
                    }
                }
            }
        }
        System.out.printf("A matrícula de nota mais alta foi %.0f e a média das notas finais foi %.2f",maiorN, media/x);
    }
}
