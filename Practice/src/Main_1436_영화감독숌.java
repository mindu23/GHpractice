import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_1436_영화감독숌 {

    //6이 적어도 3개 이상 연속으로 들어가는 수
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        solution1(N);
        solution2(N);
    }

    private static void solution2(int n) {

        // 또 다른 방법이 있지 않을까..
    }

    private static void solution1(int n) {
        int i = 666;
        int series = 1;
        while (series != n){
            i++;

            if (String.valueOf(i).contains("666")){
                series++;
            }
        }
        System.out.println(i);
    }
}
