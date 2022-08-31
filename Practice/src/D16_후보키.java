import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class D16_후보키 {
    /**
     * 후보키의 성질: 유일성과 최소성
     */

    public static void main(String[] args) {
        String[][] relation = {
                {"100","ryan","music","2"},
                {"200","apeach","math","2"},
                {"300","tube","computer","3"},
                {"400","con","computer","4"},
                {"500","muzi","music","3"},
                {"600","apeach","music","2"}};

        int solution = solution(relation);
        System.out.println(solution);
    }

    /**
     * 컬럼을 1, 2 -- 8개 선택해서 20개 비교하기
     * @param relation 컬럼의 길이는 1~8, 로우의 길이는 1~20
     * @return
     */
    static int R, C;
    static String[][] relation2;
    static int K, ans;
    static boolean[] v;
    private static int solution(String[][] relation) {
        int answer = 0;
        R = relation.length;
        C = relation[0].length;
        relation2 = relation;

        for (int i = 1; i <= R; i++) {
            // i개를 선택하고 비교하기
            K = i;
            v = new boolean[C];
            comb(0,0);
        }

        answer = ans;

        return answer;
    }

    private static void comb(int cnt, int start) {
        if (cnt == K){
            // 비교하기
            check();
            return ;
        }

        for (int i = start; i < C; i++) {
            if (v[i]) continue;
            v[i] = true;
            comb(cnt+1, i+1);
            v[i] = false;
        }
    }

    private static void check() {
        for (int i = 0; i < R; i++) {
            Map<String, Boolean> map = new HashMap<>();
            int m = 0;
            if(v[i]) continue;
            for (int j = 0; j < C; j++) {
                if (map.containsKey(relation2[j][i])) return;
                map.put(relation2[j][i], true);
            }

        }
        ans = K;
    }

}
