package Algo_0524;

import java.io.*;
import java.util.*;

public class Subset {
    static int N, cnt;
    static int[] tmp;
    static boolean[] v;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        tmp = new int[N];
        v = new boolean[N];
        cnt = 0;

        for (int i = 0; i < N; i++) {
            tmp[i] = i;
        }
        subset(0);
        System.out.println(cnt);
    }
    static void subset(int depth) {
        // 기저조건
        if (depth == N) {
            for (int i = 0; i < N; i++) {
                System.out.print(v[i] ? tmp[i] : "X");
            }
            System.out.println();
            cnt++;
            return;
        }
        
        // 해당 숫자가 선택된 경우 / 선택되지 못한 경우
        v[depth] = true;
        subset(depth+1);
        
        v[depth] = false;
        subset(depth+1);
    }
}
