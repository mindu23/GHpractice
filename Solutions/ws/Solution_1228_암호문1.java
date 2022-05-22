package com.ws;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Scanner;

/**
	
 */
public class Solution_1228_암호문1 {

	static int N, cnt, x, y;
	static LinkedList<Integer> list;
	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("src//inputFile//input_1228.txt"));
		Scanner sc = new Scanner(System.in);

		for(int t = 1; t <= 10; t++) {
			N = sc.nextInt();
			list = new LinkedList<>();
			for(int i = 0; i < N; i++) {
				list.add(sc.nextInt());
			}//setting
			

			cnt = sc.nextInt();
			for(int j = 0; j < cnt; j++) {
				sc.next();
				x = sc.nextInt();
				y = sc.nextInt();
				
				for(int i = x; i < y+x; i++) {
					list.add(i, sc.nextInt());
				}
				
			}
			
			System.out.print("#"+t+" ");
			for(int i = 0; i < 10; i++) {
				System.out.print(list.get(i)+ " ");;
			}
			list.clear();
			System.out.println();
		}
		
		sc.close();
	}

}
