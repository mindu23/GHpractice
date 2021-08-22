package com.ws;

import java.util.Scanner;

/**
	r행 c열을 몇번째로 방문했는지
 */
public class Main_1074_Z {

	static int ans;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		visit((int) Math.pow(2, sc.nextInt()), sc.nextInt(), sc.nextInt());
		System.out.println(ans);
		sc.close();
	}
	
	private static void visit(int n, int r, int c) {
		
		if(n == 2) {
			int nr = r%n;
			int nc = c%n;
			if(nr == 0 && nc == 1) ans+=1;
			else if(nr == 1 && nc == 0) ans+=2;
			else if(nr == 1 && nc == 1) ans+=3;
			return ;
		}
		
		int newSize = n/2;
		int loc = 0;
		//1
		//2	
		if(r%n < newSize && c%n >= newSize) {
			loc = 1;
		}
			
		//3
		else if(r%n >= newSize && c%n < newSize) {
			loc = 2;
		}
			
		//4
		else if(r%n >= newSize && c%n >= newSize) {
			loc = 3;
		}
		long cnt = newSize*newSize;
		ans += loc * cnt;
		visit(newSize, r, c);
		
	}

}
