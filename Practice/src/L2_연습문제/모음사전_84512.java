package L2_연습문제;

import org.junit.jupiter.api.Assertions;

import java.util.*;

public class 모음사전_84512 {

    public static void main(String[] args) {
        Assertions.assertEquals(6, solution("AAAAE"));
        Assertions.assertEquals(10, solution("AAAE"));
        Assertions.assertEquals(1563, solution("I"));
        Assertions.assertEquals(1189, solution("EIO"));
    }

    static List<String> list = new LinkedList<>();
    static final String WORD = "AEIOU";
    private static int solution(String word) {
        int answer = 0;
        dfs("", 0);
        return list.indexOf(word);
    }

    private static void dfs(String str, int len) {
        if (len > 5) return;
        list.add(str);
        for(int i = 0; i < WORD.length(); i++){
            dfs(str+WORD.charAt(i), len+1);
        }
    }

    /**
     'A', 'E', 'I', 'O', 'U' 만 가능
     사전순
     길이 5이하
     사전에서 몇번째 단어인지 return
     **/
/*    static char[] cArr = {'A', 'E', 'I', 'O', 'U'};
    static int count = 1;
    static Set<String> set = new HashSet<>();
    static boolean find = false;
    private static int solution(String word) {
        int answer = 0;

        // Map에 순서대로 모든 쌍 넣기
        // 중복 순열
        checkAll(0, new char[5]);

        // word 검색
        List<String> list = new LinkedList<>(set);
        Collections.sort(list);
        for(int i = 0; i < list.size(); i++){
            if(list.get(i).equals(word)) return i+1;
        }
        return answer;
    }

    private static void checkAll(int n, char[] arr){
        if(n >= cArr.length || find){
            return ;
        }

        for(int i = 0; i < cArr.length; i++){
            arr[n] = cArr[i];
            StringBuilder sb = new StringBuilder();
            for(int j = 0; j <= n; j++){
                sb.append(arr[j]);
            }
            set.add(sb.toString());
            // System.out.println(sb.toString());
            checkAll(n+1, arr);
        }
        return ;
    }*/
}
