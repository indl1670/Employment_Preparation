package Algo_0524;

import java.io.*;
import java.util.*;

public class SWEA7465_창용마을무리의개수 {
    static int T, N, M;
    static int[] parent;
    static boolean[] isParty;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken()); // 마을 사람 수
            M = Integer.parseInt(st.nextToken()); // 관계 수

            parent = new int[N+1];
            isParty = new boolean[N+1];
            int cnt = 0;

            makeSet();
            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());

                union(from, to);
            }

            for (int i = 1; i <= N; i++) {
                int p = findSet(i);
                if (!isParty[p]) {
                    isParty[p] = true;
                    cnt++;
                }
            }
            System.out.println("#" + tc + " " + cnt);
        }
    }
    static void makeSet() {
        for (int i = 1; i <= N; i++) {
            parent[i] = i;
        }
    }
    static int findSet(int x) {
        if (parent[x] == x) return x;
        else return parent[x] = findSet(parent[x]);
    }
    static void union(int x, int y) {
        int px = findSet(x);
        int py = findSet(y);
        if (px < py) parent[py] = px;
        else parent[px] = py;
    }
}
