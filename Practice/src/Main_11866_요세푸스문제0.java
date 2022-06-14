import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main_11866_요세푸스문제0 {

    static int N, K;
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(new InputStreamReader(System.in));
        N = sc.nextInt();
        K = sc.nextInt();

        solution();
    }

    private static void solution() throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Queue<Integer> q = new LinkedList<>();

        for (int i = 1; i <= N ; i++) {
            q.offer(i);
        }
        bw.write("<");

        while (!q.isEmpty()){

            for (int i = 0; i < K-1; i++) {
                int cur = q.poll();
                q.offer(cur);
            }

            int k = q.poll();
            bw.write(String.valueOf(k));
            if (!q.isEmpty()) bw.write(", ");
        }

        bw.write(">");
        bw.flush();
    }
}
