package DP1;

import java.util.Arrays;

public class 조합 {

    static int[] arr = {0,1,2,3};
    static int N = arr.length;
    static int M = 3;
    static int[] arr2 = new int[M];
    public static void main(String[] args) {

        comb(0,0);
    }

    private static void comb(int n, int start) {
        if (n == M) {
            System.out.println(Arrays.toString(arr2));
            return ;
        }

        for (int j = start; j < N; j++) {
            arr2[n] = j;
            comb(n+1, j+1);
        }
    }
}
