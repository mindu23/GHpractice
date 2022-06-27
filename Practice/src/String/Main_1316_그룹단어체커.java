package String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main_1316_그룹단어체커 {

    static int res = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            String q = br.readLine();
            check(q);
        }
        System.out.println(res);
    }

    private static void check(String q) {
        char[] chars = q.toCharArray();
        Map<Character, Boolean> map = new HashMap<>();
        boolean isOk = true;

        char before = chars[0];
        map.put(chars[0], true);
        for (int i = 1; i < chars.length; i++) {
            if (chars[i] == before) continue;
            if (map.containsKey(chars[i])){
                isOk = false;
                break;
            }else{
                map.put(chars[i], true);
                before = chars[i];
            }
        }
        if (isOk) res++;
    }
}
