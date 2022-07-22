package KAKAO_BLIND;
import java.util.*;

public class D3_다리를지나는트럭 {

    static class Truck{
        int sec;
        int w;
        public Truck(int sec, int w){
            this.sec = sec;
            this.w = w;
        }
    }

    public static void main(String[] args) {
        int solution = solution(2, 10, new int[]{7, 4, 5, 6});
        System.out.println(solution);
    }

    private static int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        Queue<Truck> q = new LinkedList<>();
        int now = 0;
        int nowWeight = 0;
        int i = 0;
        while(true){
            Truck t;
            if(!q.isEmpty()) {
                t = q.peek();
                if(answer - bridge_length >= t.sec) {
                    q.poll();
                    nowWeight -= t.w;
                }
            }
            if(now < truck_weights.length && nowWeight+truck_weights[now] <= weight){
                nowWeight += truck_weights[now];
                q.offer(new Truck(answer, truck_weights[now++]));
            }
            answer++;
            if (q.isEmpty()) break;
        }

        return answer;
    }
}
