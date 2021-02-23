package first_java.baekjoon.dp1_14;

import java.util.*;
import java.io.*;

public class MakeOne_1463 {
	public static int[] dp;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		dp = new int[n+1];
		
		for (int i=0; i<n+1; i++) {
			dp[i] = -1;
		}
		dp[0] = dp[1] = 0;
		
		
		bw.write(String.valueOf(find(n)));
		bw.flush();
	}
	
	public static int find(int n) {
		if (dp[n] == -1) {
			if (n % 6 == 0) {
				dp[n] = Math.min(Math.min(find(n/2), find(n/3)), find(n-1)) + 1;
			}
			else if (n % 3 == 0) {
				dp[n] = Math.min(find(n/3), find(n-1)) + 1;
			}
			else if (n % 2 == 0) {
				dp[n] = Math.min(find(n/2), find(n-1)) + 1;
			}
			else {
				dp[n] = find(n-1) + 1;
			}
		}
		
		return dp[n];
	}
}
