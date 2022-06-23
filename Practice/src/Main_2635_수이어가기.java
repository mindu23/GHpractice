import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main_2635_수이어가기 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        List<Integer> list = new ArrayList<>();
        int maxLen = 0;

        for (int i = N; i > N/2; i--) {
            List<Integer> temp = new ArrayList<>();
            int j = 2;
            temp.add(N);
            temp.add(i);
            while(true){
                int k = temp.get(j-2)-temp.get(j-1);
                if (k < 0) break;
                temp.add(k);
                j++;
            }
            if (temp.size() > maxLen){
                list = temp;
                maxLen = temp.size();
            }
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(list.size()+"\n");
        for (int i = 0; i < list.size(); i++) {
            bw.write(String.valueOf(list.get(i)));
            if (i != list.size()-1) bw.write(" ");
        }
        bw.flush();
    }
}
