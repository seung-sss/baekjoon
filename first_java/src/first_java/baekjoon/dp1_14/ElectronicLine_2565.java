package first_java.baekjoon.dp1_14;

import java.util.*;
import java.io.*;

public class ElectronicLine_2565 {
	public static int[][] arr;
	public static Integer[] dp;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		
		arr = new int[n][2];
		dp = new Integer[n];
		
		for (int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr, new Comparator<int[]>() {
			@Override
			public int compare(int[] t1, int[] t2) {
				return t1[0] - t2[0];
			}
		});
		
		int max = 0;
		
		for (int i=0; i<n; i++) {
			max = Math.max(lis(i), max);
		}
		
		bw.write(String.valueOf(n-max));
		bw.flush();
	}
	
	public static int lis(int n) {
		if (dp[n] == null) {
			dp[n] = 1;
			
			for (int i=n-1; i>=0; i--) {
				if (arr[i][1] < arr[n][1]) {
					dp[n] = Math.max(dp[n], lis(i) + 1);
				}
			}
		}
		
		return dp[n];
	}
}
