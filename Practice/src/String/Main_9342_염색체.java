package String;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Main_9342_염색체 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for (int t = 0; t < T; t++) {
            boolean isOk = false;
            String str = br.readLine();
            int a = str.indexOf('A');
            int f = str.indexOf('F');
            int c = str.indexOf('C');
            int aLast = str.lastIndexOf('A');
            int fLast = str.lastIndexOf('F');

            /**
             * 1. 문자열의 처음과 끝에 등장하는 문자는 A, B, C, D, E, F 중 0개 또는 1개가 와야 한다.
             * 2. 첫번째 문자 -> .. -> A -> .. -> F -> .. C -> .. -> 마지막 문자
             */

            // 마지막이 A / F / C
            if (str.charAt(str.length()-1) == 'A' || str.charAt(str.length()-1) == 'F' || str.charAt(str.length()-1) == 'C' ){
                // A / F / C가 순서대로 등장
                if (a < f && f < c){
                    // 마지막 A의 위치 == 첫번째 F의 위치 앞
                    // 마지막 F의 위치 == 첫번째 C의 위치 앞
                    if (aLast == f-1 && fLast == c-1){
                        isOk = true;
                    }

                }
            }

            if (isOk) bw.write("Infected!\n");
            else bw.write("Good\n");
        }

        bw.flush();
    }
}
