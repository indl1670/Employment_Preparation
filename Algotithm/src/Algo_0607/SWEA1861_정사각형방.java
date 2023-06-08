package Algo_0607;

import java.io.*;
import java.util.*;

public class SWEA1861_정사각형방 {
    static int T, N, start, move;
    static int[][] room;
    static boolean[][] v;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static Queue<Node> q = new ArrayDeque<>();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            // 초기화
            N = Integer.parseInt(br.readLine());
            room = new int[N][N];
            start = 0; // 처음 출발하는 방 번호
            move = 1; // 이동가능한 최대 개수
            q.clear();

            // 방 설정
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    room[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    bfs(i, j);
                }
            }
            System.out.println("#" + tc + " " + start + " "  + move);
        }
    }
    static void bfs(int r, int c) {
        q.add(new Node(r, c, room[r][c], 1));

        while (!q.isEmpty()) {
            Node cur = q.poll();
            if (cur.cnt > move) {
                move = cur.cnt;
                start = cur.idx;
            } else if (cur.cnt == move) {
                start = Integer.min(start, cur.idx);
            }

            for (int d = 0; d < 4; d++) {
                int nr = cur.r + dr[d];
                int nc = cur.c + dc[d];

                if (nr < 0 || nc < 0 || nr >= N || nc >= N || room[cur.r][cur.c] + 1 != room[nr][nc]) continue;
                q.add(new Node(nr, nc, cur.idx, cur.cnt+1));
                break;
            }
        }
    }
    static class Node {
        int r, c, idx, cnt;
        public Node(int r, int c, int idx, int cnt) {
            this.r = r;
            this.c = c;
            this.idx = idx;
            this.cnt = cnt;
        }
    }
}
