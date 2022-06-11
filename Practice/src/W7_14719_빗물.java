import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class W7_14719_빗물 {

    static int H, W, wallH;
    static boolean[] wall;
    static int[] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        H = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        map = new int[W+1];
        wall = new boolean[W+1];


        st = new StringTokenizer(br.readLine());
        boolean anyWall = false;
        wallH = 0;
        for (int i = 1; i <= W; i++) {
            map[i] = Integer.parseInt(st.nextToken());
            // 벽이 한 번도 없을 때
            if(!anyWall && map[i] > wallH){
                wall[i] = true;
                wallH = map[i];
                anyWall = true;
            }
//            if(map[i] < wallH) continue;
            if(map[i] == wallH){
                wall[i] = true;
            }else if(map[i] > wallH){
                wall[i] = true;
                wallH = map[i];
            }
            // 한 번이라도 벽이 있고 끝일때
            if(anyWall && i == W && map[i] > 0){
                wall[i] = true;
            }
        }

        int ans = 0;
        int temp = 0;

        int isW = 0;
        wallH = 0;
        int start = 0;
        int end = 0;
        for (int i = 1; i <= W; i++) {
            if(wall[i]) {
                wallH = map[i];
                isW++;
                continue;
            }
            if(isW == 1 && wall[i]){
                end = i;

            }

            temp += wallH-map[i];

        }
    }
}
