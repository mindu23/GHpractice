import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class W_3986_좋은단어 {

    static int ans;
    static boolean isWord;
    static Stack<Character> stack;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        ans = 0;

        for (int i = 0; i < N; i++) {
            stack = new Stack<>();
            char[] word = br.readLine().toCharArray();
            for (int j = 0; j < word.length; j++) {
                if(stack.isEmpty()) stack.push(word[j]);
                else{
                    Character c = stack.peek();
                    if(word[j] == c) stack.pop();
                    else stack.push(word[j]);
                }
            }

            if (stack.isEmpty()) ans++;
        }

        System.out.println(ans);
    }

}
