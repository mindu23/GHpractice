import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_5525_IOIO {

    public static void main(String[] args) throws IOException {
        /**
         * N+1개의 I와 N개의 O
         * I와 O가 교대로 나오는 문자열 Pn
         * I와 O로만 이루어진 문자열 S와 정수 N이 주어졌을 때 S안에 Pn이 몇 군데 포함되어 있는지 구하기
         */

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        char[] S = br.readLine().toCharArray();

        boolean start = false;
        boolean beforeI = false;
        int len = 0;
        int res = 0;
        for (char c : S) {
            if (!start && c == 'I'){
                start = true;
                len++;
                beforeI = true;
            }else if (start && c == 'I'){
                if (!beforeI) len++;
                else len = 1;

                if (len == N*2+1){
                    len -= 2;
                    res++;
                }
                beforeI = true;
            } else if (!start && c == 'O') {
                len = 0;
                beforeI = false;
            } else if (start && c == 'O'){
                if (beforeI) len++;
                else {
                    start = false;
                    len = 0;
                }
                beforeI = false;
            }
        }

        System.out.println(res);

    }
}
