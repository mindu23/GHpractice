import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;

/**
    해커톤 대회에 참가하는 모든 참가자들에게 숫자들과 3가지의 연산 문자(+,-,*)로 이루어진 연산 수식이 전달되며,
    참가자의 미션은 전달받은 수식에 포함된 연산자의 우선순위를 재정의해 만들 수 있는 가장 큰 숫자를 제출하는 것.
    단, 연산자의 우선순위를 새로 정의할 때, 같은 순위의 연산자는 없다. (+ > - > * or - > * > +의 연산자 우선순위를 정할 수 있으나 +,* > - or * > +,-처럼 2개 이상의 연산자가 동일한 순위를 가지도록 정의할 수는 없다.)
    수식에 초함된 연산자가 2개면 조합은 2! = 2가지, 3개라면 3! = 6가지

    만약 계산된 결과가 음수라면 절댓값으로 변환하여 제출한다.
    제출한 숫자가 가장 큰 참가자가 우승자가 되며, 제출한 숫자가 우승상금이다.

    100-200*300-500+20

    0. String을 읽으면서 연산자의 위치 찾기
    1. 연산자의 우선순위 정하기 => 조합
    2. 제일 큰 우선순위의 연산자를 기준으로 양쪽 숫자 계산
 */

public class D12_수식최대화 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        solution(br.readLine().toString());
    }

    static class sol{
        int n;
        char exp;

        public sol(int n, char exp) {
            this.n = n;
            this.exp = exp;
        }
    }

    static char[] exp2;
    static LinkedList<sol> sols = new LinkedList<>();

    private static long solution(String expression) {
        long answer = 0;

        String[][] operatorList = {{"+", "-", "*"}, {"+", "*", "-"}, {"*", "+", "-"}, {"*", "-", "+"}, {"-", "*", "+"}, {"-", "+", "*"}};

        for (String[] opSel : operatorList){
            String[] operand1 = expression.split("-|\\+|\\*"); // 피연산자
            String[] operator1 = expression.split("[0-9]+"); // 연산자

            LinkedList<String> operand2 = new LinkedList<>(Arrays.asList(operand1));
            LinkedList<String> operator2 = new LinkedList<>(Arrays.asList(operator1));

            for (String op: opSel){

            }
        }

        return answer;
    }

    private static int sumOrSubOrMul(String a, String b, String op) {
        int res = 0;
        if (op == "+"){
            res = Integer.parseInt(a) + Integer.parseInt(b);
        }else if (op == "-"){
            res = Integer.parseInt(a) - Integer.parseInt(b);
        }else {
            res = Integer.parseInt(a) * Integer.parseInt(b);
        }

        return res;
    }
}
