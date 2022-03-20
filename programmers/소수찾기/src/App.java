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

    /**
     * 남의 코드..... 현타 오네...
     */
    public void recursive(String comb, String others) { 
        
        if (!comb.equals("")) {
            numbersSet.add(Integer.valueOf(comb)); 
        }
        
        for (int i = 0; i < others.length(); i++) {
            recursive(comb + others.charAt(i), others.substring(0, i) + others.substring(i + 1)); 
        }
    }

    public boolean isPrime(int num) { 
    
        if (num == 0 || num == 1) 
            return false; 
        
        int lim = (int)Math.sqrt(num); 
        
        for (int i = 2; i <= lim; i++) 
            if (num % i == 0) return false; 
        
        return true; 
    }

    /* 남의 코드 끝 */

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
            if (num % i == 0) {
                return true;
            }
        }
        return false;
    }
}