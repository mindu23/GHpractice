import java.io.*;
import java.util.*;

public class Main_1764_듣보잡 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int N = Integer.parseInt(s[0]); // 듣도
        int M = Integer.parseInt(s[1]); // 보도

        // 빠른 검색을 위한 map
        Map<String, Boolean> map = new HashMap<>();
        for (int i = 0; i < N; i++) {
            map.put(br.readLine(), false);
        }

        List<String> list = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            String see = br.readLine();
            if (map.containsKey(see)) list.add(see);
        }

        Collections.sort(list);

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(list.size()+"\n");
        for (String s1 : list) {
            bw.write(s1+"\n");
        }

        bw.flush();
    }
}
