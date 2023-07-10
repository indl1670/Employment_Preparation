package Algo_0710;

import java.io.*;
import java.util.*;

public class BOJ15683_감시 {
    static int N, M, cnt, ans;
    static int[][] office, copy;
    static int[] select;
    // 방향 | 상 - 우 - 하 - 좌
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};
    static List<CCTV> cctv = new ArrayList<>();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // 세로 크기(행)
        M = Integer.parseInt(st.nextToken()); // 가로 크기(열)
        office = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                int item = Integer.parseInt(st.nextToken());

                office[i][j] = item;

                // CCTV 정보 저장(종류, 위치)
                if (item != 0 && item != 6) {
                    cctv.add(new CCTV(item, i, j));
                }
            }
        }

        cnt = cctv.size(); // cctv 총 개수
        select = new int[cnt]; // 선택한 cctv 정보
        ans = Integer.MAX_VALUE;

        perm(0);
        System.out.println(ans);
    }
    static void perm(int depth) {
        if (depth == cnt) {
            // 기저조건 - 전체 CCTV 방향 설정 완료
            // 사각지대 확인 배열
            copy = new int[N][M];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    copy[i][j] = office[i][j];
                }
            }

            // 방향 설정
            for (int i = 0; i < cnt; i++) {
                setDirection(cctv.get(i), select[i]);
            }
            
            // 사각지대 개수 구하기
            int sum = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (copy[i][j] == 0) { // 사각지대일 경우 개수 증가
                        sum++;
                    }
                }
            }
            ans = Integer.min(ans, sum);
            return;
        }

        for (int i = 0; i < 4; i++) {
            select[depth] = i; // 방향 설정
            perm(depth+1);
        }
    }
    static void setDirection(CCTV cctv, int dir) {
        int num = cctv.num; // CCTV 종류

        switch (num) {
            case 1: // 단방향
                if (dir == 0) check(cctv, 0);
                else if (dir == 1) check(cctv, 1);
                else if (dir == 2) check(cctv, 2);
                else if (dir == 3) check(cctv, 3);
                break;
            case 2: // 양방향(반대)
                if (dir == 0 || dir == 2) {
                    check(cctv, 0);
                    check(cctv, 2);
                } else {
                    check(cctv, 1);
                    check(cctv, 3);
                }
                break;
            case 3: // 양방향(직각)
                if (dir == 0) {
                    check(cctv, 0);
                    check(cctv, 1);
                }
                else if (dir == 1) {
                    check(cctv, 1);
                    check(cctv, 2);
                }
                else if (dir == 2) {
                    check(cctv, 2);
                    check(cctv, 3);
                }
                else if (dir == 3) {
                    check(cctv, 3);
                    check(cctv, 0);
                }
                break;
            case 4: // 3방향
                if (dir == 0) {
                    check(cctv, 0);
                    check(cctv, 1);
                    check(cctv, 3);
                }
                else if (dir == 1) {
                    check(cctv, 0);
                    check(cctv, 1);
                    check(cctv, 2);
                }
                else if (dir == 2) {
                    check(cctv, 1);
                    check(cctv, 2);
                    check(cctv, 3);
                }
                else if (dir == 3) {
                    check(cctv, 0);
                    check(cctv, 2);
                    check(cctv, 3);
                }
                break;
            case 5: // 4방향
                check(cctv, 0);
                check(cctv, 1);
                check(cctv, 2);
                check(cctv, 3);
                break;
            default:
                break;
        }
    }
    static void check(CCTV cctv, int dir) {
        Queue<CCTV> q = new ArrayDeque<>();
        q.offer(cctv);

        while(!q.isEmpty()) {
            CCTV tv = q.poll();

            int nr = tv.r + dr[dir];
            int nc = tv.c + dc[dir];

            // 경계에 닿거나 벽을 만나면 종료
            if (nr < 0 || nc < 0 || nr >= N || nc >= M || copy[nr][nc] == 6) break;
            
            if (copy[nr][nc] == 0) { // 갑시 가능한 영역일 경우
                copy[nr][nc] = -1; // 감시 확인 영역
                q.offer(new CCTV(cctv.num, nr, nc));
            } else { // 이미 감시한 영역일 경우
                q.offer(new CCTV(cctv.num, nr, nc));
            }
        }
    }
    static class CCTV {
        int num, r, c;
        public CCTV(int num, int r, int c) {
            this.num = num;
            this.r = r;
            this.c = c;
        }
    }
}
