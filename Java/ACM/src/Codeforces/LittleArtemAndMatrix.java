package Codeforces;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class LittleArtemAndMatrix {
	static int arr[][];
	static int n, m;
	
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		
		n = sc.nextInt();
		m = sc.nextInt();
		int q = sc.nextInt();
		
		ArrayList<String> input = new ArrayList<String>();
		while(q-->0) 
			input.add(sc.nextLine());
		
		int size = input.size();
		arr = new int[n][m];
		for (int i = size-1; i >= 0; i--) {
			String line = input.get(i);
			StringTokenizer st = new StringTokenizer(line);
			int t = Integer.parseInt(st.nextToken());
			
			if (t == 1) {
				int r = Integer.parseInt(st.nextToken()) - 1;
				shiftRight(r);
			}
			else if (t == 2) {
				int c = Integer.parseInt(st.nextToken()) - 1;
				shiftDown(c);
			}
			else {
				int r = Integer.parseInt(st.nextToken()) - 1;
				int c = Integer.parseInt(st.nextToken()) - 1;
				int x = Integer.parseInt(st.nextToken());
				
				arr[r][c] = x;
			}
		}
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++)
				out.print(arr[i][j] + " ");
			out.println();
		}
		
		out.flush();
		out.close();
	}
	
	public static void shiftRight(int i)
	{
		int val = arr[i][m-1];
		for (int j = m-1; j > 0; j--)
			arr[i][j] = arr[i][j-1];

		arr[i][0] = val; 
	}

	public static void shiftDown(int j)
	{
		int val = arr[n-1][j];
		for (int i = n-1; i > 0; i--)
			arr[i][j] = arr[i-1][j];

		arr[0][j] = val; 
	}

	private static class Scanner {
		BufferedReader br;
		StringTokenizer st;

		public Scanner(FileReader f) {
			br = new BufferedReader(f);
		}

		public Scanner(InputStream in) {
			br = new BufferedReader(new InputStreamReader(in));
		}

		public String Next() throws IOException {
			if (st == null || !st.hasMoreTokens())
				st = new StringTokenizer(br.readLine());
			return st.nextToken();
		}

		public String nextLine() throws IOException {
			return br.readLine();
		}

		public int nextInt() throws IOException {
			return Integer.parseInt(Next());
		}

		public long nextLong() throws IOException {
			return Long.parseLong(Next());
		}

		public double nextDouble() throws IOException {
			return Double.parseDouble(Next());
		}

		public boolean Ready() throws IOException {
			return br.ready();
		}

		public void waitForInput(long time) {
			long ct = System.currentTimeMillis();
			while(System.currentTimeMillis() - ct < time) {};
		}

	}
}
