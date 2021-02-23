package first_java.baekjoon.dp1_14;

import java.util.*;
import java.io.*;

public class LongestBitonic_11054 {
	public static int n;
	public static int[] arr, dpup, dpdown;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());
		
		arr = new int[n];
		dpup = new int[n];
		dpdown = new int[n];
		
		st = new StringTokenizer(br.readLine());
		
		for (int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		for (int i=0; i<n; i++) {
			lis(i);
			lds(i);
		}
		
		int max = Integer.MIN_VALUE;
		
		for (int i=0; i<n; i++) {
			max = Math.max(dpup[i] + dpdown[i], max);
		}
		
		bw.write(String.valueOf(max-1));
		bw.flush();
		
	}
	
	public static int lis(int n) {
		if (dpup[n] == 0) {
			dpup[n] = 1;
			
			for (int i=n-1; i>=0; i--) {
				if (arr[i] < arr[n]) {
					dpup[n] = Math.max(dpup[n], lis(i) + 1);
				}
			}
		}
		
		return dpup[n];
	}
	
	public static int lds(int n) {
		if (dpdown[n] == 0) {
			dpdown[n] = 1;
			
			for (int i=n+1; i<dpdown.length; i++) {
				if (arr[i] < arr[n]) {
					dpdown[n] = Math.max(dpdown[n], lds(i) + 1);
				}
			}
		}
		
		return dpdown[n];
	}
}
