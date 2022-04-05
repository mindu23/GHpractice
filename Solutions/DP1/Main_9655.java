package DP1;

import java.util.Scanner;

public class Main_9655 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        String answer = "";
        if(N%2==0) answer = "CY";
        else answer = "SK";

        System.out.println(answer);
    }
}
