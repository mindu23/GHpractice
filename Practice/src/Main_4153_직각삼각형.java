import java.io.*;
import java.util.StringTokenizer;

public class Main_4153_직각삼각형 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while (true){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            if (a == 0 && b == 0 && c == 0) break;

            int max = Math.max(a, Math.max(b, c));
            if (a == max){
                if (b+c > a && b*b+c*c == a*a) bw.write("right\n");
                else bw.write("wrong\n");
            } else if (b == max) {
                if (a+c > b && a*a+c*c == b*b) bw.write("right\n");
                else bw.write("wrong\n");
            } else if (c == max) {
                if (b+a > c && b*b+a*a == c*c) bw.write("right\n");
                else bw.write("wrong\n");
            }
        }

        bw.flush();
    }
}
