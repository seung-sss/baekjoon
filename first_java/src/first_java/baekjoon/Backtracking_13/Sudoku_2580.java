package first_java.baekjoon.Backtracking_13;

import java.util.*;
import java.io.*;

public class Sudoku_2580 {
	public static BufferedReader br;
	public static BufferedWriter bw;
	public static StringTokenizer st;
	public static int[][] arr = new int[9][9];
	public static StringBuilder sb = new StringBuilder();
	
	
	
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		
		for (int i=0; i<9; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j=0; j<9; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		sudoku(0, 0);
	}
	
	public static void sudoku(int row, int col) throws IOException {
		if (col == 9) {
			sudoku(row+1, 0);
			return;
		}
		
		if (row == 9) {
			for (int i=0; i<9; i++) {
				for (int j=0; j<9; j++) {
					sb.append(arr[i][j]).append(" ");
				}
				sb.append("\n");
			}
			bw = new BufferedWriter(new OutputStreamWriter(System.out));
			bw.write(sb.toString());
			bw.flush();
			
			System.exit(0);
		}
		
		if (arr[row][col] == 0) {
			for (int i=1; i<=9; i++) {
				if (Possibility(row, col, i)) {
					arr[row][col] = i;
					sudoku(row, col+1);
				}
			}
			arr[row][col] = 0;
			return;
		}
		
		sudoku(row, col+1);
	}
	
	// 해당 위치에 val이라는 값이 들어갈 수 있는지 유무를 리턴!
	public static boolean Possibility(int row, int col, int val) {
		// 행 체크! 
		for (int i=0; i<9; i++) {
			if (arr[row][i] == val) {
				return false;
			}
		}
		
		// 열 체크! 
		for (int i=0; i<9; i++) {
			if (arr[i][col] == val) {
				return false;
			}
		}
		
		// (3*3)칸 체크! 
		int start_row = (row/3) * 3;
		int start_col = (col/3) * 3;
		
		for (int i=start_row; i<start_row+3; i++) {
			for (int j=start_col; j<start_col+3; j++) {
				if (arr[i][j] == val) {
					return false;
				}
			}
		}
		
		return true;
	}
}
