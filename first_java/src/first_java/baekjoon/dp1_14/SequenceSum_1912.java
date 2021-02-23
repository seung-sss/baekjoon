package first_java.baekjoon.dp1_14;

import java.util.*;
import java.io.*;

public class SequenceSum_1912 {
	public static int n;
	public static int[] arr;
	public static Integer[] dp;
	public static int max;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());
		
		st = new StringTokenizer(br.readLine());
		
		arr = new int[n];
		dp = new Integer[n];
		
		for (int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		dp[0] = arr[0];
		max = dp[0];
		
		find(n-1);
		bw.write(String.valueOf(max));
		bw.flush();
		
	}
	
	public static int find(int n) {
		if (dp[n] == null) {
			dp[n] = Math.max(find(n-1) + arr[n], arr[n]);
			max = Math.max(max, dp[n]);
		}
		
		return dp[n];
	}
}
