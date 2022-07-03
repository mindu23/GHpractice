import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main_10816_숫자카드2 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        Integer[] arr = new Integer[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o1, o2);
            }
        });

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            int key = Integer.parseInt(st.nextToken());
            int u = upperBound(key, arr);
            int l = lowerBound(key, arr);
            // upperBound일 경우, 마지막이면 +1을 해준다.
            if (u == arr.length-1 && arr[u] == key) u++;
            bw.write(u-l+" ");
        }

        bw.flush();
    }

    private static int lowerBound(int key, Integer[] arr) {

        int mid = 0;
        int min = 0;
        int max = arr.length-1;

        while (min < max){
            mid = (min + max)/2;

            if (key <= arr[mid]){
                max = mid;
            }else {
                min = mid+1;
            }
        }

        return min;
    }

    private static int upperBound(int key, Integer[] arr) {

        int mid = 0;
        int min = 0;
        int max = arr.length-1;

        while (min < max){
            mid = (min + max)/2;

            if (key < arr[mid]){
                max = mid;
            }else {
                min = mid+1;
            }
        }
        return min;
    }
}
