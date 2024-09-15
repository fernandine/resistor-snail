package com.challenge.snail;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.Scanner;

@SpringBootApplication
public class SnailApplication {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o tamanho da matriz (N): ");
        int n = scanner.nextInt();
        scanner.nextLine();

        int[][] matrix = new int[n][n];
        System.out.println("Digite cada linha da matriz separada por espaço:");

        for (int i = 0; i < n; i++) {
            System.out.print("Linha " + (i + 1) + ": ");
            String[] values = scanner.nextLine().split(" ");
            if (values.length != n) {
                System.out.println("Erro: você deve digitar exatamente " + n + " valores por linha.");
                return;
            }
            for (int j = 0; j < n; j++) {
                matrix[i][j] = Integer.parseInt(values[j]);
            }
        }

        Matrix spiralMatrix = new Matrix(matrix);
        List<Integer> result = spiralMatrix.spiralOrder();
        System.out.println("Resultado final: " + result);
    }
}