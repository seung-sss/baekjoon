package first_java.baekjoon.sort_12;

import java.util.*;
import java.io.*;

public class AgeSort_10814 {
	static BufferedReader br;
	static BufferedWriter bw;
	static StringTokenizer st;
	static int[][] arr;
	static String[] name;
	
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		
		arr = new int[n][2];
		name = new String[n];
		for (int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			// age 
			arr[i][0] = Integer.parseInt(st.nextToken());
			// index 
			arr[i][1] = i;
			// name 
			name[i] = st.nextToken();
		}
		
		Arrays.sort(arr, new Comparator<int[]>() {
			@Override
			public int compare(int[] t1, int[] t2) {
				if (t1[0] == t2[0]) return t1[1] - t2[1];
				else return t1[0] - t2[0];
			}
		});
		
		for (int i=0; i<n; i++) {
			bw.write(String.valueOf(arr[i][0] + " " + name[arr[i][1]]));
			bw.newLine();
		}
		bw.flush();
	}
}
