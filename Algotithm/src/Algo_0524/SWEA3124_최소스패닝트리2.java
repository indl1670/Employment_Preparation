package Algo_0524;

import java.io.*;
import java.util.*;

// PRIM
public class SWEA3124_최소스패닝트리2 {
    static int T, V, E;
    static long sum;
    static boolean[] v;
    static ArrayList<ArrayList<Edges>> edge;
    static PriorityQueue<Edges> pq = new PriorityQueue<>((e1, e2) -> e1.weight - e2.weight);

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            st = new StringTokenizer(br.readLine());
            V = Integer.parseInt(st.nextToken());
            E = Integer.parseInt(st.nextToken());

            // 초기화
            edge = new ArrayList<>();
            for (int i = 0; i <= V; i++) {
                edge.add(new ArrayList<>());
            }
            v = new boolean[V+1];
            sum = 0;
            pq.clear();

            for (int i = 0; i < E; i++) {
                st = new StringTokenizer(br.readLine());
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());
                int weight = Integer.parseInt(st.nextToken());

                edge.get(from).add(new Edges(to, weight));
                edge.get(to).add(new Edges(from, weight));
            }

            prim();
            System.out.println("#" + tc + " " + sum);
        }
    }
    static void prim() {
        int cnt = 1;
        v[1] = true;

        pq.addAll(edge.get(1));
        while (!pq.isEmpty()) {
            Edges e = pq.poll();
            if (v[e.to]) continue;
            v[e.to] = true;
            sum += e.weight;
            cnt++;

            if (cnt == V) break;
            pq.addAll(edge.get(e.to));
        }
    }
    static class Edges {
        int to, weight;
        public Edges(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }
}
