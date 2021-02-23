package first_java.baekjoon.sort_12;
import java.util.*;
import java.io.*;

public class CoordinateSort_11650 {
	static BufferedReader br;
	static BufferedWriter bw;
	static StringTokenizer st;
	static int[][] arr;
	
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		
		arr = new int[n][2];
		
		for (int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j=0; j<2; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		Arrays.sort(arr, new Comparator<int[]>() {
			@Override
			public int compare(int[] t1, int[] t2) {
				if (t1[0] == t2[0]) return t1[1] - t2[1];
				else return t1[0] - t2[0];
			}
		});
		
		for (int i=0; i<n; i++) {
			bw.write(String.valueOf(arr[i][0] + " " + arr[i][1]));
			bw.newLine();
		}
		bw.flush();
	}
}
