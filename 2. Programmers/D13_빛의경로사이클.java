import java.util.*;

public class D13_빛의경로사이클 {
    /**
     * S: 직진
     * L: 좌회전
     * R: 우회전
     * 끝을 넘어갈 경우, 반대쪽 끝으로 이동
     * 빛이 이동할 수 있는 경로 사이클의 개수와 각 사이클의 길이
     */
    public static void main(String[] args) {
        String[] grid = {"SL","LR"};

        int[] solution = solution(grid);
        System.out.println(Arrays.toString(solution));
    }

    // 좌 우 상 하
    static int[] dr = {0,0,-1,1};
    static int[] dc = {-1,1,0,0};
    static boolean[][][] lights;
    static char[][] map;
    public static int[] solution(String[] grid) {
        List<Integer> ans = new ArrayList<>();

        // char[]로 변경
        map = new char[grid.length][grid[0].length()];
        lights = new boolean[map.length][map[0].length][4];
        for (int i = 0; i < grid.length; i++) {
            map[i] = grid[i].toCharArray();
        }

        // 모든 곳에서 시작한다.
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                for (int d = 0; d < dr.length; d++) {
                    if (lights[i][j][d]) continue;
                    int moveCnt = start(i, j, d, 0);
                    if (moveCnt != 0) {
                        ans.add(moveCnt);
                    }
                }
            }
        }

        int[] answer = new int[ans.size()];
        for (int i = 0; i < ans.size(); i++) {
            answer[i] = ans.get(i);
        }
        Arrays.sort(answer);
        return answer;
    }

    static class L{
        int r;
        int c;
        int d;
        int cnt;

        public L(int r, int c, int d, int cnt) {
            this.r = r;
            this.c = c;
            this.d = d;
            this.cnt = cnt;
        }
    }
    /**
     *
     * @param i 행
     * @param j 열
     * @param d 이전 이동 방향
     * @param cnt 길이
     */
    private static int start(int i, int j, int d, int cnt) {

        Queue<L> q = new LinkedList<>();
        q.offer(new L(i, j, d, cnt));
        int res = 0;

        while(!q.isEmpty()){
            L cur = q.poll();

            if (lights[cur.r][cur.c][cur.d]) {
                res = cur.cnt;
                break;
            }

            int nr = cur.r;
            int nc = cur.c;
            int nd = cur.d;

            lights[nr][nc][nd] = true;

            if (map[nr][nc] != 'S'){
                nd = move(nr, nc, nd);
            }

            nr += dr[nd];
            nc += dc[nd];

            // 범위를 벗어난 경우
            if (nr < 0 || nr >= map.length) nr = nr<0? map.length-1 : 0;
            if (nc < 0 || nc >= map[0].length) nc = nc<0? map[0].length-1 : 0;

            q.offer(new L(nr, nc, nd, cur.cnt+1));
        }

        return res;
    }

    private static int move(int nr, int nc, int d) {
        if (map[nr][nc] == 'R'){
            if (d == 0) return 2;
            else if (d == 1) return 3;
            else if (d == 2) return 1;
            else return 0;
        }else { // L
            if (d == 0) return 3;
            else if (d == 1) return 2;
            else if (d == 2) return 0;
            else return 1;
        }
    }
}
