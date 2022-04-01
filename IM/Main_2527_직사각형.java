package com.IM;

import java.io.IOException;
import java.util.Scanner;

public class Main_2527_직사각형 {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		for(int t = 0; t < 4; t++) {
			int x1 = sc.nextInt();
			int y1 = sc.nextInt();
			int p1 = sc.nextInt();
			int q1 = sc.nextInt();
			int x2 = sc.nextInt();
			int y2 = sc.nextInt();
			int p2 = sc.nextInt();
			int q2 = sc.nextInt();
			
			//점 / 선 / 안겹침
			if((p1 == x2 && q1 == y2) || (p2 == x1 && y2 == q1) || (p1 == x2 && y1 == q2) || (x1 == p2 && y1 == q2)) {
				System.out.println("c");
			}else if (q1 == y2 || y1 == q2 || p1 == x2 || p2 == x1) {
				System.out.println("b");
			}else if(p1 < x2 || p2 < x1 || q1 < y2 || q2 < y1) {
				System.out.println("d");
			}else {
				System.out.println("a");
			}
			
		}
		sc.close();
	}

}
