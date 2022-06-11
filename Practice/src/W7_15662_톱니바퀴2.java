import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class W7_15662_톱니바퀴2 {

    static int T, K;
    static LinkedList<Integer>[] map;
    static boolean[] mov;
    static int[] dir;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        T = Integer.parseInt(st.nextToken());
        map = new LinkedList[T];

        for (int t = 0; t < T; t++) {
            map[t] = new LinkedList<>();
            char[] c = br.readLine().toCharArray();
            for (int i = 0; i < c.length; i++) {
                map[t].add(c[i] - '0');
            }
        }
        
        st = new StringTokenizer(br.readLine());
        K = Integer.parseInt(st.nextToken());

        for (int k = 0; k < K; k++) {
            mov = new boolean[T];
            dir = new int[T];
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            turn(num-1, d);
        }

        int ans = 0;
        for (LinkedList<Integer> j : map) {
            if(j.get(0) == 1) ans++;
        }

        System.out.println(ans);
    }

    private static void turn(int num, int d) {

        int left;
        int right;
        mov[num] = true;
        dir[num] = d;

        int m = num;
        while(--m >= 0){
            left = map[m+1].get(6);
            if(map[m].get(2) != left) {
                mov[m] = true;
                dir[m] = dir[m+1]==1?-1:1;
            }
            else break;
        }

        m = num;
        while(++m<T){
            right = map[m-1].get(2);
            if(map[m].get(6) != right) {
                mov[m] = true;
                dir[m] = dir[m-1]==1?-1:1;
            }
            else break;
        }

        for (int i = 0; i < T; i++) {
            if(mov[i]){
                if(dir[i] == 1){
                    Integer k = map[i].removeLast();
                    map[i].addFirst(k);
                }else{
                    Integer k = map[i].removeFirst();
                    map[i].addLast(k);
                }
            }
        }

    }
}
