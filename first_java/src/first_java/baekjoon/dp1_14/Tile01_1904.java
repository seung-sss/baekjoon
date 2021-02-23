package first_java.baekjoon.dp1_14;

import java.util.*;
import java.io.*;

// tile(n) = tile(n-1) + tile(n-2) 라는 피보나치 수열과 같은 규칙 있음!! 

public class Tile01_1904 {
	public static int[] dp = new int[1000001];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		
		for (int i=0; i<dp.length; i++) {
			dp[i] = -1;
		}
		
		dp[0] = 0;
		dp[1] = 1;
		dp[2] = 2;
		
		bw.write(String.valueOf(tile(n)));
		bw.flush();
	}
	
	public static int tile(int n) {
		if (dp[n] == -1) {
			return dp[n] = (tile(n-1) + tile(n-2)) % 15746;
			// 모듈러 연산의 분배법칙 : (A+B)%C = (A%C + B%C)%C 
		}
		
		return dp[n];
	}
	
	// 반복문을 이용한 풀이! 
	public static int tile2(int n) {
		if (n == 1) return 1;
		
		if (n == 2) return 2;
		
		int val1 = 1;
		int val2 = 2;
		int sum = 0;
		
		for (int i=2; i<n; i++) {
			sum = (val1 + val2) % 15746;
			val1 = val2;
			val2 = sum;
		}
		
		return sum;
	}
}
