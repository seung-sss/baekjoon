package first_java.baekjoon.dp1_14;

import java.util.*;
import java.io.*;

public class RGBstreet_1149 {
	public static int n;
	public static int[][] cost, dp;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());
		
		cost = new int[n][3];
		
		for (int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j=0; j<3; j++) {
				cost[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		dp = new int[n][3];
		dp[0] = cost[0];
		
//		findCost(1);
		
//		bw.write(String.valueOf(findCost2()));
//		bw.flush();
		
		bw.write(String.valueOf(Math.min(Math.min(paint_cost(n-1, 0), paint_cost(n-1, 1)), paint_cost(n-1, 2))));
		bw.flush();
	}
	
	public static void findCost(int start) {
		if (start == n) {
			int ans = Integer.min(Integer.min(dp[n-1][0], dp[n-1][1]), dp[n-1][2]);
			System.out.println(ans);
			System.exit(0);
		}
		
		dp[start][0] = cost[start][0] + Integer.min(dp[start-1][1], dp[start-1][2]);
		dp[start][1] = cost[start][1] + Integer.min(dp[start-1][0], dp[start-1][2]);
		dp[start][2] = cost[start][2] + Integer.min(dp[start-1][0], dp[start-1][1]);
		
		findCost(start+1);
	}
	
	public static int findCost2() {
		for (int i=1; i<n; i++) {
			dp[i][0] = cost[i][0] + Integer.min(dp[i-1][1], dp[i-1][2]);
			dp[i][1] = cost[i][1] + Integer.min(dp[i-1][0], dp[i-1][2]);
			dp[i][2] = cost[i][2] + Integer.min(dp[i-1][0], dp[i-1][1]);
		}
		
		return Integer.min(Integer.min(dp[n-1][0], dp[n-1][1]), dp[n-1][2]);
	}
	
	public static int paint_cost(int size, int color) {
		if (dp[size][color] == 0) {
			
			if (color == 0) {
				dp[size][0] = Math.min(paint_cost(size-1, 1), paint_cost(size-1, 2)) + cost[size][0];
			}
			else if (color == 1) {
				dp[size][1] = Math.min(paint_cost(size-1, 0), paint_cost(size-1, 2)) + cost[size][1];
			}
			else {
				dp[size][2] = Math.min(paint_cost(size-1, 0), paint_cost(size-1, 1)) + cost[size][2];
			}
		}
		
		return dp[size][color];
	}
}
