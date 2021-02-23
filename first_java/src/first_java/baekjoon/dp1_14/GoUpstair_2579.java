package first_java.baekjoon.dp1_14;

import java.util.*;
import java.io.*;

public class GoUpstair_2579 {
	public static int cnt;
	public static int[] score, dp;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		cnt = Integer.parseInt(br.readLine());
		
		score = new int[cnt+1];
		for (int i=1; i<cnt+1; i++) {
			score[i] = Integer.parseInt(br.readLine());
		}
		
		dp = new int[cnt+1];
		
		for (int i=0; i<cnt+1; i++) {
			dp[i] = -1;
		}
		
		dp[0] = score[0];
		dp[1] = score[1];
		
		if (cnt >= 2) {
			dp[2] = score[1] + score[2];
		}
		
		bw.write(String.valueOf(find(cnt)));
		bw.flush();
	}
	
	public static int find(int n) {
		if (dp[n] == -1) {
			dp[n] = Math.max(find(n-2), find(n-3) + score[n-1]) + score[n];
		}
		
		return dp[n];
	}
}
