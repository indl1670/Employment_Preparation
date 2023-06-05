package Algo_0605;

import java.io.*;
import java.util.*;

public class SWEA1233_사칙연산유효성검사 {
    static int N, ans;
    static char[] node;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for (int tc = 1; tc <= 10; tc++) {
            N = Integer.parseInt(br.readLine());
            node = new char[N+1];
            ans = 1;

            // 유효성만 검사
            for (int i = 1; i <= N; i++) {
                node[i] = br.readLine().split(" ")[1].charAt(0);
            }

            while (N != 1) {
                if (!Character.isDigit(node[N]) || !Character.isDigit(node[N-1]) || Character.isDigit(node[N/2])) {
                    ans = 0;
                    break;
                }
                node[N/2] = '1';
                N -= 2;
            }
            System.out.println("#" + tc + " " + ans);
        }
    }
}
