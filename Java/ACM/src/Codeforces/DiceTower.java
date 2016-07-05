package Codeforces;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class DiceTower {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int top = sc.nextInt();
		for (int i = 0; i < n; i++) {
			int x = sc.nextInt(), y = sc.nextInt();
			int ox = 7-x, oy = 7-y;
			int bottom = 7 - top;
			
			int arr[] = {x, y, ox, oy, top, bottom};
			if (!areDistinct(arr)) {
				System.out.println("NO");
				return;
			}
			top = bottom;
		}
		
		System.out.println("YES");
	}
	
	public static boolean areDistinct(int arr[]) {
		for (int i = 0; i < arr.length; i++) 
			for (int j = i+1; j < arr.length; j++)
				if (arr[i] == arr[j]) return false;
		
		return true;
	}

	static class Scanner {
		BufferedReader br;
		StringTokenizer st;

		public Scanner(FileReader f) {
			br = new BufferedReader(f);
		}

		public Scanner(InputStream in) {
			br = new BufferedReader(new InputStreamReader(in));
		}

		public String next() throws IOException {
			while (st == null || !st.hasMoreTokens())
				st = new StringTokenizer(br.readLine());
			return st.nextToken();
		}

		public String nextLine() throws IOException {
			return br.readLine();
		}

		public int nextInt() throws IOException {
			return Integer.parseInt(next());
		}

		public long nextLong() throws IOException {
			return Long.parseLong(next());
		}

		public double nextDouble() throws IOException {
			return Double.parseDouble(next());
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
