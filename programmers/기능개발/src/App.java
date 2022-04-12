import java.util.*;

public class App {
    public static void main(String[] args) throws Exception {

        int [] progresses = {95, 90, 99, 99, 80, 99};
        int [] speeds = {1, 1, 1, 1, 1, 1};

        int [] result = new Solution().solution(progresses, speeds);

        for(int v : result){
            System.out.print(v + "  ");
        }
        

    }
}

/**
 * 접근 방식 
 * 
 * 93   30  55
 * 7    70  45
 * 
 * 1    30  5
 * 
 * 7    3   9
 * 
 * 2 1
 * 
 * 
 */

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        // /**
        //  * 람다를 통한 문제 풀이 방법
        //  */
        // int[] dayOfend = new int[100];
        // int day = -1;

        // for(int i=0; i<progresses.length; i++) {
        //     /**
        //      * 나랑 다른 부분
        //      * 
        //      * 날짜를 base로 두고 날짜를 증가 시키면서 프로그램의 100 달성 유무를 체크하고,
        //      * int 배열을 달력으로 삼아 해당 날짜에 프로젝트 완료 개수를 할당한뒤
        //      * Stream으로 0을 날려서 리턴 (와아아아웅)
        //      *
        //      */
        //     while(progresses[i] + (day*speeds[i]) < 100) {
        //         day++;
        //     }
        //     dayOfend[day]++;
        // }

        // return Arrays.stream(dayOfend).filter(i -> i!=0).toArray();


        /**
         * 해당 선언이 낭비라고 생각해서
         * 
         *  int[] answer = new int[r.size()];
         * 
         * 로 변경하면 런타임 에러 발생
         *  
         */
        int[] answer = new int[100];

        Queue<Integer> r = new LinkedList<>();

        /**
         * 소요 시간을 계산해서 q로 쌓음
         * 
         * 필히 int div int 할때 올림처리 하기 테스트 11번에서 걸림
         */
        for(int i = 0; i < progresses.length; i++){
            r.add(
                (int) Math.ceil((double)(100 - progresses[i]) / speeds[i])
            );
        }        

        int temp = 0;
        int release = 1;
        int idx = 0;

        /**
         * 소요 시간의 앞뒤를 비교 해서 배포 개수를 설정
         * 
         * **문제 : 0번째 인덱스는 무조건 0이 발생
         */
        while(r.peek() != null){
            int t = r.poll();
            
            if(temp >= t){               
                release += 1;
            }else{      
                idx += 1;          
                release = 1;
                temp = t;
            }
         
            answer[idx] = release;
        }

        /**
         * Stream을 통해 0 을 걸러서 리턴
         */
       return Arrays.stream(answer).filter((v)-> v != 0).toArray();
    }
}