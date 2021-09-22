package com.company;
import java.lang.Math;
import java.util.Scanner;
public class exception1 {
    public static void main(String[] args) throws ArithmeticException {
        Scanner n = new Scanner(System.in);
        System.out.println("Enter number: ");
        double x = n.nextDouble();
        try {
            x = Math.sqrt(x);
            if (x >= 0)
                System.out.println("Sqr root: " + x);

            else
                throw new ArithmeticException();
        } catch (ArithmeticException e) {
            System.out.println("Square root of negative numbers can't be found");
        }
    }
}


