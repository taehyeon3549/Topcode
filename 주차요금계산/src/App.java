import java.util.*;
import java.util.stream.*;

public class App {
    public static void main(String[] args) throws Exception {
        // 0: 기본 시간, 1: 기본 요금, 2: 단위 시간, 3: 단위 요금
        int [] fees = {120, 0, 60, 591};

        // 출차기록
        String [] records = {"16:00 3961 IN", "16:00 0202 IN", "18:00 3961 OUT", "18:00 0202 OUT", "23:58 3961 IN"};

        int[] r = new Solution().solution(fees, records);

        for(int i = 0; i<r.length; i++){
            System.out.println(r[i]);
        }        
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
        
        Map<String, List<String>> carHist2 = new HashMap<>();

        Stream.of(records).forEach(x->{
            String[] splitRecord = x.split(" ");

            String time = splitRecord[0];
            String carNumber = splitRecord[1];
            String state = splitRecord[2];

            if(!carHist2.containsKey(carNumber)){
                // System.out.println(carHist2.toString());

                carHist2.put(carNumber, new ArrayList<String>(Arrays.asList(time)));
            }else{
                // System.out.println(carHist2.toString());

                carHist2.get(carNumber).add(time);
            }
        });

        TreeMap<String,Integer> result = new TreeMap<>();
        
        Set<String> keys = carHist2.keySet();

        for(String key : keys){
            if(carHist2.get(key).size()%2 != 0){
                carHist2.get(key).add("23:59");
            }

            int totalMin = 0;

            for(int i =1; i<=carHist2.get(key).size(); i+=2){
                String[] nowTime =  carHist2.get(key).get(i).split(":"); 
                String[] lastTime =  carHist2.get(key).get(i-1).split(":"); 

                int hour = Integer.parseInt(nowTime[0])-Integer.parseInt(lastTime[0]);
                int min = Integer.parseInt(nowTime[1])-Integer.parseInt(lastTime[1]);

                totalMin += (hour * 60 + min);
            }

            // System.out.println("[[" + key + "]]");
            // System.out.println("총 사용 시간 >> " + totalMin);

            result.put(key, countPee(totalMin));
        }
               
        
        // System.out.println(result.toString());

        
        Object [] values = result.values().toArray();

        int [] r = new int[result.size()];

        for(int i =0; i<r.length; i++){
            r[i] = (int)values[i];
        }
        return r;
    }

    int countPee(int totalMin){        

        int pee = defaultPee + (int) Math.ceil((double) ( totalMin - defaultTime ) / baseTime) * basePee;

        // System.out.println("요금 계산 >> " + pee);        
       
        return pee < defaultPee ? defaultPee : pee;
    }
}