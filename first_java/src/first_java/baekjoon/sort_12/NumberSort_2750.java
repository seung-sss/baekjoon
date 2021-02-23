package first_java.baekjoon.sort_12;
import java.util.*;
import java.io.*;

public class NumberSort_2750 {
	static BufferedReader br;
	static BufferedWriter bw;
	static SortedSet<Integer> set;
	static Integer[] arr;
	
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		
		set = new TreeSet<>();
		
		for (int i=0; i<n; i++) {
			set.add(Integer.parseInt(br.readLine()));
		}
		
		arr = new Integer[set.size()];
		set.toArray(arr);
		
		for (int i=0; i<n; i++) {
			bw.write(String.valueOf(arr[i]));
			bw.write("\n");
		}
		bw.flush();
	}	
}
