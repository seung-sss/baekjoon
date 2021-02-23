package first_java.baekjoon.Backtracking_13;

import java.util.*;
import java.io.*;

public class NQueen_9663 {
	public static int n;
	public static int[] arr;
	public static int cnt;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		n = Integer.parseInt(br.readLine());
		
		// 열은 index값으로 처리함으로써 1차원 배열로 해결 가능! 
		arr = new int[n];
		nQueen(0);
		
		bw.write(String.valueOf(cnt));
		bw.flush();
	}
	
	public static void nQueen(int depth) {
		if (depth == n) {
			cnt++;
			return;
		}
		
		for (int i=0; i<n; i++) {
			arr[depth] = i;
			if (Possibility(depth)) {
				nQueen(depth + 1);
			}
		}
	}
	
	public static boolean Possibility(int col) {
		
		for (int i=0; i<col; i++) {
			if (arr[col] == arr[i]) {
				return false;
			} // 해당 노드와 행이 같은 노드가 있다면 false를 리턴! 
		
		
			else if (Math.abs(arr[col] - arr[i]) == Math.abs(col - i)) {
				return false;
			} // 두 열의 차이와 두 행의 차이의 절대값이 같으면 이는 서로 대각선상에 위치!
		}
		return true;
	}
}
