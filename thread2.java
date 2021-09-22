package com.company;

class KVP_Print {
    public void printCount() {
        try {
            for(int i = 5; i > 0; i--) {
                System.out.println("Counter --- " + i );
            }
        }
        catch (Exception e) { System.out.println("Thread interrupted."); }
    }
}
    class KVP_Thread extends Thread {
    private Thread t;
    private String threadName;
    KVP_Print PD;
    KVP_Thread( String name, KVP_Print pd) {
        threadName = name; PD = pd;
    }
    public void run() {
        synchronized(PD){
        PD.printCount();
        System.out.println("Thread " + threadName + " exiting.");}

    }
    public void start () {
        System.out.println("Starting " + threadName );
        if (t == null) {
            t = new Thread(this, threadName);
            t.start ();
        }
    }
}
public class thread2 {
    public static void main(String args[]) {
        KVP_Print PD = new KVP_Print();
        KVP_Thread T1 = new KVP_Thread( "Thread - 1 ", PD );
        KVP_Thread T2 = new KVP_Thread( "Thread - 2 ", PD );
        T1.start(); T2.start();
        try { T1.join(); T2.join(); } // wait for threads to end
        catch ( Exception e) { System.out.println("Interrupted"); }
    }
}

