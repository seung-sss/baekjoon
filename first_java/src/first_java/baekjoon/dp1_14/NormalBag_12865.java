package first_java.baekjoon.dp1_14;

import java.util.*;
import java.io.*;

public class NormalBag_12865 {
	public static int n, k;
	public static int[][] bag;
	public static int[] dp;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		bag = new int[n][2];
		dp = new int[k+1];
		
		for (int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			bag[i][0] = Integer.parseInt(st.nextToken());
			bag[i][1] = Integer.parseInt(st.nextToken());
		}
		
		for (int i=0; i<n; i++) {
			dp[bag[i][0]] = bag[i][1];
		}
		
		bw.write(String.valueOf(find(k)));
		bw.flush();
	}
	
	public static int find(int w) {
		if (dp[w] == 0) {
			
			for (int i=0; i<n; i++) {
				if (bag[i][0] < w) {
					dp[w] = Math.max(dp[w], find(bag[i][0]) + find(w - (bag[i][0])));
				}
			}
		}
		
		return dp[w];
	}
}
