package com.ws;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class Solution_1220_Magnetic {

	static int k, deadlock;
	static int[][] table;
	static boolean check;
	public static void main(String[] args) throws NumberFormatException, IOException {
		Scanner sc = new Scanner(System.in);
		
		for(int t = 1; t <= 10; t++) {
			k = sc.nextInt();
			table = new int[k][k];
			//setting
			
			for(int i = 0; i < k; i++) {
				for(int j = 0; j < k; j++) {
					table[i][j] = sc.nextInt();
				}
			}
			
			deadlock = 0;

			//생각을 잘하자. table을 움직일 필요는 없다.
			// 1 -> 2의 순서로 나왔을 때 deadlock이 하나 증가한다. 가운데 1은 많이 와도 된다.
			for(int i = 0; i < k; i++) {
				check = false;
				for(int j = 0; j < k; j++) {
					if(table[j][i] == 0) continue;
					if(!check && table[j][i] == 1) {
						check = true;
					}
					if(check && table[j][i] == 2) {
						deadlock++;
						check = false;
					}
				}
				
			}
			System.out.println("#"+t+" "+deadlock);
		}
		sc.close();
	}

}
