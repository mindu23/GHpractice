import java.util.*;

public class D15_튜플 {

    public static void main(String[] args) {
        int[] solution = solution("{{20,111},{111}}");
        System.out.println(Arrays.toString(solution));
    }

    static class Num implements Comparable<Num>{
        int c;
        int cnt;

        public Num(int c, int cnt) {
            this.c = c;
            this.cnt = cnt;
        }

        // 내림차순
        @Override
        public int compareTo(Num o) {
            return o.cnt - this.cnt;
        }
    }

    static List<Num> list;
    public static int[] solution(String s) {
        //2},{2,1},{2,1,3},{2,1,3,4
        String[] s1 = s.substring(2, s.length() - 2).replaceAll("},", "/").replaceAll(",", " ").replaceAll("[{}]", "").split("/");

        Map<Integer, Integer> map = new HashMap<>();

        int i = 0;
        for (String s2 : s1) {
            String[] s3 = s2.split(" ");
            for (String s4_ : s3) {
                int s4 = Integer.parseInt(s4_);
                if (map.containsKey(s4)){
                    map.replace(s4, map.get(s4)+1);
                }else{
                    map.put(s4, 1);
                }
            }
        }

        list = new ArrayList<>();
        map.forEach((x,y) -> list.add(new Num(x, y)));

        Collections.sort(list);

        int[] answer = new int[list.size()];

        i = 0;
        for (Num num : list) {
            answer[i++] = num.c;
        }

        return answer;
    }
}
