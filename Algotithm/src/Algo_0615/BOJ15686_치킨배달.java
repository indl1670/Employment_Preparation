package Algo_0615;

import java.io.*;
import java.util.*;

public class BOJ15686_치킨배달 {
    static int N, M, ans;
    static List<int[]> house, chicken, select;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // 도시 정보
        M = Integer.parseInt(st.nextToken()); // 최소 치킨집
        house = new ArrayList<>();
        chicken = new ArrayList<>();
        select = new ArrayList<>();
        ans = Integer.MAX_VALUE;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int n = Integer.parseInt(st.nextToken());

                if (n == 1) house.add(new int[] {i, j});
                if (n == 2) chicken.add(new int[] {i, j});
            }
        }
        subs(0, 0);
        System.out.println(ans);
    }
    static void subs(int src, int tgt) {
        if (tgt == M) { // 치킨집 선택 완료
            int sum = 0; // 치킨거리 합
            int size = house.size();
            for (int i = 0; i < size; i++) {
                int dist = Integer.MAX_VALUE; // 집과 치킨집 사이 거리
                int[] h = house.get(i);
                for (int j = 0; j < M; j++) {
                    int[] c = select.get(j);
                    // 최소 거리 구하기
                    dist = Math.min(dist, Math.abs(h[0] - c[0]) + Math.abs(h[1] - c[1]));
                }
                sum += dist;
            }
            ans = Math.min(sum, ans);
            return;
        }

        // 치킨집 모두 선택
        if (src == chicken.size()) return;

        // 현재 치킨집 선택
        select.add(chicken.get(src));
        subs(src+1, tgt+1);
        // 현재 치킨집 미선택
        select.remove(chicken.get(src));
        subs(src+1, tgt);
    }
}
