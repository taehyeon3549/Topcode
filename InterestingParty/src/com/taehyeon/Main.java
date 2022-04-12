package com.taehyeon;

import java.util.HashMap;

public class Main {

    public static void main(String[] args) {
        String[] first = {"fishing", "gardening", "swimming", "fishing"};
        String[] second = {"hunting", "fishing", "fishing", "biting"};


        System.out.println(bestInitation(first, second));
    }

    public static int bestInitation(String [] first, String[] second){
        HashMap<String,Integer> t = new HashMap<>();

        for(int i = 0; i<first.length; i++){
            t.put(first[i], 0);
            t.put(second[i], 0);
        }

        for(int i = 0; i<first.length; i++){
            t.put(first[i], t.get(first[i])+1);
            t.put(second[i], t.get(second[i])+1);
        }

        int maxValue = 0;

        for(String key : t.keySet()){
            maxValue = Math.max(maxValue, t.get(key));
        }

        return maxValue;
    }
}
