import java.util.Arrays;
import java.util.HashMap;

public class App {
    public static void main(String[] args) throws Exception {
        String[] participant = {"leo", "kiki", "eden"};
        String[] completion = {"eden", "kiki"};


        System.out.println(new Solution().solution(participant, completion));
    }
}


class Solution {
    public String solution(String[] participant, String[] completion) {

        /**
         * 테스트 1 〉	통과 (40.55ms, 81.4MB)
         * 테스트 2 〉	통과 (88.18ms, 90.4MB)
         * 테스트 3 〉	통과 (98.53ms, 95.7MB)
         * 테스트 4 〉	통과 (74.36ms, 110MB)
         * 테스트 5 〉	통과 (76.80ms, 95.4MB)
         */
        HashMap<String, Integer> map = new HashMap<String,Integer>();
        String answer = "";

        for(String p : participant){
            map.put(p, map.getOrDefault(p, 0)+1);
        }

        for(String c : completion){
            map.put(c, map.get(c)-1);
        }

        for(String k :map.keySet()){
            if(map.get(k)==1){
                answer = k;
                break;
            }
        }

        return answer;

        /**
         * 3. 정렬로 푼 예시가 있어서 도전
         * 테스트 1 〉	통과 (121.63ms, 82.5MB)
         * 테스트 2 〉	통과 (212.28ms, 88.2MB)
         * 테스트 3 〉	통과 (299.22ms, 94.7MB)
         * 테스트 4 〉	통과 (363.43ms, 96.4MB)
         * 테스트 5 〉	통과 (291.05ms, 95.1MB)
         */
        // Arrays.sort(participant);
        // Arrays.sort(completion);

        // int i = 0;

        // for(; i<completion.length; i++){           
        //         if(!participant[i].equals(completion[i])){
        //             return participant[i];
        //         }
           
        // }

        // return participant[i];
        
         /**
         * 2. 억지로 String 배열로 풀었는데 시간 초과
         */
        // for(int i =0; i<participant.length; i++){
        //     int flag = 0;
        //     int k = 0;

        //     for(; k<completion.length; k++){
        //         if(participant[i].equals(completion[k])){
        //             flag+=1;
        //             completion[k] = "";
        //             break;
        //         }

        //     }

        //     k=0;

        //     if(flag==0){
        //         return participant[i];
        //     }

        //     flag = 0;
        // }
        // return "";

        /**
         * 1. List로 풀었는데 시간 초과
         */

        // ArrayList<String> p = new ArrayList<>(Arrays.asList(participant));
        // ArrayList<String> c = new ArrayList<>(Arrays.asList(completion));

        // for(int i =0; i<c.size(); i++){
        //     p.remove(c.get(i));
        // }

        // String answer = p.get(0);
        // return answer;
    }
}
