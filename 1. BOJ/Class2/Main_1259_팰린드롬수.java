package Class2;

import java.util.Scanner;

public class Main_1259_팰린드롬수 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        while (true){
            String k = sc.next();
            if (k.equals("0")) break;

            boolean res = false;

            // 길이가 홀수일 때 가운데 수 제외하고 비교
            int check = k.length()/2;

            for (int i = 0; i < check; i++) {
                res = true;
                if (k.charAt(i) != k.charAt(k.length()-1-i)){
                    res = false;
                    break;
                }
            }

            if (k.length()==1) {
                res = true;
            }

            if (res){
                sb.append("yes\n");
            }else {
                sb.append("no\n");
            }
        }

        System.out.println(sb.toString());
    }
}
