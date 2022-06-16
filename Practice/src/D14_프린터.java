import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class D14_프린터 {

    public static void main(String[] args) {
        int[] priorities = {1, 1, 9, 1, 1, 1};
        int location = 0;

        int solution = solution2(priorities, location);
        System.out.println(solution);
    }

    private static class J{
        int n;
        int loc;

        public J(int n, int loc) {
            this.n = n;
            this.loc = loc;
        }
    }
    private static int solution(int[] priorities, int location) {
        int answer = 0;
        LinkedList<Integer> list = new LinkedList<>();
        Queue<J> q = new LinkedList<>();
        for (int i = 0; i < priorities.length; i++) {
            int k = priorities[i];
            list.add(k);
            q.offer(new J(k, i));
        }

        // 내림차순 정렬
        list.sort((o1, o2) -> o2-o1);

        while(true){
            J cur = q.poll();
            if (cur.n >= list.getFirst()){
                answer++;
                list.removeFirst();
                if (cur.loc == location) break;
            }else q.offer(cur);
        }

        return answer;
    }

    private static int solution2(int[] priorities, int location){
        int answer = 0;
        Queue<Integer> q = new LinkedList<>();

        for (int p: priorities) {
            q.offer(p);
        }

        Arrays.sort(priorities);
        int max = priorities.length-1;

        while(true){
            Integer cur = q.poll();
            if (cur < priorities[max]){
                q.offer(cur);
                location--;
                if (location < 0){
                    location = q.size()-1;
                }
            }else {
                max--;
                answer++;
                location--;
                if (location < 0){
                    break;
                }
            }
        }
        return answer;
    }
}
