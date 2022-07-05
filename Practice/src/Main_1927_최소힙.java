import java.io.*;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main_1927_최소힙 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o1, o2);
            }
        });
        for (int i = 0; i < N; i++) {
            int k = Integer.parseInt(br.readLine());
            if (k == 0){
                if (pq.isEmpty()) bw.write(0 + "\n");
                else bw.write(pq.poll()+"\n");
            }else pq.offer(k);
        }
        bw.flush();
    }
}
