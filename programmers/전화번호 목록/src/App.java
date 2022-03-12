import java.util.*;


public class App {
    public static void main(String[] args) throws Exception {
        String[] phone_book = {"11111","222","9"};
        

        System.out.println(new Solution().solution(phone_book));
    }
}

class Solution {
    public boolean solution(String[] phone_book) {        
        boolean answer = true;
           
        Arrays.sort(phone_book);

        for(int k = 1; k<phone_book.length; k++){
          
            if(phone_book[k].startsWith(phone_book[k-1])){
                return false;
            }
          
        }
        
        return answer;      
    }
}