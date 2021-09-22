package com.company;
import com.sun.jdi.InvalidLineNumberException;

import java.util.Scanner;

class MyThread1 extends Thread{
    int count;
    public void fib(){
        int n1=0,n2=1,n3,i;
        System.out.print(n1+" "+n2);

        for(i=2;i<count;++i)
        {
            n3=n1+n2;
            System.out.print(" "+n3);
            n1=n2;
            n2=n3;
        }
    }

    MyThread1(int count){
       this.count=count;
    }
    public void run(){
        fib();
    }

}
class MyThread2 extends Thread{

    int number;
    public void prime(){
        try {
            for (int i = 2; i < number; i++) {
                while (number % i == 0) {
                    System.out.println(i + " ");
                    Thread.sleep(500);
                    number = number / i;
                }
            }
            if (number > 2) {
                System.out.println(number);
            }
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
    MyThread2(int number){
        this.number=number;
    }
    public void run(){
        prime();
    }
}

class Main{
    public static void main(String args[]){
        Scanner in= new Scanner(System.in);
        try{
        System.out.println("Enter n: ");
        int n=in.nextInt();
        if(n<=0){
            throw new Exception();
        }
        //System.out.println("Thread1: ");
        MyThread1 t1=new MyThread1(n);
        //System.out.println("Thread2: ");
        MyThread2 t2=new MyThread2(n);
        t1.start();
        t2.start();
        }
        catch(Exception e){
            System.out.println("Enter a positive number");
        }

    }
}