package first_java.baekjoon.dp1_14;

import java.util.*;
import java.io.*;

public class WineTaste_2156 {
	public static int n;
	public static int[] wine, dp;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		n = Integer.parseInt(br.readLine());
		
		wine = new int[n+1];
		dp = new int[n+1];
		
		for (int i=1; i<=n; i++) {
			wine[i] = Integer.parseInt(br.readLine());
		}
		
		for (int i=0; i<=n; i++) {
			dp[i] = -1;
		}
		
		dp[0] = wine[0];
		dp[1] = wine[1];
		
		if (n >= 2) {
			dp[2] = wine[1] + wine[2];
		}
		
		bw.write(String.valueOf(find(n)));
		bw.flush();
		
	}
	
	public static int find(int n) {
		if (dp[n] == -1) {
			dp[n] = Math.max(Math.max(find(n-2), find(n-3) + wine[n-1]) + wine[n], find(n-1));
		}
		
		return dp[n];
	}
}
