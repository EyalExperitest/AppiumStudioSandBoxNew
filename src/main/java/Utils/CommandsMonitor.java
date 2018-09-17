package main.java.Utils;

import java.util.*;

public class CommandsMonitor {
    private Map<String,ArrayList<Long>> monitorMap;

    public CommandsMonitor(){
        monitorMap =new HashMap<String, ArrayList<Long>>();


    }

    public void add(String key,Long time){
        Set<String> keySet = monitorMap.keySet();
        if(!keySet.contains(key)){
            ArrayList<Long> longArrayList =new ArrayList();
            monitorMap.put(key,longArrayList);
        }
        monitorMap.get(key).add(time);
        System.out.println("["+key+":"+time+"]");

    }

    public Set<String> keySet(){
        return monitorMap.keySet();
    }


    public long getAverage(String key){
        long average=0;

        if (monitorMap.containsKey(key)) {
            ArrayList<Long> longArrayList = monitorMap.get(key);
            long sum=0;
            long number=0;
            for (long time :longArrayList){
                number++;
                sum+=time;
            }
            average =sum/number;
        } else {
            average=-1;
        }


        return average;

    }
    public long getVariance(String key){
        long variance=0;
        long average=getAverage(key);
        long squareAverage = getSquareAverage(key);
        variance=squareAverage-(average*average);
        return  variance;
    }

    public  long getStandardDeviation(String key){
        long standardDeviation =0;
        long variance = getVariance(key);
        Double dVariance = new Double(variance);
        standardDeviation = (long) Math.sqrt(dVariance);
        return  standardDeviation;
    }

    public long getMax(String key){
        long max=0;
        if (monitorMap.containsKey(key)) {
            ArrayList<Long> longArrayList = monitorMap.get(key);
            for (long time :longArrayList){
                max=Math.max(max,time);
            }
        } else {
            max=-1;
        }
        return max;
    }






    private long getSquareAverage(String key) {
        long squareAverage;
        if (monitorMap.containsKey(key)) {
            ArrayList<Long> longArrayList = monitorMap.get(key);
            long squareSum=0;
            long number=0;
            for (long time :longArrayList){
                number++;
                squareSum+=(time*time);
            }
            squareAverage =squareSum/number;
        } else {
            squareAverage=-1;
        }
        return squareAverage;
    }

    public int getNumber(String key){
        if (monitorMap.containsKey(key)) {
            return  monitorMap.get(key).size();
        }
        else {
            return 0;
        }
    }

        public ArrayList<Long> getList(String key){
        ArrayList<Long> longArrayList;
        if (monitorMap.containsKey(key)) {
            longArrayList= monitorMap.get(key);
        }
        else {
            longArrayList=null;
        }
        return longArrayList;
    }

}
