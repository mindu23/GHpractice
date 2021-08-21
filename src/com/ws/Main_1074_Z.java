package com.ws;

import java.util.Scanner;

/**
	r행 c열을 몇번째로 방문했는지
 */
public class Main_1074_Z {

	static int N, r, c, nub;
	static int[][] arr;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		r = sc.nextInt();
		c = sc.nextInt();
		
		int a = (int) Math.pow(2, N);
		arr = new int[a][a];
		
		visit(0,0,N);

		sc.close();
	}
	
	private static void visit(int row, int col, int size) {
		
		if(size == 2)
		
		//1
		if(row < size/2 && size )
		
		//2	
			
			
		//3
			
		//4
		visit(row,col,size/2);
		visit(row,col+size/2,size/2);
		visit(row+size/2,col,size/2);
		visit(row+size/2,col+size/2,size/2);
		
	}

}
