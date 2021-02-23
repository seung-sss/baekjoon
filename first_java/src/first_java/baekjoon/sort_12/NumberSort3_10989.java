package first_java.baekjoon.sort_12;

import java.util.*;
import java.io.*;

public class NumberSort3_10989 {
	static BufferedReader br;
	static BufferedWriter bw;
	static int[] cnt;
	
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		
		// 이 문제는 count sort 이용해야함(아니면 시간초과 또는 메모리 초과) 
		cnt = new int[10001];
		
		for (int i=0; i<n; i++) {
			cnt[Integer.parseInt(br.readLine())]++;
		}
		
		br.close();
		
		for (int i=0; i<10001; i++) {
			while (cnt[i] != 0) {
				bw.write(String.valueOf(i));
				bw.newLine();
				cnt[i]--;
			}
		}
		bw.flush();
	}
}
