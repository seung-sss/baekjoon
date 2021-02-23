package first_java.baekjoon.dp1_14;

import java.util.*;
import java.io.*;

public class IntegerTriangle_1932 {
	public static int n;
	public static int[][] tri, dp;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());
		
		tri = new int[n][n];
		for (int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j=0; j<i+1; j++) {
				tri[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		dp = new int[n][n];
		for (int i=0; i<n; i++) {
			for (int j=0; j<n; j++) {
				dp[i][j] = -1;
			}
		}
		
		dp[n-1] = tri[n-1];
		
//		bw.write(String.valueOf(maxnum(0, 0)));
//		bw.flush();
		
		bw.write(String.valueOf(maxnum2()));
		bw.flush();
	}
	
	// 재귀 방식 
	public static int maxnum(int depth, int idx) {
		if (dp[depth][idx] == -1) {
			dp[depth][idx] = tri[depth][idx] + Math.max(maxnum(depth+1, idx), maxnum(depth+1, idx+1));
		}
		
		return dp[depth][idx];
	}
	
	// 반복문 방식 
	public static int maxnum2() {
		for (int i=n-2; i>=0; i--) {
			for (int j=0; j<=i; j++) {
				tri[i][j] = tri[i][j] + Math.max(tri[i+1][j], tri[i+1][j+1]);
			}
		}
		
		return tri[0][0];
	}
}
