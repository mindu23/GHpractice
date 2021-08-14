package com.ssafy.d2;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution_1873_상호의배틀필드 {

	static int H, W, N;
	static int[] dr = {-1,1,0,0}, dc = {0,0,-1,1}; //상하좌우
	static int tr, tc, tDir; // tank의 위치 방향
	static char[][] map;
	static char[] command;
	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("src//inputFile//input_1873.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for(int t = 1; t <= T; t++) {
			String[] str = br.readLine().split(" ");
			H = Integer.parseInt(str[0]);
			W = Integer.parseInt(str[1]);
			map = new char[H][W];
			for(int h = 0; h < H; h++) {
				map[h] = br.readLine().toCharArray(); 
			}
			
			getTankPosition();
			N = Integer.parseInt(br.readLine());
			command = new char[N];
			command = br.readLine().toCharArray();
			for(char c : command) {
				switch(c) {
				case 'S':
					shoot();
					break;
				default:
					move(c);
					break;
				}
			}
			
			System.out.print("#"+t+" ");
			for(int i = 0; i < H; i++) {
				for(int j = 0; j < W; j++) {
					System.out.print(map[i][j]);
				}
				System.out.println();
			}
		}
	}
	
	private static void move(char command) {
		//일단 방향은 무조건 바뀐다.
		tDir = "UDLR".indexOf(command);
		map[tr][tc] = "^v<>".charAt(tDir);
		//움직이자
		int nr = tr + dr[tDir]; //이동
		int nc = tc + dc[tDir];
		if(nr < 0 || nr >= H || nc < 0 || nc >= W || map[nr][nc] == '#' || map[nr][nc] == '-' || map[nr][nc] == '*') return; //범위를 벗어나면 취소
		if(map[nr][nc] == '.') {
			map[tr][tc] = '.';
			tr = nr;
			tc = nc;
			map[tr][tc] = "^v<>".charAt(tDir);
		}
		nr = tr + dr[tDir];
		nc = tc + dc[tDir];
		
	}
	
	private static void shoot() { // tr,tc좌표에서 Tdir이 가리는 방향으로 포탄 발사
		int nr = tr + dr[tDir];
		int nc = tc + dc[tDir];
		while(true) {
			if(nr < 0 || nr >= H || nc < 0 || nc >= W || map[nr][nc] == '#') return; //범위를 벗어나면 취소
			switch(map[nr][nc]) {
			case '.':
			case '-': 
				break;
			case '*':
				map[nr][nc] = '.';
				return;
			}
			nr += dr[tDir];
			nc += dc[tDir];
		}
	}
	
	private static void getTankPosition() {
		for(int i = 0; i < H; i++) {
			for(int j = 0; j < W; j++) {
				int dir = "^v<>".indexOf(map[i][j]);
				if(dir != -1) {
					tr = i;
					tc = j;
					tDir = dir;
				}
			}
		}
	}
	

}
