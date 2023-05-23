package Algo_0523;

import java.io.*;
import java.util.*;

public class SWEA1238_Contact {
	static int len, start, maxDepth, maxNum;
	static boolean[][] people;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		for (int tc = 1; tc <= 10; tc++) {
			st = new StringTokenizer(br.readLine());
			len = Integer.parseInt(st.nextToken());
			start = Integer.parseInt(st.nextToken());
			maxDepth = 0;
			maxNum = 0;
			people = new boolean[101][101];
			
			// 연락망 초기화
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < len/2; i++) {
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				people[from][to] = true;
			}
			bfs();
			System.out.println("#" + tc + " " + maxNum);
			
		}
	}
	static void bfs() {
		Queue<Node> q = new ArrayDeque<>();
		people[start][0] = true;
		q.offer(new Node(start, 0));
		
		while (!q.isEmpty()) {
			Node node = q.poll();
			
			// 연락 depth가 깊어진 경우
			if (node.depth > maxDepth) {
				maxDepth = node.depth; // depth 갱신
				maxNum = node.num; // 번호 갱신
			} else if (node.depth == maxDepth) {
				maxNum = Math.max(maxNum, node.num); // 최대번호 갱신
			}
			
			// 저장된 연락망 전체 조회
			for (int i = 1; i < 101; i++) {
				
				// 연락망에 없는 경우 or 이미 연락을 취한상태 => continue
				if (!people[node.num][i] || people[i][0]) continue;
				people[i][0] = true; // 해당 번호 연락 완료
				q.offer(new Node(i, node.depth+1)); // depth 증가
			}
		}
	}
	static class Node {
		int num; // 깊이
		int depth; // 숫자
		
		public Node(int num, int depth) {
			this.depth = depth;
			this.num = num;
		}
	}

}
