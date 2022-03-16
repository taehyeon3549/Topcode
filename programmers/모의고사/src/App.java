import java.util.*;

public class App {
    public static void main(String[] args) throws Exception {
        int [] answers = {1,2,3,4,5};


        System.out.println(new Solution().solution(answers));
    }
}

class Solution {
    public int[] solution(int[] answers) {       
        int [] first = { 1, 2, 3, 4, 5};
        int [] second = {2, 1, 2, 3, 2, 4, 2, 5};
        int [] third = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

        Map<Integer, Integer> result = new HashMap(){
            {
                put(1, 0);
                put(2, 0);
                put(3, 0);
            }
        };
     
        for(int i = 0; i<answers.length; i++){
            // System.out.println("수식 확인 >> " + i % first.length);
            // System.out.println("조건 탐색 확인 " + answers[i]);
            // System.out.println("조건 탐색 확인 " + first[i % first.length]);

            if(answers[i] == first[i % first.length]){         
                result.put(1, result.get(1)+1);
            }

            if(answers[i] == second[i % second.length]){
                result.put(2, result.get(2)+1);
            }

            if(answers[i] == third[i % third.length]){
                result.put(3, result.get(3)+1);
            }
        }

        System.out.println("정답 개수 결과 >> " + result.toString());

        Set<Integer> keys = result.keySet();

        int maxValue = 0;

        List<Integer> v = new ArrayList<>();

        for(Integer key : keys){
            if(maxValue < result.get(key)){
                v.clear();
                v.add(key);

                maxValue = result.get(key);

            }else if(maxValue == result.get(key)){
                v.add(key);

                maxValue = result.get(key);
            }
        }

        Collections.sort(v);

        return v.stream().mapToInt(i->i).toArray();
    }
}