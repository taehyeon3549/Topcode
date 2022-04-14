public class App {
    public static void main(String[] args) throws Exception {
        int n = 110011;
        int k = 10;

        System.out.println(String.valueOf(new Solution().solution(n, k)));
    }
}

class Solution {

    public int solution(int n, int k) {
        int answer = 0;
        int i,j;

        String s = makeJinsu(n,k);

        System.out.println("진수 전환 >> " + s);

        for(i = 0; i < s.length(); i = j){
            for(j = i + 1; j < s.length(); j++){
                
                if(s.charAt(j) == '0'){
                    break;
                }

            }

            if(isprime(Long.parseLong(s.substring(i,j)))){
                answer += 1;
            }
        }
      
        return answer;
    }

    public String makeJinsu(int n, int k) {
        String res = "";

        while(n > 0) {
            res = n % k + res;
            n /= k;
        }

        return res;
    }

    public boolean isprime(long n){        

        System.out.println("확인 값 >> " + n);

        // 1자리 미만이면 탈락
        if(n <= 1) return false;
        
        for(int i = 2; i <= Math.sqrt(n); i++){

            // 소수가 아니면 탈락
            if(n % i == 0)  return false;
        }

        return true;
    }
}
