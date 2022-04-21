package m4w11;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ2225 {
	
	static int num = 1000000000;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		int[][] dp = new int[k+1][n+1];
		Arrays.fill(dp[1], 1);
		
		for(int i = 1; i <= k; i++) {
			dp[i][0] = 1;
		}
		
		for(int i = 2; i <= k; i++) {
			for(int j = 1; j <= n; j++) {
				dp[i][j] = dp[i-1][j] + dp[i][j-1];
				dp[i][j] %= num;
			}
		}
		
		System.out.println(dp[k][n]);
	}
}
