package first_java.baekjoon.Backtracking_13;

import java.util.*;
import java.io.*;

public class NandM3_15651 {
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
		dfs(0);
		
		bw.write(sb.toString());
		bw.flush();
		
	}
	
	public static void dfs(int depth) {
		if (depth == m) {
			for (int val : arr) {
				sb.append(val).append(" ");
			}
			sb.append("\n");
			return;
		}
		
		for (int i=0; i<n; i++) {
			arr[depth] = i+1;
			dfs(depth+1);
		}
	}
}
