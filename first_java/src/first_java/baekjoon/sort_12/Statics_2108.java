package first_java.baekjoon.sort_12;
import java.util.*;
import java.io.*;

public class Statics_2108 {
	static BufferedReader br;
	static BufferedWriter bw;
	static int[] arr;
	static int sum;
	static int max;
	static int min;
	static int med;
	static int mode;
	static int cnt;
	static int mode_max;
	static boolean flag;
	
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		
		arr = new int[8001];
		sum = 0;
		max = Integer.MIN_VALUE;
		min = Integer.MAX_VALUE;
		
		for (int i=0; i<n; i++) {
			int value = Integer.parseInt(br.readLine());
			arr[value + 4000]++;
			
			sum += value;
			
			if (value > max) max = value;
			if (value < min) min = value;
		}
		
		med = 10000;
		mode = 10000;
		
		cnt = 0;
		mode_max = 0;
		flag = false;
		
		for (int i=min+4000; i<=max+4000; i++) {
			
			if (arr[i] > 0) {
				
				// 중앙값 찾기 
				if (cnt < (n+1) / 2) {
					cnt += arr[i];
					med = i - 4000;
				}
				
				// 최빈값 찾기 (최초) 
				if (mode_max < arr[i]) {
					mode_max = arr[i];
					mode = i - 4000;
					flag = true;
				}
				
				//만일 2번째 있다면, 두 번째 최빈값 찾기 
				else if (mode_max == arr[i] && flag == true) {
					mode = i - 4000;
					flag = false;
				}
				
			}
		}
		
		bw.write(String.valueOf((int)Math.round((double)sum/n)));
		bw.newLine();
		bw.write(String.valueOf(med));
		bw.newLine();
		bw.write(String.valueOf(mode));
		bw.newLine();
		bw.write(String.valueOf(max-min));
		bw.flush();
	}
}
