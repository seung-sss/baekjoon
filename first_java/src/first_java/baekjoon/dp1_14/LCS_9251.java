package first_java.baekjoon.dp1_14;

import java.util.*;
import java.io.*;

public class LCS_9251 {
	public static char[] str1, str2;
	public static Integer[][] dp;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		str1 = br.readLine().toCharArray();
		str2 = br.readLine().toCharArray();
		
		dp = new Integer[str1.length][str2.length];
		
		bw.write(String.valueOf(lcs(str1.length-1, str2.length-1)));
		bw.flush();
	}
	
	public static int lcs(int x, int y) {
		if (x == -1 || y == -1) {
			return 0;
		}
		
		if (dp[x][y] == null) {
			
			if (str1[x] == str2[y]) {
				dp[x][y] = lcs(x-1, y-1) + 1;
			}
			
			else {
				dp[x][y] = Math.max(lcs(x-1, y), lcs(x, y-1));
			}
		}
		
		return dp[x][y];
	}
}
