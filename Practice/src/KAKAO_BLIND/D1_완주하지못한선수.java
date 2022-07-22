package KAKAO_BLIND;
import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class D1_완주하지못한선수 {

    public static void main(String[] args) {
        String solution = solution(new String[]{"leo", "kiki", "eden"}, new String[]{"eden", "kiki"});
        System.out.println(solution);
    }

    private static String solution(String[] participant, String[] completion) {
        String answer = "";
        Map<String, Integer> map = new HashMap<>();
        for(String p : participant) map.put(p, map.getOrDefault(p, 0) + 1);
        for(String c : completion) map.put(c, map.get(c)-1);
        for(String a : map.keySet()) {
            if(map.get(a) != 0) {
                answer = a;
                break;
            }
        }
        LinkedList<Integer> a  = new LinkedList<>();
        int[] b = new int[10];
        Collections.sort(a, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return 0;
            }
        });
        return answer;
    }
}
