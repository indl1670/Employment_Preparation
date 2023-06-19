package Algo_0619;

import java.io.*;
import java.util.*;

public class BOJ1074_Z {
    static int N, r, c, ans = 0;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        int size = (int) Math.pow(2, N);

        Z(size, r, c);
        System.out.println(ans);
    }
    static void Z(int size, int r, int c) {
        if (size == 1) return;
        if (r < size/2 && c < size/2) { // 1사분면
            Z(size/2, r, c);
        } else if (r < size/2 && c >= size/2) { // 2사분면
            ans += size * size / 4;
            Z(size/2, r, c - size/2);
        } else if (r >= size/2 && c < size/2) { // 3사분면
            ans += (size * size / 4) * 2;
            Z(size/2, r - size/2, c);
        } else { // 4사분면
            ans += (size * size / 4) * 3;
            Z(size/2, r - size/2, c - size/2);
        }
    }
}
