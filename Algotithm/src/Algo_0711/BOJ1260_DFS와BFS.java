package Algo_0711;

import java.io.*;
import java.util.*;

public class BOJ1260_DFS와BFS {
    static StringBuilder sb = new StringBuilder();
    static int N, M, V;
    static ArrayList<ArrayList<Integer>> matrix = new ArrayList<ArrayList<Integer>>();
    static boolean[] v;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // 정점의 개수
        M = Integer.parseInt(st.nextToken()); // 간선의 개수
        V = Integer.parseInt(st.nextToken()); // 시작 정점 번호

        for (int i = 0; i <= N; i++) {
            matrix.add(new ArrayList<Integer>());
        }
        v = new boolean[N+1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            matrix.get(from).add(to);
            matrix.get(to).add(from);
        }

        for (int i = 0; i < matrix.size(); i++) {
            Collections.sort(matrix.get(i));
        }

        v[V] = true;
        dfs(V);
        sb.setCharAt(sb.length() - 1, '\n');

        v = new boolean[N+1];
        bfs();
        sb.setCharAt(sb.length() - 1, '\n');

        System.out.println(sb.toString());
    }
    static void bfs() {
        v[V] = true;
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(V);

        while (!q.isEmpty()) {
            int num = q.poll();
            sb.append(num).append(" ");
            for (int i = 0; i < matrix.get(num).size(); i++) {
                int vertex = matrix.get(num).get(i);
                if (v[vertex]) continue;
                v[vertex] = true;
                q.offer(vertex);
            }
        }
    }
    static void dfs(int start) {
        sb.append(start).append(" ");

        for (int i = 0; i < matrix.get(start).size(); i++) {
            int vertex = matrix.get(start).get(i);
            if (v[vertex]) continue;
            v[vertex] = true;
            dfs(vertex);
        }
    }
}
