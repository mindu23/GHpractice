import java.io.*;
import java.util.StringTokenizer;

public class Main_2869_달팽이는올라가고싶다 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());

        long day = (V-B) / (A-B);

        if ((V-B) % (A-B) != 0) day++;

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(String.valueOf(day));
        bw.flush();
    }
}
