import java.io.*;
import java.util.*;

public class Main_18870_좌표압축 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        // 제일 작은게 0이 된다.
        LinkedList<Integer> list = new LinkedList<>(); // 원본
        LinkedList<Integer> list2 = new LinkedList<>(); // 순서
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int k = Integer.parseInt(st.nextToken());
            list.add(k);
            list2.add(k);
        }

        Collections.sort(list2);
        Map<Integer, Integer> map = new HashMap<>();
        int j = 0;
        for (Integer integer : list2) {
            if (!map.containsKey(integer)) map.put(integer, j++);
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (Integer integer : list) {
            Integer i = map.get(integer);
            bw.write(i+" ");
        }

        bw.flush();

    }
}
