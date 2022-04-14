import java.util.*;
import java.util.stream.*;

public class App {
    public static void main(String[] args) throws Exception {
        // 0: 기본 시간, 1: 기본 요금, 2: 단위 시간, 3: 단위 요금
        int [] fees = {180, 5000, 10, 600};

        // 출차기록
        String [] records = {"05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN", "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"};

        Stream.of(new Solution().solution(fees, records)).forEach(x->{
            System.out.println(x);
        });
    }
}

class CarState{
    String lastRecordTime = "";
    String lastRecordState = "";
    String totalPee = "";

    CarState(String time, String state, String pee){
        this.lastRecordTime = time;
        this.lastRecordState = state;
        this.totalPee = pee;
    }
    // void setLastRecordTime(String time){this.lastRecordTime = time;}
    // void setLastRecordState(String state){this.lastRecordState = state;}
    // void setTotalPee(String pee){this.totalPee = pee;}

    String getLastRecordTime(){return this.lastRecordTime;}
    String getLastRecordState(){return this.lastRecordState;}
    String getTotalPee(){return this.totalPee;}
}

class Solution {
    public int[] solution(int[] fees, String[] records) {
        int defaultTime = fees[0];
        int defaultPee = fees[1];

        int baseTime = fees[2];
        int basetPee = fees[3];


        Map<String, CarState> carsHist = new HashMap();
        

        Stream.of(records).forEach(x->{
            String[] splitRecord = x.split(" ");

            String time = splitRecord[0];
            String carNumber = splitRecord[1];
            String state = splitRecord[2];


            int pee = 0;

            // 이미 기록이 있다면
            if(carsHist.containsKey(carNumber) 
                && carsHist.get(carNumber).getLastRecordState().equals("IN")){

                    int nowTime = Integer.parseInt(time.replace(":", ""));
                    int lastTime = Integer.parseInt( carsHist.get(carNumber).getLastRecordTime().replace(":", "") );


                    
            }

            if(carsHist)
            carsHist.put(carNumber, new CarState(time,state, pee));

            // 엥 너무 SI 스럽나.....
        });


        int[] answer = {};
        return answer;
    }
}