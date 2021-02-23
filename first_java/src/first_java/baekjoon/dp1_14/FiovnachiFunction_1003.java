import java.io.*;

public class FiovnachiFunction_1003 {
	public static int zero, one;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int t = Integer.parseInt(br.readLine());
		
		for (int i=0; i<t; i++) {
			zero = 0;
			one = 0;
			int n = Integer.parseInt(br.readLine());
			fibonacci(n);
			
			bw.write(String.valueOf(zero + " " + one));
			bw.newLine();
		}
		bw.flush();
		
	}
	
	public static int fibonacci(int n) {
		if (n == 0) {
			zero++;
			return 0;
		}
		
		else if (n == 1) {
			one++;
			return 1;
		}
		
		else {
			return fibonacci(n-1) + fibonacci(n-2);
		}
	}
}
