package ListaDois;

import java.util.Scanner;

public class ExDois {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num1, num2;

        System.out.println("Jogador 1 informe o número escolhido:");
            num1=scanner.nextInt();
        System.out.println("Jogador 2 informe o número que você acha que o jogador 1 escolheu:");
            num2= scanner.nextInt();

        if (num1!=num2){
            if(num1>num2){
                System.out.println("O número a ser encontrado é maior do que o que você digitou.");
            }
            else if(num1<num2){
                System.out.println("O número a ser encontrado é menor do que o que você digitou.");
            }
        } else {
            System.out.println("Parabéns, você acertou!");
        }

    }
}
