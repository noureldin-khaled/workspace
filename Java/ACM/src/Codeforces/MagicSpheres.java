package Codeforces;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class MagicSpheres {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);

		int a = sc.nextInt(), b = sc.nextInt(), c = sc.nextInt();
		int x = sc.nextInt(), y = sc.nextInt(), z = sc.nextInt();
		int have[] = {a, b, c};
		int need[] = {x, y, z};

		boolean flag = true;
		int count = 0;
		for (int i = 0; i < 3; i++) {
			if (have[i] < need[i]) {
				flag = false;
				continue;
			}
			int diff = have[i] - need[i];
			if (diff%2 != 0)
				diff--;
			
			count += diff/2;
			have[i] -= diff;
		}
		
		if (flag) {
			System.out.println("Yes");
			return;
		}

		for (int i = 0; i < 3; i++) {
			if (have[i] < need[i]) {
				if (count - (need[i] - have[i]) < 0) {
					System.out.println("No");
					return;
				}
				count -= (need[i] - have[i]);
			}
		}
	
		System.out.println("Yes");
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
