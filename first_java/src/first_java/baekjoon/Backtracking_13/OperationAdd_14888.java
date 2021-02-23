package first_java.baekjoon.Backtracking_13;

import java.util.*;
import java.io.*;

public class OperationAdd_14888 {
	public static int n;
	public static int[] arr;
	public static int[] oper = new int[4];
	public static int max = Integer.MIN_VALUE;
	public static int min = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());
		
		arr = new int[n];
		st = new StringTokenizer(br.readLine());
		
		for (int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		for (int i=0; i<4; i++) {
			oper[i] = Integer.parseInt(st.nextToken());
		}
		
		find(arr[0], 1);
		bw.write(String.valueOf(max));
		bw.newLine();
		bw.write(String.valueOf(min));
		bw.flush();

	}
	
	public static void find(int cur, int next) {
		if (next == n) {
			max = Math.max(cur, max);
			min = Math.min(cur, min);
			return;
		}
		
		for (int i=0; i<4; i++) {
			if (oper[i] > 0) {
				oper[i]--;
				
				switch (i) {
				
				case 0: find(cur + arr[next], next + 1);	break;
				case 1: find(cur - arr[next], next + 1);	break;
				case 2: find(cur * arr[next], next + 1);	break;
				case 3: find(cur / arr[next], next + 1);	break;
				}
				
				// if문 사용에서 'cur = cur + arr[next]' 방식 이용하면
				// cur값이 계속 바뀌기 때문에 결과가 다르게 나옴!!!!
//				if (i == 0) find(cur + arr[next], next + 1);
//				else if (i == 1) find(cur - arr[next], next + 1);
//				else if (i == 2) find(cur * arr[next], next + 1);
//				else if (i == 3) find(cur / arr[next], next + 1);
				
				oper[i]++;
			}	
		}
	}
}
