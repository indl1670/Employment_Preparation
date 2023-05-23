package Algo_0522;

import java.io.*;
import java.util.*;

public class SWEA1208_Flatten {
	static int dumps; // 덤프 횟수
	static int[] boxes;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		// 테스트 케이스 10개
		for (int tc = 1; tc <= 10; tc++) {
			dumps = Integer.parseInt(br.readLine());
			boxes = new int[100];
			
			st = new StringTokenizer(br.readLine());
			// 상자 초기화
			for (int i = 0; i < 100; i++) {
				boxes[i] = Integer.parseInt(st.nextToken());
			}
			
			Dump(0); // 평탄화
			
			System.out.println("#" + tc + " " + (boxes[99] - boxes[0]));
		}
	}
	static void Dump(int n) {
		Arrays.sort(boxes); // 상자 높이 배열 정렬
		
		// 기저조건
		// 덤프 횟수 종료 or 최저높이 == 최고높이
		if (n == dumps || boxes[0] == boxes[99]) return;
		
		// 평탄화
		boxes[0]++;
		boxes[99]--;
		
		// 덤프 횟수 소진시까지 반복
		Dump(++n);
	}
}
