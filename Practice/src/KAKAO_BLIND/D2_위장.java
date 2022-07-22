package KAKAO_BLIND;
import java.io.*;
import java.util.*;

public class D2_위장 {

    public static void main(String[] args) {
        solution(new String[][]{{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}});
    }

    private static int solution(String[][] clothes) {
        int answer = 1;
        Map<String, Integer> map = new HashMap<>();
        for(String[] c : clothes) map.put(c[1], map.getOrDefault(c[1], 0) + 1);
        for(Integer i : map.values()) answer *= (i+1);
        return answer-1;
    }
}
