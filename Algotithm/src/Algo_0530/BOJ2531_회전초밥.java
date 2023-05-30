package Algo_0530;

import java.io.*;
import java.util.*;

public class BOJ2531_회전초밥 {
    static int N, D, K, C, total, ans;
    static int[] sushi, dishes;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // 접시 수
        D = Integer.parseInt(st.nextToken()); // 초밥 가짓수
        K = Integer.parseInt(st.nextToken()); // 연속해서 먹는 접시 수
        C = Integer.parseInt(st.nextToken()); // 쿠폰 번호

        sushi = new int[N];
        dishes = new int[D+1];
        ans = 0; // 최대로 먹을 수 있는 초밥 종류
        total = 0; // 현재 먹어본 초밥 종류 수

        // 초밥 세팅
        for (int i = 0; i < N; i++) {
            sushi[i] = Integer.parseInt(br.readLine());
        }

        // 가짓수 세기
        for (int i = 0; i < K; i++) {
            // 먹어보지 못한 초밥 종류일 경우
            if (dishes[sushi[i]] == 0) {
                total++;
            }
            dishes[sushi[i]]++; // 초밥 먹음
        }

        ans = total;

        for (int i = 0; i < N; i++) {
            if (ans <= total) { // 최대갯수가 바뀔 경우
                if (dishes[C] == 0) { // 이벤트 초밥 확인
                    ans = total+1;
                } else ans = total;
            }

            // 가장 먼저 먹은 초밥 종류 제거
            // 한번만 먹은 경우 종류에서 제외
            if (dishes[sushi[i]] == 1) {
                total--;
            }
            dishes[sushi[i]]--;
            
            // 새로운 초밥 접시
            // 처음 먹은 경우 종류에서 추가
            if (dishes[sushi[(i+K)%N]] == 0) {
                total++;
            }
            dishes[sushi[(i+K)%N]]++;
        }
        System.out.println(ans);
    }
}
