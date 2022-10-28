package L2_연습문제;

import org.junit.jupiter.api.Assertions;

public class N진수게임_17687 {

    public static void main(String[] args) {
        Assertions.assertEquals("0111", solution(2,4,2,1));
        Assertions.assertEquals("02468ACE11111111", solution(16,16,2,1));
        Assertions.assertEquals("13579BDF01234567", solution(16,16,2,2));
    }

    /**
     * 0부터 차례대로 말한다. 첫번째 사람은 0, 열번째는 9
     * 10이상의 숫자는 한자리씩 끊기. 열한번째는 1 열두번째는 0 <- 10
     * n진법, 미리 구할 숫자의 개수 t, 게임 참가 인원 m, 튜브 순서 p
     **/
    private static String solution(int n, int t, int m, int p) {
        String answer = "";

        // 숫자 계속 구해서 StringBuilder에 추가
        // 길이/m이 t를 넘어가면 그만~!
        int i = 0;
        // 전체 길이
        StringBuilder sb = new StringBuilder ();
        while(sb.length()/m < t){
            sb.append(changeToN(n, i));
            i++;
        }
        // System.out.println("i = "+  i+" sb.toString() = "+sb.toString());
        StringBuilder ans = new StringBuilder();
        for(int j = p-1; j < sb.length(); j += m){
            if(ans.length() == t) break;
            ans.append(sb.toString().charAt(j));
        }
        return ans.toString();
    }
    // 0! 1 1!0 1!1 1!00
    private static String changeToN(int n, int i){
        if(i == 0) return "0";
        StringBuilder sb = new StringBuilder();
        while(i > 0){
            int res = i%n;
            if(res == 10) sb.append("A");
            else if(res == 11) sb.append("B");
            else if(res == 12) sb.append("C");
            else if(res == 13) sb.append("D");
            else if(res == 14) sb.append("E");
            else if(res == 15) sb.append("F");
            else sb.append(res);
            i /= n;
        }
        return sb.reverse().toString();
    }
}
