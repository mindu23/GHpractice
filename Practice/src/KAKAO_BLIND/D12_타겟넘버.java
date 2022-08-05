package KAKAO_BLIND;

public class D12_타겟넘버 {

    public static void main(String[] args) {
        System.out.println(solution(new int[]{1,1,1,1,1}, 3));
    }

    private static int solution(int[] numbers, int target) {
        int answer = 0;

        // 뺄셈
        dfs(numbers, 0, target, 0);

        return ans;
    }

    static int ans;
    private static void dfs(int[] numbers, int start, int target, int res) {
        if (start == numbers.length){
            if (res == target) ans++;
            return;
        }

        dfs(numbers, start+1, target, res+numbers[start]);
        dfs(numbers, start+1, target, res-numbers[start]);
        return ;
    }
}
