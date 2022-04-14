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
    int totalPee = 0;

    CarState(String time, String state, int pee){
        this.lastRecordTime = time;
        this.lastRecordState = state;
        this.totalPee += pee;
    }
    // void setLastRecordTime(String time){this.lastRecordTime = time;}
    // void setLastRecordState(String state){this.lastRecordState = state;}
    void setTotalPee(int pee){this.totalPee += pee;}

    String getLastRecordTime(){return this.lastRecordTime;}
    String getLastRecordState(){return this.lastRecordState;}
    int getTotalPee(){return this.totalPee;}

    @Override
    public String toString() {
        return String.valueOf(totalPee) + " " + this.lastRecordState;
    }
}

class Solution {
    static int defaultPee;
    static int defaultTime;
    static int baseTime;
    static int basePee;
    
    public int[] solution(int[] fees, String[] records) {
        this.defaultTime = fees[0];
        this.defaultPee = fees[1];
        this.baseTime = fees[2];
        this.basePee = fees[3];


        Map<String, CarState> carsHist = new HashMap();
        

        Stream.of(records).forEach(x->{
            String[] splitRecord = x.split(" ");

            String time = splitRecord[0];
            String carNumber = splitRecord[1];
            String state = splitRecord[2];


            int pee = 0;

            
            // 이미 기록이 있다면
            if(carsHist.containsKey(carNumber)){ 

                if(carsHist.get(carNumber).getLastRecordState().equals("IN")){

                    String[] nowTime =  time.split(":");
                    String[] lastTime =  carsHist.get(carNumber).getLastRecordTime().split(":");


                    int hour = Integer.parseInt(nowTime[0])-Integer.parseInt(lastTime[0]);
                    int min = Integer.parseInt(nowTime[1])-Integer.parseInt(lastTime[1]);

                    System.out.println("[[" + carNumber + "]]");
                    pee = countPee(hour, min);
                }else{
                    pee = carsHist.get(carNumber).getTotalPee();
                }
            }

            carsHist.put(carNumber, new CarState(time,state, pee));

        });


        Set<String> carsHistKeys = carsHist.keySet();

        for(String carsHistKey : carsHistKeys){
            if(carsHist.get(carsHistKey).getLastRecordState().equals("IN")){
                
                String[] lastTime =  carsHist.get(carsHistKey).getLastRecordTime().split(":");

                int hour = 23-Integer.parseInt(lastTime[0]);
                int min = 59-Integer.parseInt(lastTime[1]);

                System.out.println("[[" + carsHistKey + "]]");
                carsHist.get(carsHistKey).setTotalPee(countPee(hour, min));
            }
        }

        System.out.println(carsHist.toString());
       

        int[] answer = {};
        return answer;
    }

    int countPee(int hour, int min){
        int pee = defaultPee + (( hour * 60 + min - defaultTime ) / baseTime) * basePee;


        System.out.println(pee);
        return pee < 5000 ? 5000 : pee;
    }
}