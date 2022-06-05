package Class2;

import java.util.Scanner;

public class Main_1085_직사각형에서탈출 {

    static int x, y, w, h;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        x = sc.nextInt();
        y = sc.nextInt();
        w = sc.nextInt();
        h = sc.nextInt();

        int minW = Math.min(x, w-x);
        int minH = Math.min(y, h-y);
        System.out.println(Math.min(minH,minW));
    }
}
