package first_java.baekjoon.dp1_14;

import java.util.*;
import java.io.*;

// p(n) = p(n-2) + p(n-3) 

public class Padoban_9461 {
	public static long[] dp = new long[101];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		for (int i=0; i<dp.length; i++) {
			dp[i] = -1;
		}
		
		dp[0] = 0;
		dp[1] = 1;
		dp[2] = 1;
		dp[3] = 1;
		
		int t = Integer.parseInt(br.readLine());
		
		for (int i=0; i<t; i++) {
			int n = Integer.parseInt(br.readLine());
			bw.write(String.valueOf(pado(n)));
			bw.newLine();
		}
		
		bw.flush();
		
	}
	
	public static long pado(int n) {
		if (dp[n] == -1) {
			return dp[n] = pado(n-2) + pado(n-3);
		}
		
		return dp[n];
	}
}
