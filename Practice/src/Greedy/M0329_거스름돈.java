package Greedy;

import java.util.Scanner;

public class M0329_거스름돈 {

    static int n, ans;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        ans = -1;
        int i = 0;
        while(n > 0){
            // 5로 나뉠 수 있을 때는 i(2원의 개수)와 n/5를 더한 값이 ans가 된다.
            if(n%5 == 0) {
                ans = n/5 + i;
                break;
            }
            n -= 2;
            i++;
            // 딱 떨어졌을 때는 i가 ans가 된다.
            if(n == 0) ans = i;
        }

        System.out.println(ans);
    }

}
