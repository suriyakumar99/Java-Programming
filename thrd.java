package com.company;

class multithreads extends Thread{
    public void run(){
        try{
            System.out.println(Thread.currentThread().getId());
        }
        catch (Exception e){
            System.out.println(e);
        }
    }
}

class mythread{
    public static void main(String[] args){
        for(int i=0; i<5; i++){
            multithreads obj= new multithreads();
            obj.start();
        }
    }
}
