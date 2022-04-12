import java.util.*;
import java.util.stream.Stream;

public class App {
    public static void main(String[] args) throws Exception {
        String [] id_list = {"muzi", "frodo", "apeach", "neo"};
        String [] report = {"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"};
        int k = 2;

        Stream.of(new Solution().solution(id_list, report, k)).forEach(x->System.out.println(x.length));
    }
}

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];

        Map<String, HashSet<String>> benListTemp = new HashMap<>();      // 밴 유저별 신고 유저 리스트
        Map<String, Integer> idListIdx = new HashMap<>();               // for문 탐색을 위한 idx map
     
        for(int i = 0; i<id_list.length; i++){
            benListTemp.put(id_list[i], new HashSet<>());

            idListIdx.put(id_list[i], i);
        }

        // Stream.of(benListTemp).forEach(System.out::println);
        // Stream.of(idListIdx).forEach(System.out::println);

        Stream.of(report).forEach(x -> {
            String user = x.split(" ")[0];
            String target = x.split(" ")[1];
            
            benListTemp.get(target).add(user);
        });

        // Stream.of(benListTemp).forEach(System.out::println);

        benListTemp.keySet().forEach(x->{
            if(benListTemp.get(x).size() >= k){
                benListTemp.get(x).stream().forEach(y->answer[idListIdx.get(y)]++);
            }
        });

        return answer;
    }
}