package com.taehyeon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
/*
* 타로는 0부터 N-1 이라 이름을 붙인 W 개의 병에 키위 주스를 넣음
* i번째의 병의 용량은 capacites[i]
* i번째 병에 넣은 키위 주스의 양을 bottles[i] 리터
*  */
    public static void main(String[] args) {
//        Integer[] capacities = new Integer[bottleCnt];
//        Integer[] bottles = new Integer[bottleCnt];
//        Integer[] fromId = new Integer[bottleCnt];
//        Integer[] toId = new Integer[bottleCnt];

        List<Integer> capacities = Arrays.asList(700000, 800000, 900000, 1000000);
        List<Integer> bottles = Arrays.asList(478478, 478478, 478478, 478478);
        List<Integer> fromId = Arrays.asList(2,3,2,0,1);
        List<Integer> toId = Arrays.asList(0,1,1,3,2);

        System.out.println(thePouring(capacities,bottles,fromId, toId).toString());
    }

    public static List<Integer> thePouring(List<Integer> capacities, List<Integer>  bottles, List<Integer>  fromId, List<Integer>  toId){
        for(int i = 0; i<fromId.size(); i++){

            int fromBottleIndex = fromId.get(i);
            int toBottleIndex = toId.get(i);

            int sum = bottles.get(fromBottleIndex) + bottles.get(toBottleIndex);
            bottles.set(toBottleIndex, Math.min(sum, capacities.get(toBottleIndex)));
            bottles.set(fromBottleIndex, sum - bottles.get(toBottleIndex));
        }

        return bottles;
    }
}
