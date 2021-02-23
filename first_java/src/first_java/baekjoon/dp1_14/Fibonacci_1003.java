package first_java.baekjoon.dp1_14;

import java.util.*;
import java.io.*;

public class Fibonacci_1003 {

	public static Integer[][] dp = new Integer[41][2];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		dp[0][0] = 1;
		dp[0][1] = 0;
		dp[1][0] = 0;
		dp[1][1] = 1;
		
		int t = Integer.parseInt(br.readLine());
		
		for (int i=0; i<t; i++) {
			int n = Integer.parseInt(br.readLine());
			Integer[] tmp = fib(n);
			bw.write(String.valueOf(tmp[0] + " " + tmp[1]));
			bw.newLine();
		}
		bw.flush();
	}
	
	public static Integer[] fib(int n) {
		if (dp[n][0] == null || dp[n][1] == null) {
			dp[n][0] = fib(n-1)[0] + fib(n-2)[0];
			dp[n][1] = fib(n-1)[1] + fib(n-2)[1];
		}
		
		return dp[n];
	}
}
