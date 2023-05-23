package Algo_0523;

import java.io.*;
import java.util.*;

public class BOJ13023_ABCDE {
    static int N, M;
    static boolean isDone;
    static ArrayList<ArrayList<Integer>> friends = new ArrayList<>();
    static boolean[] v;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 사람의 수
        M = Integer.parseInt(st.nextToken()); // 친구 관계의 수

        for (int i = 0; i < N; i++) {
            friends.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            friends.get(from).add(to);
            friends.get(to).add(from);
        }

        for (int i = 0; i < N; i++) {
            v = new boolean[N];
            dfs(i, 0);
            if (isDone) break;
        }
        System.out.println(isDone ? 1 : 0);
    }
    static void dfs(int start, int cnt) {
        if (cnt == 4) {
            isDone = true;
            return;
        }

        v[start] = true;
        for (int i:
             friends.get(start)) {
            if (isDone) return;
            if (!v[i]) dfs(i, cnt+1);
        }
        v[start] = false;
    }
}
