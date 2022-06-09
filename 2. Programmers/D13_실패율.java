import java.io.IOException;
import java.util.*;

public class D13_실패율 {
    /**
     * 실패율 계산: 스테이지에 도달했으나 아직 클리어하지 못한 플래이어 수 / 스테이지에 도달한 플레이어 수
     */
    public static void main(String[] args) throws IOException {

        int N = 4;
        int[] stages = {4,4,4,4,4};

        int[] solution = solution(N, stages);
        System.out.println(Arrays.toString(solution));
    }
    
    static class K implements Comparable<K> {
        int stageN;
        double fail;

        public K(int stageN, double fail) {
            this.stageN = stageN;
            this.fail = fail;
        }


        @Override
        public int compareTo(K o) {
            if (this.fail == o.fail) return Integer.compare(this.stageN, o.stageN);
            else return Double.compare(o.fail, this.fail);
        }
    }

    /**
     *
     * @param N 전체 스테이지 개수 N
     * @param stages 게임을 이용하는 사용자가 현재 멈춰있는 스테이지 번호가 담긴 배열
     * @return 실패율이 높은 스테이지부터 내림차수 배열
     */
    public static int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        int[] nowStage = new int[N+1];
        int totalPlayer = stages.length;

        // 현재 스테이지에 머문 사람
        for (int i = 0; i < totalPlayer; i++) {
            nowStage[stages[i]-1]++;
        }

        K[] ks = new K[N+1];
        // 스테이지별 실패율 계산
        double clearPlayer = totalPlayer;
        for (int i = 0; i < nowStage.length; i++) {
            double fail = 0;
            if (nowStage[i] != 0) fail = nowStage[i]/clearPlayer;
            ks[i] = new K(i, fail);
            clearPlayer -= nowStage[i];
        }

        ks = Arrays.copyOf(ks, ks.length-1);
        Arrays.sort(ks);

        for (int i = 0; i < ks.length; i++) {
            answer[i] = ks[i].stageN+1;
        }

        return answer;
    }

}
