package Algo_0524;

import java.io.*;
import java.util.*;

public class Permutation {
    // nPr
    static int N, R, cnt, cnt2;
    static int[] tmp;
    static boolean[] v;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        R = Integer.parseInt(br.readLine());
        cnt = 0;
        cnt2 = 0;

        tmp = new int[R];
        v = new boolean[N];

        perm(0); // 순열
        dup_perm(0); // 중복순열
        System.out.println("순열 총 경우의 수: " + cnt);
        System.out.println("중복순열 총 경우의 수: " + cnt2);
    }
    // 순열
    static void perm(int depth) {
        // 기저 조건
        // R개를 뽑은 경우 종료
        if (depth == R) {
            cnt++;
            return;
        }

        for (int i = 0; i < N; i++) {
            // 선택여부 판단
            if (v[i]) continue;
            // 앞쪽에서 선택되지 않았을 경우 선택
            tmp[depth] = i;
            v[i] = true;
            // 다음 수 뽑으러 가기
            perm(depth+1);
            // 선택된 수 되돌림
            v[i] = false;
        }
    }
    // 중복순열 - 방문 여부 확인 X
    static void dup_perm(int depth) {
        // 기저조건
        if (depth == R) {
            cnt2++;
            return;
        }
        for (int i = 0; i < N; i++) {
            tmp[depth] = i;
            dup_perm(depth+1);
        }
    }
}
