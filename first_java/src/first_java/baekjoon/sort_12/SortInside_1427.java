package first_java.baekjoon.sort_12;
import java.util.*;
import java.io.*;

public class SortInside_1427 {
	static BufferedReader br;
	static BufferedWriter bw;
	static Integer[] arr;
	
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String n = br.readLine();
		
		arr = new Integer[n.length()];
		
		for (int i=0; i<n.length(); i++) {
			String tmp = String.valueOf(n.charAt(i));
			arr[i] = Integer.parseInt(tmp);
		}
		
		Arrays.sort(arr, Collections.reverseOrder());
		
		for (int val : arr) {
			bw.write(String.valueOf(val));
		}
		bw.flush();
	}
}
