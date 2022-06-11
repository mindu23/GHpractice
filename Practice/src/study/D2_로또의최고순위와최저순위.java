package study;

import java.util.Arrays;
import java.util.HashMap;

public class D2_로또의최고순위와최저순위 {
    /**
     * 숨겨진 로또 번호의 최저 최고 순위 찾기
     * 알 수 없는 번호는 0
     * 총 번호는 6개, 숫자의 범위는 1~45
     * 같은 수는 담겨있지 않고 정렬되지 않았다.
     *
     * 6개 모두 일치 => 1등
     * 5개 일치 => 2등
     * 4개 일치 => 3등
     * 3개 일치 => 4등
     * 2개 일치 => 5등
     * 그 외 => 6등
     */
    public static void main(String[] args) {
        int[] lottos = {45, 4, 35, 20, 3, 9};//3 4 9 20 35 45
        int[] win_nums = {20, 9, 3, 45, 4, 35};//3 4
        int[] ans = solution(lottos, win_nums);
        System.out.println(Arrays.toString(ans));
    }

    public static int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];

        Arrays.sort(lottos);
        Arrays.sort(win_nums);
        int ans_cnt = 0;
        int wrong_cnt = 0;
        for(int i = 0; i < 6; i++){
            if(lottos[i] == 0) {
                wrong_cnt++;
                continue;
            }
            for(int j = 0; j < 6; j++){
                if(lottos[i] < win_nums[j]) break;
                if(lottos[i] == win_nums[j]) ans_cnt++;
            }
        }

        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i <= 6; i++){
            if(i < 2){
                map.put(i, 6);
            }else{
                int a = 7 - i;
                map.put(i, a);
            }
        }
        answer[1] = map.get(ans_cnt);
        answer[0] = map.get(ans_cnt==6?ans_cnt:ans_cnt+wrong_cnt);
        return answer;
    }
}
