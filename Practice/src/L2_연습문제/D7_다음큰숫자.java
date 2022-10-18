package L2_연습문제;

import org.junit.jupiter.api.Assertions;

public class D7_다음큰숫자 {

    public static void main(String[] args) {
        Assertions.assertEquals(solution(78), 83);
        Assertions.assertEquals(solution(15), 23);
    }

    /**
     * 가장 처음 나오는 1 자리수에 1 더하기
     * 그 뒤에는 앞에 나온 1의 개수보다 0의 개수가 크다
     * 맨 아래부터 1넣어주기
     * @param n
     * @return n의 이진수의 1의 개수가 동일한 값 중 큰값 중 가장 작은 값
     */
    private static int solution(int n) {
        int answer = 0;
        char[] nToBinary = Integer.toBinaryString(n).toCharArray();
        int realOneCnt = 0;
        for (char c : nToBinary) {
            if (c=='1') realOneCnt++;
        }
        boolean findOne = false;

        // 큰 값 만들기
        int before = 1;
        for (int i = nToBinary.length-1; i >= 0; i--) {
            if (!findOne && nToBinary[i] == '1'){
                findOne = true;
                before = 1;
                nToBinary[i] = '0';
            }else if(findOne){
                if (before == 1 && nToBinary[i] == '0') {
                    nToBinary[i] = '1';
                    before = 0;
                    break;
                }else if(before == 1 && nToBinary[i] == '1'){
                    nToBinary[i] = '0';
                }
            }
        }

        char[] newNToBinary = new char[nToBinary.length+1];
        for (int i = newNToBinary.length-1; i >= 1; i--) {
            newNToBinary[i] = nToBinary[i-1];
        }
        newNToBinary[0] = (char)(before+'0');

//        System.out.println(Arrays.toString(newNToBinary));

        // 1의 개수 맞추기
        // 바뀐 문자열의 1의 개수
        int changeOneCnt = 0;
        for (char c : newNToBinary) {
            if (c=='1') changeOneCnt++;
        }

        for (int i = newNToBinary.length-1; i >= 0; i--) {
            if (changeOneCnt < realOneCnt) {
                newNToBinary[i] = '1';
                changeOneCnt++;
            }
            if (changeOneCnt == realOneCnt) break;
        }

//        System.out.println(Arrays.toString(newNToBinary));

        for (int i = newNToBinary.length-1; i >= 0; i--) {
            if (newNToBinary[i] == '1')
                answer += Math.pow(2, newNToBinary.length-i-1);
        }

        return answer;
    }
}
