import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 9명으로 이루어진 두 팀이 공/수 번갈아
 * 하나의 이닝은 공격과 수비로 이루어짐. 총 N 이닝
 * 3아웃 발생시 이닝 종료. 공수 변경
 * 1-2...-9-1-2.. 반복
 * 안타: 모두 한루씩
 * 2루타: 모두 두루씩
 * 3루타: 세루씩
 * 홈런: 홈까지
 * 아웃: 모두 제자리. 아웃 증가
 */
public class Main_17281_야구 {

    static boolean[] selectPlayer; // 선택 유무
    static int[] numPlayer; // 총 플레이 순서
    static int N, res; // 총 이닝 수
    static int[][] play; // 각 선수가 각 이닝에서 얻는 결과
    static int nine = 9;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        play = new int[N][nine];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < nine; j++) {
                play[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        selectPlayer = new boolean[nine];
        numPlayer = new int[nine];
        solution();
    }

    /**
     * 타순을 정하려고 한다.
     * 가장 좋아하는 선수인 1번 선수를 4번 타자로 미리 정함
     * 다른 선수의 타순을 모두 결정해야 한다.
     */
    private static void solution() {

        // 1. 순열 생성
        selectPlayer[0] = true;
        numPlayer[3] = 0;
        perm(0);

        System.out.println(res);
    }

    private static void perm(int cnt) {
        if (cnt == nine){
            // 2. 게임 수행
            //System.out.println(Arrays.toString(numPlayer));
            letsPlayBall();
        }else if (cnt == 3){
            perm(cnt+1);
        }else {
            for (int i = 0; i < nine; i++) {
                if (selectPlayer[i]) continue;
                selectPlayer[i] = true;
                numPlayer[cnt] = i;
                perm(cnt + 1);
                selectPlayer[i] = false;
            }
        }
    }

    private static void letsPlayBall() {
        int score = 0;
        int turn = 0;
        boolean[] base = new boolean[4]; // 0: 홈 .. 3루
        int outCnt = 0;

        // 이닝
        for (int i = 0; i < N; i++) {
            outCnt = 0;

            while (true){
                // 현재 타자의 번호
                int playerNum = numPlayer[turn];
                // 현재 이닝에서 타자의 결과
                int k = play[i][playerNum];

                if (k == 0) {
                    outCnt++;
                }else if (k == 1){
                    // 현재 타자
                    base[0] = true;
                    // 안타
                    for (int j = 3; j >= 0; j--) {
                        // 사람 있으면
                        if (base[j]){
                            // 3루에 사람있으면 1점 증가
                            if (j >= 3) {
                                score++;
                            }else{
                                // 앞으로 한칸씩 증가
                                base[j+1] = base[j];
                            }
                            base[j] = false;
                        }
                    }
                }else if (k == 2){
                    // 현재 타자
                    base[0] = true;
                    // 2루타
                    for (int j = 3; j >= 0; j--) {
                        // 사람있으면
                        if (base[j]){
                            // 2 같거나 크면 바로 들어감
                            if (j >= 2){
                                score++;
                            }else {
                                // 2칸 앞으로
                                base[j+2] = base[j];
                            }
                            base[j] = false;
                        }
                    }
                }else if (k == 3){
                    // 현재 타자
                    base[0] = true;
                    for (int j = 3; j >= 0; j--) {
                        // 사람 있으면
                        if (base[j]){
                            // 1루타 까지 들어감
                            if (j >= 1){
                                score++;
                            }else {
                                // 3칸 앞으로 이동
                                base[j+3] = base[j];
                            }
                            base[j] = false;
                        }
                    }
                }else if (k == 4){
                    // 현재 타자
                    base[0] = true;
                    for (int j = 3; j >= 0; j--) {
                        if (base[j]){
                            if (j >= 0){
                                score++;
                            }
                            base[j] = false;
                        }
                    }
                }

                turn++;
                turn = turn==9?0:turn;

                if (outCnt == 3){
                    for (int j = 0; j < base.length; j++) {
                        base[j] = false;
                    }
                    break;
                }
            }
        }

        // 모든 이닝이 끝난 후 득점 수 계산 max 값 찾기
        res = Math.max(res, score);
    }

}
