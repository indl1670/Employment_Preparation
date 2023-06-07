package Algo_0607;

import java.io.*;
import java.util.*;

public class SWEA6808_규영이와인영이의카드게임 {
    static int T, win, lose;
    static int[] card1, card2, selected;
    static boolean[] cards, v;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            // 초기화
            card1 = new int[9];
            card2 = new int[9];
            selected = new int[9];
            cards = new boolean[19];
            v = new boolean[9];
            win = lose = 0;
            
            // 규영이 카드정보
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < 9; i++) {
                int num = Integer.parseInt(st.nextToken());
                card1[i] = num;
                cards[num] = true;
            }

            // 인영이 카드정보
            int idx = 0;
            for (int i = 1; i <= 18; i++) {
                if (!cards[i]) card2[idx++] = i;
            }
            
            perm(0);
            System.out.println("#" + tc + " " + win + " " + lose);
        }
    }
    static void perm(int depth) {
        // 기저조건
        if (depth == 9) {
            // 이겼을때 카드 합, 졌을때 카드 합
            int winSum = 0, loseSum = 0;
            for (int i = 0; i < 9; i++) {
                if (card1[i] > selected[i]) winSum += card1[i] + selected[i];
                else loseSum += card1[i] + selected[i];
            }
            
            if (winSum > loseSum) win++;
            else lose++;
            return;
        }

        for (int i = 0; i < 9; i++) {
            if (v[i]) continue; // 이미 선택된 카드일 경우 패스

            // 카드 선택
            v[i] = true;
            selected[depth] = card2[i];
            perm(depth+1);
            // 선택 되돌리기
            v[i] = false;
        }
    }
}