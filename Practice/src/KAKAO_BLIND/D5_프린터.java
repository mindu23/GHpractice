package KAKAO_BLIND;
import java.util.*;
import java.io.*;

public class D5_프린터 {
    static class P implements Comparable<P>{
        int loc;
        int pri;

        public P (int loc, int pri){
            this.loc = loc;
            this.pri = pri;
        }

        @Override
        public int compareTo(P o){
            return Integer.compare(o.pri, this.pri);
        }
    }

    public static void main(String[] args) {
        int solution = solution(new int[]{2, 1, 3, 2}, 2);
        System.out.println(solution);
    }

    private static int solution(int[] priorities, int location) {
        int answer = 0;
        Queue<P> q = new LinkedList<>();
        LinkedList<Integer> p_list = new LinkedList<>();

        for(int i = 0; i < priorities.length; i++){
            q.offer(new P(i, priorities[i]));
            p_list.add(priorities[i]);
        }
        Collections.sort(p_list, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2){
                return Integer.compare(o2, o1);
            }
        });
        int cnt = 0;
        while(!q.isEmpty()){
            P cur = q.poll();
            if (cur.pri == p_list.get(0)){
                cnt++;
                p_list.removeFirst();
                if (cur.loc == location){
                    answer = cnt;
                    break;
                }
            }else q.offer(cur);
        }

        return answer;
    }
}
