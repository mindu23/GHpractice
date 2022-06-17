import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main_1620_나는야포켓몬마스터이다솜 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        Map<String, String> map = new HashMap<>();
        for (int i = 1; i <= N; i++) {
            String pokemon = br.readLine();
            map.put(pokemon, String.valueOf(i));
            map.put(String.valueOf(i), pokemon);
        }

        for (int i = 0; i < M; i++) {
            String q = br.readLine();
            System.out.println(map.get(q));
        }
    }
}
