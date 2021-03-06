package com.company;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Task2 {

    public Task2(){
        Scanner scan = new Scanner(System.in);
        boolean error = true;
        int mas1 = 0, mas2 = 0;
        do {
            try {
                System.out.println("Введіть розмір першого масиву:");
                mas1 = scan.nextInt();
                error = false;
                if(mas1 < 1 || mas1 > 10)
                {
                    System.out.println("Введіть значення від 1 до 10");
                    error = true;
                }
            } catch (InputMismatchException e) {
                System.out.println("Введіть ціле число");
                error = true;
                scan.next();
            }
        }while (error);

        do {
            try {
                System.out.println("Введіть розмір другого масиву:");
                mas2 = scan.nextInt();
                error = false;
                if(mas2 < 1 || mas2 > 10)
                {
                    System.out.println("Введіть значення від 1 до 10");
                    error = true;
                }
            } catch (InputMismatchException e) {
                System.out.println("Введіть ціле число");
                error = true;
                scan.next();
            }
        }while (error);

        int n [] = new int [mas1];
        int m [] = new int [mas2];

        int k = 0;
        do {
            try {
                System.out.println("Введіть: \n1) для заповнення рандомними числами від 1 до 100\n2) для заповнення вручну");
                k = scan.nextInt();
                switch (k) {
                    case 1:
                        for (int i = 0; i < mas1; i++)
                            n[i] = (int) (Math.random() * 100 + 1);
                        for (int i = 0; i < mas2; i++)
                            m[i] = (int) (Math.random() * 100 + 1);
                        error = false;
                        break;
                    case 2:
                        for (int i = 0; i < mas1; i++) {
                                do {
                                    try {
                                        System.out.println("Введіть ціле значення в перший масив");
                                        k = scan.nextInt();
                                        n[i] = k;
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
                        for (int i = 0; i < mas2; i++) {
                            do {
                                try {
                                    System.out.println("Введіть ціле значення в другий масив");
                                    k = scan.nextInt();
                                    m[i] = k;
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

        if (n[mas1-1]>m[0]) {
            for (int i = m[0]; i <= n[mas1-1]; i++) {
                int counter1 = 0;
                int counter2 = 0;
                for (int t = 0; t < mas1; t++) {
                    if (i % n[t] == 0)
                        counter1++;
                }
                for(int t = 0; t < mas2; t++) {
                    if(m[t] % i == 0)
                        counter2++;
                }
                if(counter1 == mas1 && counter2 == mas2) {
                    System.out.print(i+" ");
                }
            }
        }
        else {
            for (int i = n[mas1-1]; i <= m[0]; i++) {
                int counter1 = 0;
                int counter2 = 0;
                for (int t = 0; t < mas1; t++) {
                    if (i % n[t] == 0)
                        counter1++;
                }
                for(int t = 0; t < mas2; t++) {
                    if(m[t] % i == 0)
                        counter2++;
                }
                if(counter1 == mas1 && counter2 == mas2) {
                    System.out.print(i+" ");
                }
            }
        }
        System.out.print("\n");
        }
    }
