package Algo_0714;

import java.io.*;
import java.util.*;

public class SWEA3234_준환이의양팔저울 {
    static int ans;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            int N = Integer.parseInt(br.readLine());
            int[] weights = new int[N];
            boolean[] v = new boolean[N];

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                weights[i] = Integer.parseInt(st.nextToken());
            }

            ans = 0;
            perm(weights, v, 0, 0, 0, N);
            System.out.println("#" + tc + " " + ans);
        }
    }
    static void perm(int[] weights, boolean[] v, int depth, int left, int right, int N) {
        if (depth == N) {
            ans++;
            return;
        }

        for (int i = 0; i < N; i++) {
            if (v[i]) continue;
            v[i] = true;
            int w = weights[i];

            // 선택된 무게 왼쪽으로
            perm(weights, v, depth+1, left+w, right, N);
            // 왼쪽 무게가 선택된 무게 + 오른쪽보다 크거나 같을 경우 오른쪽으로
            if (left >= right+w) perm(weights, v, depth+1, left, right+w, N);
            v[i] = false;
        }
    }
}
