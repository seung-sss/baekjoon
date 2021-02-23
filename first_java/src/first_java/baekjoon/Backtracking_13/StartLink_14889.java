package first_java.baekjoon.Backtracking_13;

import java.util.*;
import java.io.*;

public class StartLink_14889 {
	public static int n;
	public static int[][] arr;
	public static boolean[] check;
	public static int min = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());
		
		arr = new int[n][n];
		for (int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j=0; j<n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		check = new boolean[n];
		find(0, 0);
		bw.write(String.valueOf(min));
		bw.flush();
		
	}
	
	public static void find(int root, int depth) {
		if (depth == n/2) {
			diff();
			return;
			
		}
		
		for (int i=root; i<n; i++) {
			if (!check[i]) {
				check[i] = true;
				find(i+1, depth+1);
				check[i] = false;
			}
		}
	}
	
	public static void diff() {
		int team_start = 0;
		int team_link = 0;
		
		for (int i=0; i<n-1; i++) {
			for (int j=i+1; j<n; j++) {
				if (check[i] == true && check[j] == true) {
					team_start += arr[i][j];
					team_start += arr[j][i];
				}
				
				else if (check[i] == false && check[j] == false) {
					team_link += arr[i][j];
					team_link += arr[j][i];
				}
			}
		}
		
		int val = Math.abs(team_start - team_link);
		
		if (val == 0) {
			System.out.println(val);
			System.exit(0);
		}
		
		min = Math.min(min, val);
	}
}
