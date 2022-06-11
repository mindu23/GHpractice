import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main_1783_병든나이트 {

    static int[] dr = {-2,-1,1,2};
    static int[] dc = {1,2,2,1};
    static int N, M;
    static int[][] map;
    static boolean[][] visited;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();

        map = new int[N][M];
        visited = new boolean[N][M];

//        System.out.println(N+" "+M);

        // 전부 다 돌아보기
        // 더 이상 갈 수 없을 경우
        //  1. 이동 횟수 4번 이하는 ok int cnt
        //  2. 이동 횟수가 5번 이상이면 한 번씩 모두 사용해봐야 한다. boolean[] check

//        solution();

        if (N == 1){
            ans = 1;
        }else if(N == 3){

        }

        System.out.println(ans);
    }

    static class k{
        int r;
        int c;
        int cnt;
        boolean[] check;

        public k(int r, int c, int cnt, boolean[] check) {
            this.r = r;
            this.c = c;
            this.cnt = cnt;
            this.check = check;
        }
    }

    static int ans = 0;
    private static void solution() {
        Queue<k> q = new LinkedList<>();
        q.offer(new k(N-1, 0, 1, new boolean[4]));

        while (!q.isEmpty()){
            k cur = q.poll();

            for (int d = 0; d < dr.length; d++) {
                int nr = cur.r + dr[d];
                int nc = cur.c + dc[d];

                if (nr < 0 || nc < 0 || nr >= N || nc >= M) {
                    if (cur.cnt <= 4) ans = Math.max(ans, cur.cnt);
                    else {
                        boolean allCheck = true;
                        for(boolean b: cur.check){
                            // 전부 방문 X
                            if (!b) {
                                allCheck = false;
                                break;
                            }
                        }
                        if (allCheck) ans = Math.max(ans, cur.cnt);
                    }
                    continue;
                }

                boolean[] check2 = Arrays.copyOf(cur.check, cur.check.length);
                check2[d] = true;
                q.offer(new k(nr, nc, cur.cnt+1, check2));
            }
        }
    }
}
