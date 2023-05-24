package Algo_0524;

import java.io.*;
import java.util.*;

public class Combination {
    // nCr
    static int N, R, cnt, cnt2;
    static int[] tmp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        R = Integer.parseInt(br.readLine());

        tmp = new int[R];
        cnt = cnt2 = 0;

        comb(0, 0);
        dup_comb(0, 0);
    }
    // 조합
    static void comb(int depth, int start) {
        // 기저조건
        if (depth == R) {
            cnt++;
            return;
        }

        for (int i = start; i < N; i++) {
            tmp[depth] = i;
            comb(depth + 1, i+1);
        }
    }
    // 중복조합
    static void dup_comb(int depth, int start) {
        // 기저조건
        if (depth == R) {
            cnt2++;
            return;
        }
        for (int i = start; i < N; i++) {
            tmp[depth] = i;
            dup_comb(depth+1, i);
        }
    }
}
