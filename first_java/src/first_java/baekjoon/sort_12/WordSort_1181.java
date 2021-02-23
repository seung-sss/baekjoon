package first_java.baekjoon.sort_12;
import java.util.*;
import java.io.*;

public class WordSort_1181 {
	static BufferedReader br;
	static BufferedWriter bw;
	static SortedSet<String> set;
	static String[] arr;
	static String[] res;
	static int len;
	static int cnt;
	
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		
		set = new TreeSet<>();
		for (int i=0; i<n ; i++) {
			set.add(br.readLine());
		}
		
		arr = new String[set.size()];
		set.toArray(arr);

		res = new String[arr.length];
		len = 1;
		cnt = 0;
		
		while (cnt != arr.length) {
			for (int i=0; i<arr.length; i++) {
				if (arr[i].length() == len) {
					res[cnt] = arr[i];
					cnt++;
				}
			}
			len++;
		}
		
		for (int i=0; i<res.length; i++) {
			bw.write(String.valueOf(res[i]));
			bw.newLine();
		}
		bw.flush();	
	}
}
