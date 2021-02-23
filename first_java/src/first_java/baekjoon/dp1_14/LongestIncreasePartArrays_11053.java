package first_java.baekjoon.dp1_14;

import java.util.*;
import java.io.*;

public class LongestIncreasePartArrays_11053 {
	public static int n;
	public static int[] arr, dp;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());
		
		arr = new int[n];
		dp = new int[n];
		
		st = new StringTokenizer(br.readLine());
		for (int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		for (int i=0; i<n; i++) {
			find(i);
		}
		
		int max = dp[0];
		
		for (int i=1; i<n; i++) {
			if (dp[i] > max) {
				max = dp[i];
			}
		}
		
		bw.write(String.valueOf(max));
		bw.flush();
		
	}
	
	public static int find(int n) {
		if (dp[n] == 0) {
			dp[n] = 1;
			
			for (int i=n-1; i>=0; i--) {
				if (arr[i] < arr[n]) {
					dp[n] = Math.max(dp[n], find(i) + 1);
				}
			}
		}
		
		return dp[n];
	}
}
