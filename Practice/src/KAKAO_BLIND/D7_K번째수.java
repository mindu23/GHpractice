package KAKAO_BLIND;

import java.util.Arrays;

public class D7_K번째수 {

    public static void main(String[] args) {
        int[] solution = solution(new int[]{1, 5, 2, 6, 3, 7, 4}, new int[][]{{2, 5, 3}, {4, 4, 1}, {1, 7, 3}});
        System.out.println(Arrays.toString(solution));
    }

    private static int[] solution(int[] array, int[][] commands) {
        int[] ans = new int[commands.length];
        for (int i = 0; i < commands.length; i++) {
            int a = commands[i][0] - 1;
            int b = commands[i][1] - 1;
            int c = commands[i][2] - 1;

            int[] newArray = Arrays.copyOfRange(array, a, b + 1);
            Arrays.sort(newArray);
            ans[i] = newArray[c];
        }
        return ans;
    }
}
