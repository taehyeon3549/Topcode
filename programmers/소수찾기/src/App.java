import java.util.*;

public class App {
    public static void main(String[] args) throws Exception {
        String numbers = "17";

        System.out.println(new Solution().solution(numbers));
    }
}

class Solution {
    HashSet<Integer> numbersSet = new HashSet<>();

    public int solution(String numbers) {
        int answer = 0;

        recursive("", numbers);


        for(Integer v : numbersSet){
            if(isPrime(v)){
                answer += 1;
            }
        }

        return answer;
        
        
        // List<String> numList = new ArrayList<>();
        
        // for(int i = 1; i<=numbers.length(); i++){
        //     numList.add(numbers.substring(i-1, i));
        // }
        
        // System.out.println(numList.toString());

        // boolean [] visited = new boolean[numList.size()];

        // List<String> tt = new ArrayList<>();

        // for(int i = 1; i<=numList.size(); i++){
        //     serach(numList, visited, 0, i, tt);
        // }

        // System.out.println("tt 결과 >> " + tt.toString());

        // return tt.size();
    }

    public void recursive(String comb, String others) { 
        // 1. 현재 조합을 set에 추가한다. 
        if (!comb.equals("")) {
            numbersSet.add(Integer.valueOf(comb)); 
        }
        
        // 2. 남은 숫자 중 한 개를 더해 새로운 조합을 만든다. 
        for (int i = 0; i < others.length(); i++) {
            recursive(comb + others.charAt(i), others.substring(0, i) + others.substring(i + 1)); 
        }
    }

    public boolean isPrime(int num) { 
        // 1. 0과 1은 소수가 아니다 
        if (num == 0 || num == 1) 
            return false; 
        
        // 2. 에라토스테네스의 체의 limit 숫자를 계산한다. 
        int lim = (int)Math.sqrt(num); 
        
        // 3. 에라토스테네스의 체에 따라 lim까지 배수 여부를 확인한다. 
        for (int i = 2; i <= lim; i++) 
            if (num % i == 0) return false; 
        
        return true; 
    }



    void serach(List<String> list , boolean[] visited ,int startIdx, int howMany, List<String> result){
        if(howMany == 0){
            check(list, visited, result);
        }

        for(int i = startIdx; i<list.size(); i++){
            visited[i] = true;
            serach(list, visited, i + 1, howMany - 1, result);
            visited[i] = false;
        }
    }

    void check(List<String> list, boolean[] visited, List<String> result){
        StringBuffer buffer = new StringBuffer();

        for(int i = 0; i<list.size(); i++){
            if(visited[i] && !numCheck(Integer.parseInt(list.get(i)))){
                // System.out.print(list.get(i).toString() + " ");
                buffer.append(list.get(i));
            }
        }

        result.add(buffer.toString());
    }

    boolean numCheck(int num){
        for (int i = 2; i < num; i++) {
            // 1과 num 자신 외에 나누어지는 수가 있는지 검사할 조건문
            if (num % i == 0) {
                // 나누어지는 수가 있을 경우 isPrime의 값을 true로 바꾼다.
                return true;
            }
        }
        return false;
    }
}