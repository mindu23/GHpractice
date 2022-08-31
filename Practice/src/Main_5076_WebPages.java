import java.io.*;
import java.util.Stack;

public class Main_5076_WebPages {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while (true){
            boolean ok = true;
            Stack<String> stack = new Stack<>();
            String str = br.readLine();
            if (str.equals("#")) break;
            if (!str.contains("<") && !str.contains(">")) {
                bw.write("legal\n");
                continue;
            }
            String[] s1 = str.split(">");
            for (String s : s1) {
                String[] s2 = s.split("<");
                String html = s2[s2.length-1];
                if (html.charAt(0)=='/'){
                    if (stack.isEmpty()) {
                        bw.write("illegal\n");
                        ok = false;
                        break;
                    }
                    if (!stack.pop().equals(html.replace("/", "").split(" ")[0])) break;
                }else {
                    stack.push(html.replace("/",""));
                }
            }

            if (!ok) continue;

            if (stack.isEmpty()) bw.write("legal\n");
            else bw.write("illegal\n");
        }

        bw.flush();
    }
}
