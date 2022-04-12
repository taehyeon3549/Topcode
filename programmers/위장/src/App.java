import java.util.*;
import static java.util.stream.Collectors.*;

public class App {
    public static void main(String[] args) throws Exception {
        String[][] clothes1 = {{"yellowhat", "headgear"}, {"bluesunglasses", "eyewear"}, {"green_turban", "headgear"}};

        String[][] clothes = {{"crowmask", "face"}, {"bluesunglasses", "face"}, {"smoky_makeup", "face"}, {"green_turban", "headgear"}, {"bluesunglasses", "eyewear"}, {"bluesunglasses2", "eyewear"}};

        System.out.println(new Solution().solution(clothes));
    }
}

/**
 * face : 3
 * headgear : 1
 * eyewear : 2
 * 
 * 6 + (3 + 6 + 2) + (3 * 1* 2) = 6 + 11 + 6 = 23
 * 
 * 4 * 2 * 3 -1 = 23
 */

class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;

        Map<String, Integer> match = new HashMap<>();
               

        for(int i = 0; i<clothes.length; i++){
            match.put(clothes[i][1], match.getOrDefault(clothes[i][1], 0)+1);
        }

        Iterator<String> iterator = match.keySet().iterator();
       
        while(iterator.hasNext()){
            answer *=  match.get(iterator.next()) + 1;
        }

        // return answer - 1 ;

        /** 
         * Stream을 활용한 문제 풀이
        */
        
        /**
         * 1. groupingBy 로 index 1 번째 값으로, map 하나 생성 value는 mapping을 통해서 counting()된 값을 바꿈
         * 참고 : https://beomseok95.tistory.com/218
         * 
         * 2. 만든 map의 값을 다시 stream
         * 
         * 3. reduce 연산을 통해서 값을 줄여가면서 공식 대입
         * 참고 : https://khj93.tistory.com/entry/JAVA-%EB%9E%8C%EB%8B%A4%EC%8B%9DRambda%EB%9E%80-%EB%AC%B4%EC%97%87%EC%9D%B4%EA%B3%A0-%EC%82%AC%EC%9A%A9%EB%B2%95
         * 
         * 
         * ?? : reducing(1L, ~~~) 에서 1L의 의미는 무엇인가?
         * 
         * 
         */

        return Arrays.stream(clothes)
                .collect(groupingBy(p -> p[1], mapping(p -> p[0], counting())))
                .values()
                .stream()
                .collect(reducing(1L, (x, y) -> x * (y + 1)))
                .intValue() - 1;
    }
}
