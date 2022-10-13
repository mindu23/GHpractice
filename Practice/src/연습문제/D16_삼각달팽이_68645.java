package 연습문제;

import org.junit.jupiter.api.Assertions;

import java.util.Arrays;

public class D16_삼각달팽이_68645 {

    public static void main(String[] args) {
        Assertions.assertEquals(Arrays.toString(new int[]{1,2,9,3,10,8,4,5,6,7}), Arrays.toString(solution(4)));
        Assertions.assertEquals(Arrays.toString(new int[]{1,2,12,3,13,11,4,14,15,10,5,6,7,8,9}), Arrays.toString(solution(5)));
        Assertions.assertEquals(Arrays.toString(new int[]{1,2,15,3,16,14,4,17,21,13,5,18,19,20,12,6,7,8,9,10,11}), Arrays.toString(solution(6)));
    }

    private static int[] solution(int n) {
        int m = n;

        int[][] map = new int[n][n];

        int last = 0;
        for(int i = 1; i <= n; i++){
            last += i;
        }
        int[] answer = new int[last];
        int r = 0;
        int c = 0;
        int s = 0;
        boolean up = false;
        for(int i = 1; i <= last; i++){

            map[r][c] = i;

            if(!up){
                if(r < n-1 && map[r][c] != 0){
                    r++;
                }else if(r == n-1 && c < n-1-s){
                    c++;
                }else if(r == n-1 && c == n-1-s){
                    up = true;
                    r--;
                    c--;
                }
            }else{ // up == true
                r--;
                c--;
                if(map[r][c] != 0){
                    up = false;
                    n--;
                    r += 2;
                    c += 1;
                    s++;
                }
            }
        }

        int k = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] != 0) {
                    answer[k++] = map[i][j];
                }
            }
        }

        return answer;
    }
}
