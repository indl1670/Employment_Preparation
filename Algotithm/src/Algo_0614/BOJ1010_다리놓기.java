package Algo_0614;

import java.io.*;
import java.util.*;

public class BOJ1010_다리놓기 {
    static int T, N, M, ans;
    static int[][] memoi;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        T = Integer.parseInt(br.readLine());

        for (int tc = 0; tc < T; tc++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            memoi = new int[M+1][N+1];

            System.out.println(comb(M, N));
        }
    }
    static int comb(int src, int tgt) {
        // 기저조건
        if (memoi[src][tgt] != 0) return memoi[src][tgt];

        // 전체 선택 OR 전체 미선택
        if (src == tgt || tgt == 0) return memoi[src][tgt] = 1;

        // 7C4 = 6C3 + 6C4
        return memoi[src][tgt] = comb(src-1, tgt-1) + comb(src-1, tgt);
    }
}
