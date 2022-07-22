package KAKAO_BLIND;
import java.util.*;
import java.io.*;

public class D4_기능개발 {

    public static void main(String[] args) {
        int[] solution = solution(new int[]{93, 30, 55}, new int[]{1, 30, 5});
        System.out.println(solution);
    }

    public static int[] solution(int[] progresses, int[] speeds) {
        int[] answer = new int[100];
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < progresses.length; i++){
            q.offer((int)Math.ceil((100.0-progresses[i])/speeds[i]));
        }

        int maxBefore = q.peek();
        int cnt = 0;
        int k = 0;
        while(!q.isEmpty()){
            int cur = q.peek();
            if(cur <= maxBefore){
                q.poll();
                cnt++;
            }else {
                maxBefore = q.peek();
                answer[k++] = cnt;
                cnt = 0;
            }
        }
        answer[k++] = cnt;
        cnt = 0;

        return Arrays.copyOfRange(answer, 0, k);
    }
}
