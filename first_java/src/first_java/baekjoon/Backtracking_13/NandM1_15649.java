package first_java.baekjoon.Backtracking_13;

import java.util.*;
import java.io.*;

public class NandM1_15649 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static int[] arr;
	static boolean[] visited;
	static ArrayList<Integer> list;
	
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		arr = new int[n];
		
		for (int i=0; i<n; i++) {
			arr[i] = i+1; 
		}
		
		visited = new boolean[n];
		list = new ArrayList<>();
		find(list, arr, visited, 0, n, m);
		
	}
	
	public static void find(ArrayList<Integer> list, int[] arr, boolean[] visited, int start, int n, int r) throws IOException {
		if (r == 0) {
			for (int val : list) {
				bw.write(String.valueOf(val + " "));
			}
			bw.newLine();
			bw.flush();
			return;
		}
		
		for (int i=start; i<n; i++) {
			if (visited[i]) continue;
			
			visited[i] = true;
			list.add(arr[i]);
			find(list, arr, visited, 0, n, r-1);
			visited[i] = false;
			list.remove(list.lastIndexOf(arr[i]));
		}
	}
}
