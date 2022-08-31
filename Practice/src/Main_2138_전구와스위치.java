import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_2138_전구와스위치 {

    static char[] start;
    static char[] finish;
    public static void main(String[] args) throws IOException {
        // i번째 스위치를 누르면 i-1,i,i+1번째 스위치가 변경된다.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        start = br.readLine().toCharArray();
        finish = br.readLine().toCharArray();


    }
}
