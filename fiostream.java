package com.company;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Scanner;

class data implements Serializable {

    int itno;
    float price;

    public data(int itno, float price) {
        this.itno = itno;
        this.price = price;
    }
}

class fiostream {
    public static void main(String[] args) throws Exception{

        Scanner in= new Scanner(System.in);
        System.out.println("Enter no. of data-sets: ");
        int n= in.nextInt();
        int itno;
        float price;
        float total=0;
        int length;

        FileOutputStream fileOut = new FileOutputStream("file.txt");
        ObjectOutputStream objOut = new ObjectOutputStream(fileOut);
        FileInputStream fileIn = new FileInputStream("file.txt");
        ObjectInputStream objIn = new ObjectInputStream(fileIn);
        try {
            for (int i=0; i<n; i++){
                System.out.println("Data "+(i+1)+"\nItem no: ");
                itno=in.nextInt();
                System.out.println("Price: ");
                price=in.nextFloat();
                length = (int) (Math.log10(itno) + 1);
                if(length !=3){
                    throw new Exception();
                }
                data d = new data(itno, price);
                objOut.writeObject(d);

                data newdata = (data) objIn.readObject();
                System.out.println("Item no: " + newdata.itno);
                System.out.println("Price: " + newdata.price);
                total=+newdata.price;


            }
            System.out.println("Total Price: "+total);
            objOut.close();
            objIn.close();

            // Reads the objects





        }

        catch (Exception e) {
            System.out.println("Please enter valid input");
        }
    }
}

