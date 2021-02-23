package first_java.baekjoon.Backtracking_13;

import java.util.*;
import java.io.*;

public class NandM4_15652 {
	public static int n, m;
	public static int[] arr;
	public static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		arr = new int[m];
		dfs(0, 0);
		
		bw.write(sb.toString());
		bw.flush();
		
	}
	
	public static void dfs(int depth, int start) {
		if (depth == m) {
			for (int val : arr) {
				sb.append(val).append(" ");
			}
			sb.append("\n");
			return;
		}
		
		for (int i=start; i<n; i++) {
			arr[depth] = i+1;
			dfs(depth+1, i);
		}
	}
}
