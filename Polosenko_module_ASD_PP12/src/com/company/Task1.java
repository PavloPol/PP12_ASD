package com.company;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Task1 {

    public Task1() {
        Scanner scan = new Scanner(System.in);
        boolean error = true;
        int n = 0;
        do {
            try {
                System.out.println("Введіть розмір матриці:");
                n = scan.nextInt();
                error = false;
                if(n<1)
                {
                    System.out.println("Введіть значення більше за нуль");
                    error = true;
                }
            } catch (InputMismatchException e) {
                System.out.println("Введіть ціле число");
                error = true;
                scan.next();
            }
        }
        while (error);
        int matrix[][] = new int[n][n];
        int m = 0;
        do {
            try {
                System.out.println("Введіть: \n1) для заповнення рандомними числами від -100 до 100\n2) для заповнення вручну");
                m = scan.nextInt();
                switch (m) {
                    case 1:
                        for (int i = 0; i < n; i++)
                            for (int j = 0; j < n; j++)
                                matrix[i][j] = (int) (Math.random() * 200 - 100);
                            error = false;
                        break;
                    case 2:
                                for (int i = 0; i < n; i++) {
                                    for (int j = 0; j < n; j++) {
                                        do {
                                            try {
                                                System.out.println("Введіть ціле значення в масив");
                                                m = scan.nextInt();
                                                matrix[i][j] = m;
                                                error = false;
                                            }
                                            catch(InputMismatchException e)
                                            {
                                                System.out.println("Введіть ціле число");
                                                error = true;
                                                scan.next();
                                            }
                                        }while(error);
                                    }
                                }
                                error = false;
                        break;
                    default:break;
                }
            }
            catch(InputMismatchException e)
                {
                    System.out.println("Введіть ціле число");
                    error = true;
                    scan.next();
                }
        }while(error);
        int sum1 = 0;
        int sum2 = 0;
        for (int i = 0; i < n; i++)
            sum1 += matrix[i][i];
        for (int i = 0; i < n; i++) {
            System.out.print("\n{");
            for (int j = 0; j < n; j++) {
                System.out.print("\t"+matrix[i][j]);
                if (i + j == n - 1)
                    sum2 += matrix[i][j];
            }
            System.out.print("}");
        }
        System.out.println("\n\n"+Math.abs(sum1-sum2)+"\n");
    }
}
