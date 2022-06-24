import java.util.ArrayList;
import java.util.List;

public class D15_조이스틱 {

    public static void main(String[] args) {

//        int sol = 'A' - 'J'; // 9
//        int sol2 = 'A' - 'Z'; // 25
        int sol = solution("JEROEN");
        int sol2 = solution2("JEROEN");
        System.out.println(sol2);
    }

    private static int solution2(String name) {
        int answer = 0;
        // 계속 오른쪽으로 이동한다면
        int move = name.length() - 1;

        for (int i = 0; i < name.length(); i++) {
            // 일단 지금 자리 변경
            answer += Math.min(name.charAt(i)-'A', 26 - (name.charAt(i)-'A'));

            // 다음 위치부터 연속된 A가 있는 경우 되돌아가는게 빠른지 확인
            int nextIdx = i+1;
            while (nextIdx < name.length() && name.charAt(nextIdx) == 'A'){
                nextIdx++;
            }

            // 오른쪽으로 갔다가 반대쪽으로 돌아가기
            move = Math.min(move, 2 * i + name.length() - nextIdx);
            // 왼쪽으로 갔다가 오른쪽으로 돌아가기
            move = Math.min(move, (name.length() - nextIdx)*2 + i);
        }
        

        return answer + move;
    }

    private static int solution(String name) {
        int answer = 0;
        char[] nameArr = name.toCharArray();

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < name.length(); i++) {
            if (nameArr[i] != 'A')
                list.add(i);
        }

//        일단 지금 위치와 가장 가까운 놈부터 바꾸자
        int now = 0;
        int next = 0;
        while (!list.isEmpty()){
            int dist = name.length();
            for (int i = 0; i < list.size(); i++) {
                int k = list.get(i);
                if (k-now < dist){
                    next = i;
                    dist = k-now;
                }
                if (name.length()-k < dist){
                    next = i;
                    dist = name.length()-k;
                }
            }

            // 다음 이동 장소 next
            Integer remove = list.remove(next);
            now = remove;
            // 옮기는 횟수 dist
            answer += dist;

            // 알파벳 변경
            answer += Math.min(Math.abs(nameArr[now]-'A'), Math.abs(26-(nameArr[now]-'A')));

        }

        return answer;
    }
}
