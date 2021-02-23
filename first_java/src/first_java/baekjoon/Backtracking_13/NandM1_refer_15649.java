package first_java.baekjoon.Backtracking_13;

import java.util.*;
import java.io.*;

public class NandM1_refer_15649 {
	static int[] arr;
	static boolean[] visited;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		arr = new int[m];
		visited = new boolean[n];
		
		dfs(0, n, m);
		
		bw.write(sb.toString());
		bw.flush();
		
	}
	
	public static void dfs(int depth, int n, int m) {
		if (depth == m) {
			for (int val : arr) {
				sb.append(val).append(" ");
			}
			sb.append("\n");
			return;
		}
		
		for (int i=0; i<n; i++) {
			
			if (!visited[i]) {
				visited[i] = true;
				arr[depth] = i+1;
				dfs(depth+1, n, m);
				visited[i] = false;
			}
		}
	}
}
