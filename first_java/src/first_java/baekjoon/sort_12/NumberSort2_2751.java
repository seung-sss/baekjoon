package first_java.baekjoon.sort_12;
import java.util.*;
import java.io.*;

public class NumberSort2_2751 {
	static BufferedReader br;
	static BufferedWriter bw;
	
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		
		// collection sort 사용해보기! (기본 오름차순)
		// 내림차순의 경우,Collections.sort(list) 이후, Collections.reverse() 이용! 
//		ArrayList<Integer> list = new ArrayList<>();
//		
//		for (int i=0; i<n; i++) {
//			list.add(Integer.parseInt(br.readLine()));
//		}
//		
//		Collections.sort(list);
//		
//		for (int value : list) {
//			bw.write(String.valueOf(value));
//			bw.newLine();
//		}
//		bw.flush();
		
		//Counting sort 이용! (중복이 없기 때문에 사용 가능!)
		boolean[] arr = new boolean[2000001]; // 수의 범위 : -1,000,000 ~ 1,000,000 
		
		for (int i=0; i<n ;i++) {
			arr[Integer.parseInt(br.readLine()) + 1000000] = true;
		} // 기준점 0 = index 1,000,000으로 생각! 
		
		for (int i=0; i<arr.length; i++) {
			if (arr[i]) {
				bw.write(String.valueOf(i-1000000));
				bw.newLine();
			}
			bw.flush();
		}
		
	}
}
