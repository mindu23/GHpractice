package L2_연습문제;

import java.util.Arrays;

public class D12_행렬의곱셈 {

    public static void main(String[] args) {
        int[][] solution = solution(new int[][]{{1, 4}, {3, 2}, {4, 1}}, new int[][]{{3, 3}, {3, 3}});
        for (int i = 0; i < solution.length; i++) {
            System.out.println(Arrays.toString(solution[i]));
        }
    }

    private static int[][] solution(int[][] arr1, int[][] arr2) {
        int r = arr1.length;
        int c = arr2[0].length;
        int[][] answer = new int[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                for (int k = 0; k < arr1[0].length; k++) {
                    answer[i][j] += arr1[i][k] * arr2[k][j];
                }
            }
        }
        return answer;
    }
}
