package TwoPointers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.StringTokenizer;

/**
    1. 벨트에 임의의 한 위치부터 k개의 접시를 연속해서 먹을 경우 할인된 정액 가격으로 제공한다.
    2. 각 고객에게 초밥의 종류 하나가 쓰인 쿠폰을 발행하고, 1번 행사에 참가할 경우 이 쿠폰에 적힌 종류의 초밥을 추가로 무료로 제공한다.
        해당 번호가 적힌 초밥이 현재 벨트 위에 없을 경우 요리사가 만들어 손님에게 제공한다.

    할인 행사에 참여하여 가능한 다양한 종류의 초밥을 먹으려고 한다.
 */
public class Main_15961_회전초밥 {

    static int N, d, k, c;
    static int[] sushi;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        sushi = new int[2*N-1];
        
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());
            sushi[i] = k;
            if (i != N-1)
                sushi[i+N] = k; 
        }
        
        solution(N, d, k, c, sushi);

    }

    /**
     *
     * @param n 벨트에 놓인 접시의 수
     * @param d 초밥의 가짓수
     * @param k 연속해서 먹는 접시 수
     * @param c 쿠폰 번호
     * @param sushi
     */
    private static void solution(int n, int d, int k, int c, int[] sushi) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        int p1 = 0, p2 = 0;
        int maxD = 0;
        while(p1 < sushi.length){
            if (p1-p2 < k){
                int num = sushi[p1];
                if (hm.containsKey(num)) {
                    Integer cnt = hm.get(num);
                    hm.replace(num, cnt+1);
                }else {
                    hm.put(num, 1);
                }
                p1++;
            }else{
                int num = sushi[p2];
                Integer i = hm.get(num);
                if(i == 1) hm.remove(num);
                else hm.replace(num, i-1);
                p2++;
            }

            int cnt = hm.size();
            if (!hm.containsKey(c)) cnt++;
            maxD = Math.max(cnt, maxD);
//            if (maxD == d || maxD == k) break;
        }

        System.out.println(maxD);
    }
}
