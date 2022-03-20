
public class App {
    public static void main(String[] args) throws Exception {
        int brown = 24;
        int yellow = 24;

        System.out.println(new Solution().solution(brown, yellow));
    }
}

class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];        

        int sum = brown + yellow;

        int height = 3;

        while(true){
            if(sum % height == 0){
                int width = sum / height;

                if((height - 2) * (width - 2) == yellow){
                    // 가로는 세로보다 크거나 같음
                    answer[0] = height > width ? height : width;
                    answer[1] = height < width ? height : width;

                    break;
                }
            }

            height += 1;
        }

        return answer;
    }
}


