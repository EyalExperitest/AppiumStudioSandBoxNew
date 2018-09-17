package main.java.Utils;

public class TimeMeasure {

    long t0;
    public TimeMeasure(){
        t0=System.currentTimeMillis();
    }


    public long get(){
        long t1 =System.currentTimeMillis();

        return t1-t0;

    }
    public void set(){
        t0=System.currentTimeMillis();
    }


    }
