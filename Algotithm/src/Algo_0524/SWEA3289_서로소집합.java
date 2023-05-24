package Algo_0524;

import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class SWEA3289_서로소집합 {
    static int T, N, M;
    static int[] parent;
    static StringBuilder sb;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            st = new StringTokenizer(br.readLine());

            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            // 초기화
            parent = new int[N+1];
            makeSet();
            sb = new StringBuilder("#").append(tc).append(" ");

            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int op = Integer.parseInt(st.nextToken());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());

                if (op == 0) { // 합집합
                    union(x, y);
                } else { // 포함관계 확인
                    if (findSet(x) == findSet(y)) sb.append(1);
                    else sb.append(0);
                }
            }

            System.out.println(sb.toString());
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
