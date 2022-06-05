package Class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main_1181_단어정렬 {

    static int N;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        LinkedList<String> words = new LinkedList<>();
        // 1. 빠른 검색을 위해 map을 사용해봄
        Map<String, Boolean> removeDup = new HashMap<>();
        // 2. 정렬하면 같은 문자열은 나란히 나온다 이를 확인하자

        N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            String word = br.readLine();
            if (!removeDup.containsKey(word)){
                words.add(word);
                removeDup.put(word, true);
            }
        }

        List<String> collect = words.stream().sorted((o1, o2) -> {
            if (o1 == o2){
                return 0;
            }
            if (o1.length() == o2.length()) {
                return o1.compareTo(o2);
            }
            return o1.length() - o2.length();
        }).collect(Collectors.toList());

        for (String s: collect){
            System.out.println(s);
        }

    }
}
