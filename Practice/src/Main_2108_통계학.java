import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_2108_통계학 {

    static class Num{
        int num;
        int cnt;

        public Num(int num, int cnt) {
            this.num = num;
            this.cnt = cnt;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        List<Num> list = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        double avg = 0;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int j = 0;
        for (int i = 0; i < N; i++) {
            int K = Integer.parseInt(br.readLine());
            if (!map.containsKey(K)){
                map.put(K, j++);
                list.add(new Num(K, 1));
            }else {
                Integer ii = map.get(K);
                list.set(ii, new Num(K, list.get(ii).cnt++));
            }
            avg += K;
            max = max<K?K:max;
            min = min>K?K:min;
        }


        System.out.println(Math.round(avg / N));
        int cnt = 0;
        boolean isMiddle = false;
        int maxFreq = Integer.MIN_VALUE;
        int maxFreqIdx = 0;
        for (int i = 0; i < list.size(); i++) {
            if (!isMiddle){
                cnt += list.get(i).cnt;
                if (cnt >= N){
                    System.out.println(list.get(i).num);
                    isMiddle = true;
                }
            }
            if (maxFreq > list.get(i).cnt){
                maxFreq = list.get(i).cnt;
                maxFreqIdx = i; // 첫번째 최빈값
            }
        }

        int freq = list.get(maxFreqIdx).num;
        for (int i = maxFreqIdx+1; i < list.size(); i++) {
            if (list.get(i).cnt == maxFreq) {
                freq = list.get(i).num;
                break;
            }
        }
        System.out.println(freq);
        System.out.println(max - min);

    }


}
