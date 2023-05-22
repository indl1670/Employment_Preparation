package algorithm_0522;

import java.io.*;
import java.util.*;

public class BOJ1244_스위치켜고끄기 {
	static int cnt, students, gender, number;
	static int[] switches;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		cnt = Integer.parseInt(br.readLine()); // 스위치 개수
		switches = new int[cnt+1]; // 스위치
		
		// 스위치 초기 설정
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= cnt; i++) {
			switches[i] = Integer.parseInt(st.nextToken());
		}
		
		students = Integer.parseInt(br.readLine()); // 학생 수
		for (int i = 0; i < students; i++) {
			st = new StringTokenizer(br.readLine());
			gender = Integer.parseInt(st.nextToken()); // 성별
			number = Integer.parseInt(st.nextToken()); // 받은 숫자

			if (gender == 1) { // 남학생
				genderMale();
			} else { // 여학생
				genderFemale();
			}
		}
		
		for (int i = 1; i <= cnt; i++) {
			System.out.print(switches[i] + " ");
			if (i%20 == 0) System.out.println();
		}
	}
	// 남학생 - 배수 전환
	static void genderMale() {
		for (int i = number; i <= cnt; i+=number) { // 받은 수의 배수에 해당하는 스위치 전환
			switches[i] = switches[i] == 0 ? 1 : 0;
		}
	}
	// 여학생 - 좌우대칭 전환
	static void genderFemale() {
		// 현재 번호 스위치 전환
		switches[number] = switches[number] == 0 ? 1 : 0;
		
		int left = number-1;
		int right = number+1;
		
		while (left >= 1 && right <= cnt) {
			if (switches[left] == switches[right]) { // 좌우대칭일 경우
				switches[left] = switches[right] = switches[left] == 0 ? 1 : 0; // 스위치 전환
			} else break;
			// 대칭된 최대 스위치 전환
			left--;
			right++;
		}
	}
}
