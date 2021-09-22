package com.company;
import java.io.*;
public class javatry {
    public static void main(String[] args) {
        byte[] array= new byte[400];
        try{
            InputStream in= new FileInputStream("input.txt");
            OutputStream out= new FileOutputStream("output1.txt");
            in.read(array);
            String stringc= new String(array);
            System.out.println(stringc);
            byte[] data= stringc.getBytes();
            out.write(data);
            out.close();
            in.close();

        }
        catch (Exception e){
            System.out.println(e);
        }
    }

}
