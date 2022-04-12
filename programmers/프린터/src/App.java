
import java.util.*;

public class App {
    public static void main(String[] args) throws Exception {
        int[] priorities = {2, 2, 2, 1, 3, 4};
        int location = 1;

        System.out.println(new Solution().solution(priorities, location));
    }
}

class Solution {
    public int solution(int[] priorities, int location) {
        PriorityQueue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());
        int answer = 0;
        
        for (int i = 0; i < priorities.length; i++) {
            q.add(priorities[i]);
        }
        
        while (!q.isEmpty()) {
            for (int i = 0; i < priorities.length; i++) {
                if (priorities[i] == q.peek()) {
                    if (i == location) {
                        answer += 1;
                        return answer;
                    }
                    q.poll();
                    answer += 1;
                }
            }
        }
        return -1;
    }
}