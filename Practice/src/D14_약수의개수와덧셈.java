public class D14_약수의개수와덧셈 {

    public static void main(String[] args) {

        int left = 13;
        int right = 17;
        int solution = solution(13, 17);
        System.out.println(solution);
    }

    private static int solution(int left, int right) {
        int answer = 0;

        for (int i = left; i <= right; i++) {
            //if (find(i)) answer += i;
            //else answer -= i;

            // 제곱수인 경우 약수가 홀수
            if (i % Math.sqrt(i) == 0) answer -= i;
            else answer += i;
        }

        return answer;
    }

    private static boolean find(int i) {
        int k = 0;
        for (int j = 1; j <= i; j++) {
            if (i % j == 0) k++;
        }

        if (k%2 == 0) return true;
        else return false;
    }

}

