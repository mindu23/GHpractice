import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main_2812_크게만들기 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        String M = br.readLine();

        solution2(N, K, M);

    }

    private static void solution2(int N, int K, String M) {
        int[] nums = new int[N];
        for (int i = 0; i < N; i++) {
            nums[i] = M.charAt(i) - '0';
        }

        Stack<Integer> stack = new Stack<>();
        int removeCnt = 0;
        int nowIdx = 0;
        stack.push(nums[0]);

        // 포문 돌리기
        for (nowIdx = 1; nowIdx < nums.length; nowIdx++) {

            while (!stack.isEmpty() && stack.peek() < nums[nowIdx] && removeCnt < K){
                stack.pop();
                removeCnt++;
            }

            stack.push(nums[nowIdx]);

            if (removeCnt == K) break;
        }

        for (int i = nowIdx+1; i < nums.length; i++) {
            stack.push(nums[i]);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N-K; i++) {
            sb.append(stack.get(i));
        }
        System.out.println(sb.toString());
    }

}
