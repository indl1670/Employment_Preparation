package Algo_0524;

import java.io.*;
import java.util.*;

// KRUSKAL
public class SWEA3124_최소스패닝트리 {
    static int T, V, E;
    static Edges[] edge;
    static int[] parent;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            st = new StringTokenizer(br.readLine());
            V = Integer.parseInt(st.nextToken()); // 정점 개수
            E = Integer.parseInt(st.nextToken()); // 간선 개수
            parent = new int[V+1];
            edge = new Edges[E];

            // 간선 가중치 정보 저장
            for (int i = 0; i < E; i++) {
                st = new StringTokenizer(br.readLine());
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());
                int weight = Integer.parseInt(st.nextToken());
                edge[i] = new Edges(from, to, weight);
            }

            // 가중치가 적은 순으로 정렬
            Arrays.sort(edge, (e1, e2) -> e1.weight - e2.weight);

            // 초기화
            makeSet();
            long sum = 0; // int 선언 시 Fail 뜸
            int cnt = 0;

            // Kruskal 알고리즘
            for (int i = 0; i < E; i++) {
                Edges e = edge[i];
                if (union(e.from, e.to)) { // Cycle이 안된 경우
                    cnt++;
                    sum += e.weight; // 가중치 증가
                }
                if (cnt == V-1) break; // 트리 생성 완료 => 중단
            }

            System.out.println("#" + tc + " " + sum);
        }
    }
    static void makeSet() {
        for (int i = 0; i < V; i++) {
            parent[i] = i;
        }
    }
    static int findSet(int x) {
        if (parent[x] == x) return x;
        return parent[x] = findSet(parent[x]);
    }
    static boolean union(int x, int y) {
        int px = findSet(x);
        int py = findSet(y);
        // Cycle 생성됨
        if (px == py) return false;
        // Cycle 생성 안됨
        parent[py] = px;
        return true;
    }
    static class Edges {
        int from, to, weight;
        public Edges(int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }
    }
}
