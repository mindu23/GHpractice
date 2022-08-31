import java.util.*;

public class Solution {

    public static void main(String[] args) {
//        System.out.println(solution3(new long[][]{{1,2},{2,3},{2,4},{2,5},{5,6},{5,7},{6,8},{2,9}}));
        System.out.println(solution5(new int[]{1,1,2,3,3,2,2}));
    }

    private static int solution5(int[] tasks) {
        int answer = 0;
        Map<Integer, Integer> map = new HashMap<>();
        LinkedList<Integer> list = new LinkedList<>();

        for (int task : tasks) {
            if (!map.containsKey(task)) list.add(task);
            map.put(task, map.getOrDefault(task, 0)+1);
        }

        while (!list.isEmpty()){
            Integer t = list.get(0);
            if (map.get(t) % 3 == 0){
                map.remove(t);
                list.remove(0);
                answer += answer/3;
            } else if (map.get(t) % 2 == 0) {
                map.remove(t);
                list.remove(0);
                answer += answer/2;
            }else {
                answer = -1;
                break;
            }
        }
        
        return answer;
    }

    static class Dungeons implements Comparable<Dungeons>{
        int need;
        int use;

        public Dungeons(int need, int use) {
            this.need = need;
            this.use = use;
        }

        @Override
        public int compareTo(Dungeons o) {
            return Integer.compare(this.use, o.use);
        }
    }

    static int maxD;
    private static int solution3(int k, int[][] dungeons) {
        int answer = -1;
//        LinkedList<Dungeons> list = new LinkedList<>();
//        for (int[] dungeon : dungeons) {
//            list.add(new Dungeons(dungeon[0], dungeon[1]));
//        }
//        Collections.sort(list);

        go(k, dungeons, new boolean[dungeons.length], 0);

        return maxD;
    }

    private static void go(int k, int[][] dungeons, boolean[] visited, int cnt) {

        maxD = Math.max(maxD, cnt);

        if (cnt == dungeons.length) {
            return;
        }

        for (int i = 0; i < dungeons.length; i++) {
            if (visited[i] || k < dungeons[i][0]) continue;
            visited[i] = true;
            go(k-dungeons[i][1], dungeons, visited, cnt+1);
            visited[i] = false;
        }
    }

    private static long[] solution4(long[][] invitationPairs) {
        long[] answer = {};
        ArrayList<ArrayList<Long>> list = new ArrayList<>();
        for (int i = 0; i < Long.MAX_VALUE; i++) {
            list.add(new ArrayList<>());
        }

        HashSet<Long> hs = new HashSet<>();
        for (int i = 0; i < invitationPairs.length; i++) {
            long[] invitationPair = invitationPairs[i];
            list.get((int) invitationPair[0]).add(invitationPair[1]);
        }
        return answer;
    }

    // 상위 25% 이내 중 가장 쉬운 문제
    private static int solution2(int[] levels) {
        int answer = Integer.MIN_VALUE;

        Arrays.sort(levels);
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < levels.length; i++) {
            map.put(levels[i], map.getOrDefault(levels[i], 0)+1);
        }
        // 상위 25이내면 top보다 작아야함
        int top = levels.length/4;

        int k = 0; // 개수
        boolean ck = false;
        for (int i = levels.length - 1; i >= 0; i--) {
            k += map.get(levels[i]);
            if (k <= top){
                answer = levels[i];
            }else break;
        }

        return answer==Integer.MIN_VALUE?-1:answer;
    }

    private static int solution(String s) {
        int answer = 0;

        int cnt = 1;
        int startIdx = 0;

        if (s.length() == 0) return -1;

        char num = s.charAt(0);
        int max = Integer.MIN_VALUE;

        for (int i = 1; i < s.length(); i++) {
            if (num == s.charAt(i)){
                cnt++;
                if (cnt == 3) {
                    max = Math.max(max, Integer.parseInt(s.substring(startIdx, i+1)));
                }
            }else {
                num = s.charAt(i);
                cnt = 1;
                startIdx = i;
            }
        }
        return max==Integer.MIN_VALUE?-1:max;
    }
}
