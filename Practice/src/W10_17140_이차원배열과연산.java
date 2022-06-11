import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
    이차원 배열
    R 연산: 배열의 모든 행에 대해서 정렬 수행. 행의 개수 >= 열의 개수. 세로로 긴 사각형, 정사각형
    C 연산: 배열의 모든 열에 대해서 정렬을 수행. 행의 개수 < 열의 개수. 가로로 긴 사각형

    한 행 또는 열에 있는 수를 정렬하려면, 각각의 수가 몇 번 나왔는지 알아야 한다. 그 다음, 수의 등장 횟수가 커지는 순으로.(등장 횟수가 같으면 수가 커지는 순으로 정렬) 오름차순
    정렬한 값을 다시 배열에 넣어야 한다.
    정렬된 결과를 배열에 넣을 때는, 수와 등장 횟수를 모두 넣는다. (수, 수의 등장 횟수)

    ex) 3,1,1 -> [3,1][1,2] -> 3,1,1,2
    ex) 3,1,1,2 -> [2,1][3,1][1,2] -> 2,1,3,1,1,2

    R 연산을 적용한 경우, 가장 큰 행을 기준으로 모든 행의 크기 변한다.
    C 연산을 적용한 경우, 가장 큰 열을 기준으로 모든 열의 크기가 변한다.
    추가된 열, 행에는 0이 채워진다.
    수를 정렬할 때는 0 무시

    ex) 3,2,0,0 -> 2,1,3,1 == 3,2 -> 2,1,3,1

    행 또는 열의 크기가 100을 넘어가는 경우, 100개까지 자른다.
    A[r][c] == k가 되기 위한 최소 시간 구하기
 */
public class W10_17140_이차원배열과연산 {

    static class E implements Comparable<E>{
        private int n;
        private int cnt;

        public E(int n, int cnt) {
            this.n = n;
            this.cnt = cnt;
        }

        @Override
        public int compareTo(E o) {
            if (this.cnt == o.cnt){
                return Integer.compare(this.n, o.n);
            }
            return Integer.compare(this.cnt, o.cnt);
        }
    }

    static int r, c, k;
    static int[][] A;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken())-1;
        c = Integer.parseInt(st.nextToken())-1;
        k = Integer.parseInt(st.nextToken());
        A = new int[3][3];

        for (int i = 0; i < 3; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                A[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        solution(0);
    }

//    R 연산: 배열의 모든 행에 대해서 정렬 수행. 행의 개수 >= 열의 개수.
//    C 연산: 배열의 모든 열에 대해서 정렬을 수행. 행의 개수 < 열의 개수.

    private static void solution(int time) {
        if (time > 100) {
            System.out.println(-1);
            return ;
        }
        if(check(time)) return ;

        if(A.length >= A[0].length){
            sortR();
        }else{
//            sortC();
        }
    }

    private static void sortR() {
        int[][] temp = new int[A.length][A[0].length*2];
        for (int i = 0; i < A.length; i++) {
            HashMap<Integer, Integer> hm = new HashMap<>();
            for (int j = 0; j < A[0].length; j++) {
                // 해당 키가 존재하면 개수 증가
                if(hm.containsKey(A[i][j])) hm.replace(A[i][j], hm.get(A[i][j])+1);
                // 해당 키가 없으면 개수 1 삽입
                else hm.put(A[i][j], 1);
            }
            LinkedList<E> eList = new LinkedList<>();
            hm.forEach((integer, integer2) -> eList.add(new E(integer, integer2)));
            Collections.sort(eList);

            int[] sortedList = new int[A[0].length];
            Arrays.fill(sortedList, 0);
            int k = 0;
            for (int j = 0; j < eList.size(); j++) {
                sortedList[k++] = eList.get(j).n;
                sortedList[k++] = eList.get(j).cnt;
            }
            temp[i] = sortedList;
        }
    }

    private static boolean check(int time) {
        if(A.length >= r && A[0].length >= c){
            if (A[r][c] == k) {
                System.out.println(time);
                return true;
            }
            else return false;
        }else
            return false;
    }
}
