package Codeforces;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class WritingCode {
	static int dp[][][];
	static int[] programmersBugs;
	static int mod;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		mod = Integer.parseInt(st.nextToken());

		programmersBugs = new int[n];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) 
			programmersBugs[i] = Integer.parseInt(st.nextToken());

		dp = new int[n+5][b+5][m+5];
		for (int i = 0; i < dp.length; i++) 
			for (int j = 0; j < dp[i].length; j++) 
				Arrays.fill(dp[i][j], -1);

		System.out.println(writingCode(0, b, m));
	}
	public static int writingCode(int curProgrammer,int numberOfBugs,int remLines){
	if (numberOfBugs < 0)
		return 0;
	if (remLines == 0)
		return 1;
	if (curProgrammer == programmersBugs.length)
		return 0;

	if (dp[curProgrammer][numberOfBugs][remLines] != -1)
		return dp[curProgrammer][numberOfBugs][remLines];

	int take = writingCode(curProgrammer, numberOfBugs - programmersBugs[curProgrammer], remLines-1);
	int leave = writingCode( curProgrammer+1, numberOfBugs,remLines);

	return dp[curProgrammer][numberOfBugs][remLines] = (take + leave)% mod;
}
}
