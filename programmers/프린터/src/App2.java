import java.util.*;

public class App2 {
    public static void main(String[] args) throws Exception {
        int[] priorities = {2, 2, 2, 1, 3, 4};
        int location = 1;

        System.out.println(new Solution().solution(priorities, location));
    }
}

class Vo implements Comparable<Vo>{
    private int idx = 0;
    private int priority = 0;

    Vo(){
    }

    public int getPriority(){
        return this.priority;
    }

    public int getIdx(){
        return this.idx;
    }

    public Vo setIdx(int idx){
        this.idx = idx;
        return this;
    }

    public Vo setPriority(int priority){
        this.priority = priority;
        return this;
    }

    public boolean equals(int idx, int priority){
        if(this.idx == idx && this.priority == priority){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public String toString(){
        return "[ idx : " + this.idx + " priority : " + this.priority + " ]";
    }

    /**
     * 왜 정렬이 제대로 안되누...?
     */
    @Override
    public int compareTo(Vo o) {
        // if(this.idx > o.getIdx() && this.priority > o.getPriority()){
        //     return 1;
        // }else if(this.idx < o.getIdx() && this.priority > o.getPriority()) {
        //     return -1;
        // }else if(this.idx < o.getIdx() && this.priority < o.getPriority()) {
        //     return -1;
        // }else if(this.idx > o.getIdx() && this.priority < o.getPriority()) {
        //     return 1;
        // }else{
        //     return 0;
        // }

        // System.out.println("비교 >> " + this.getPriority() + "\t" + o.getPriority());
        
        return this.getPriority() > o.getPriority() ? 1 : -1;

    }
}

class Solution {

    public int solution(int[] priorities, int location) {
        // 우선 순위 queeue
        // index , value
        // 내림 차순
        PriorityQueue<Vo> priorityQueueHighest = new PriorityQueue<>(Collections.reverseOrder());
        // PriorityQueue<Vo> priorityQueueHighest = new PriorityQueue<>();

       
        for(int i = 0; i<priorities.length; i++){
            priorityQueueHighest.add(new Vo().setIdx(i).setPriority(priorities[i]));
        }

        for(Vo v : priorityQueueHighest){
            System.out.println(v.toString());
        }

        int result = priorityQueueHighest.size()+1;

        while(priorityQueueHighest.peek() != null){
            Vo temp = priorityQueueHighest.poll();

            result-=1;

            if(temp.equals(location, priorities[location])){
                return result;
            }
        }

        return -1;

    //     /**
    //      * 문제 이해를 잘못 했네이....
    //      */
    //     /**
    //      * 최고 우선 순위를 알아내고,
    //      * 해당 우선 순위의 idx 값 알아냄
    //      */
    //     int maxValue = 0;
    //     int maxIdx = 0;

    //     for(int i = 0; i<priorities.length; i++){

    //         if(maxValue < priorities[i]){

    //             maxValue = priorities[i];
    //             maxIdx = i;                
    //         }
    //     }

    //     System.out.println("maxValue >> " + maxValue);

    //     System.out.println("maxIdx >> " + maxIdx);

    //     if(location > maxIdx){
    //         return location - maxIdx + 1;
    //     }else if(location < maxIdx){
    //         return priorities.length - maxIdx + location + 1;
    //     }else{
    //         return 1;
    //     }
    }
}