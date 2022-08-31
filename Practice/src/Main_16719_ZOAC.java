import java.io.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

public class Main_16719_ZOAC {

    static boolean[] show;
    static char[] str;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        str = br.readLine().toCharArray();
        show = new boolean[str.length];
        int left = 0, right = str.length;
        findNext(left, right);
    }

    private static void findNext(int left, int right) {
        if (left >= str.length) return;

        char min = str[left];
        int minIdx = left;
        for (int i = left; i < right; i++) {
            if (show[i]) continue;
            if (str[i] < min){
                min = str[i];
                minIdx = i;
            }
        }

        show[minIdx] = true;

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length; i++) {
            if (show[i]) sb.append(str[i]);
        }
        System.out.println(sb.toString());

        findNext(minIdx+1, str.length);
        findNext(0, minIdx);
    }

}
