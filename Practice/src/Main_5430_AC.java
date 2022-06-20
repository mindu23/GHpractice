import java.io.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main_5430_AC {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {

            char[] command = br.readLine().toCharArray();
            int n = Integer.parseInt(br.readLine());
            String array_st = br.readLine().replace(",", " ").replace("[","").replace("]", "");
            LinkedList<Integer> list = new LinkedList<>();
            boolean isReverse = false;

            try{
                int k = 0;

                StringTokenizer st = new StringTokenizer(array_st);
                while (st.hasMoreTokens()){
                    list.add(Integer.parseInt(st.nextToken()));
                }

                for (char c : command) {
                    if (c == 'R'){
                        isReverse = !isReverse;
                    }else {
                        if (list.isEmpty()) throw new Exception();
                        if (!isReverse) list.removeFirst();
                        else list.removeLast();
                    }
                }

                if (isReverse) Collections.reverse(list);
                bw.write(Arrays.toString(list.toArray()).replaceAll(" ","")+"\n");
            }catch (Exception e){
                bw.write("error\n");
            }

        }
        bw.flush();
    }
}
