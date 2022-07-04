import java.io.*;
import java.util.Collections;
import java.util.LinkedList;

public class Main_2751_수정렬하기2 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
//        LinkedList<Integer> list = new LinkedList<>();
//        for (int i = 0; i < N; i++) {
//            int k = Integer.parseInt(br.readLine());
//            list.add(k);
//        }
//
//        Collections.sort(list); // O(nlogn)
//
//        for (Integer integer : list) {
//            bw.write(integer+"\n");
//        }
//        bw.flush();
        // -1000000 ~ 1000000
        int[] arr = new int[2000001];

        for (int i = 0; i < N; i++) {
            int k = Integer.parseInt(br.readLine());
            arr[k+1000000] = 1;
        }

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0)
                bw.write(i-1000000+"\n");
        }
        bw.flush();
    }
}
