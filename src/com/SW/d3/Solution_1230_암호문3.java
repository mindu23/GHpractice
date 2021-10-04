package com.SW.d3;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Scanner;

public class Solution_1230_암호문3 {

	static LinkedList<String> list;
	static int N, commandCnt;
	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("src//inputFile//input_1230.txt"));
		Scanner sc = new Scanner(System.in);
		
		for(int t = 1; t <= 10; t++) {
			N = sc.nextInt();
			list = new LinkedList<>();
			list.clear();
			for(int i = 0; i < N; i++) {
				list.add(sc.next());
			}
			
			int x, y;
			String[] s;
			commandCnt = sc.nextInt();
			for(int i = 0; i < commandCnt; i++) {
				switch(sc.next()) {
				case "I":
					x = sc.nextInt();
					y = sc.nextInt();
					s = new String[y];
					for(int j = 0; j < y; j++) {
						s[j] = sc.next();
					}
					Insert(x, y, s);
					break;
				case "D":
					x = sc.nextInt();
					y = sc.nextInt();
					Delete(x, y);
					break;
				case "A":
					y = sc.nextInt();
					s = new String[y];
					for(int j = 0; j < y; j++) {
						s[j] = sc.next();
					}
					Add(y, s);
					break;
				}
			}
			System.out.print("#"+t+" ");
			for(int i = 0; i < 10; i++) {
				System.out.print(list.get(i)+" ");
			}
			System.out.println();
		}
	}
	private static void Add(int y, String[] s) {
		for(int i = 0; i < y; i++) {
			list.add(s[i]);
		}
	}
	
	private static void Delete(int x, int y) {
		for(int i = 0; i < y; i++) {
			list.remove(x);
		}
	}
	private static void Insert(int x, int y, String[] s) {
		for(int i = x, j = 0; i < x+y; i++) {
			list.add(i, s[j++]);
		}
	}

}
