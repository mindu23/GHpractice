import java.io.*;
import java.util.*;

public class Main_7662_이중우선순위큐 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>(); // 오름
        PriorityQueue<Integer> pq2 = new PriorityQueue<>((o1, o2) -> o2-o1); // 내림

        for (int t = 0; t < T; t++) {
            int k = Integer.parseInt(br.readLine());


            for (int i = 0; i < k; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                String command = st.nextToken();
                int num = Integer.parseInt(st.nextToken());

                switch (command){
                    case "D":
                        if (pq.isEmpty()) continue;
                        else if (num == -1){
                            Integer poll = pq.poll();
                            pq2.remove(poll);
                        }
                        else{
                            Integer poll = pq2.poll();
                            pq.remove(poll);
                        }
                        break;
                    case "I":
                        pq.offer(num);
                        pq2.offer(num);
                        break;
                }

            }
            if (pq.isEmpty()) bw.write("EMPTY\n");
            else bw.write(pq2.peek()+" "+ pq.peek());
            pq.clear();
            pq2.clear();
        }

        bw.flush();
    }
}
