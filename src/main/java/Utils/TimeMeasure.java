package main.java.Utils;

public class TimeMeasure {

    private long t0;
    public TimeMeasure(){
        t0=System.currentTimeMillis();
    }


    public long get(){
        long t1 =System.currentTimeMillis();
//        System.out.println("T1:"+t1);
//        System.out.println("T0:"+t0);
        long dt = t1 - t0;
//        System.out.println("DT:"+dt);

        return dt;

    }
    public void set(){

        this.t0=System.currentTimeMillis();
        //System.out.println("T0:"+t0);

    }


    }
