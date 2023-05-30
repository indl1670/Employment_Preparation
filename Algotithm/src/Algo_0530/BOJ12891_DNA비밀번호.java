package Algo_0530;

import java.io.*;
import java.util.*;

public class BOJ12891_DNA비밀번호 {
    static int S, P, A, C, G, T, cnt;
    static char[] password;
    static int[] condition;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        S = Integer.parseInt(st.nextToken()); // DNA 문자열 길이
        P = Integer.parseInt(st.nextToken()); // 부분문자열 길이
        A = C = G = T = cnt = 0;

        password = new char[S];
        condition = new int[4];

        // DNA 비밀번호
        password = br.readLine().toCharArray();

        // 비밀번호 유효성 조건
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            condition[i] = Integer.parseInt(st.nextToken());
        }
        solve();
        System.out.println(cnt);
    }
    static void solve() {
        for (int i = 0; i < P; i++) {
            if (password[i] == 'A') A++;
            else if (password[i] == 'C') C++;
            else if (password[i] == 'G') G++;
            else if (password[i] == 'T') T++;
        }

        check();

        for (int i = P; i < S; i++) {
            // 오래된 문자 제거
            if (password[i-P] == 'A') A--;
            else if (password[i-P] == 'C') C--;
            else if (password[i-P] == 'G') G--;
            else if (password[i-P] == 'T') T--;

            // 신규 문자 판단
            if (password[i] == 'A') A++;
            else if (password[i] == 'C') C++;
            else if (password[i] == 'G') G++;
            else if (password[i] == 'T') T++;

            check();
        }
    }
    static void check() {
        if (A >= condition[0] && C >= condition[1] && G >= condition[2] && T >= condition[3]) {
            cnt++;
        }
    }
}
