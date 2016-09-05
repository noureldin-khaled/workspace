package Codeforces;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class FoxAndBoxAccumulation {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		ArrayList<Integer> a[] = new ArrayList[n];
		int in[] = new int[n];
		for (int i = 0; i < n; i++)
			in[i] = sc.nextInt();
		Arrays.sort(in);
		
		for (int i = 0; i < n; i++)
			a[i] = new ArrayList<>();
		
		for (int i = 0; i < n; i++)
			a[i].add(in[i]);
		
		for (int i = 0; i < n; i++) {
			int idx = -1;
			for (int j = 0; j < n; j++) {
				if (i == j) continue;

				if (valid(a[i], a[j]) && (idx == -1 || a[j].get(a[j].size()-1) < a[idx].get(a[idx].size()-1)))
					idx = j;
			}
			
			if (idx != -1) {
				for (int j = 0; j < a[i].size(); j++)
					a[idx].add(a[i].get(j));
				a[i].clear();
			}
		}
		
		int ans = 0;
		for (int i = 0; i < n; i++)
			if (a[i].size() > 0)
				ans++;
		
		System.out.println(ans);
	}

	static boolean valid(ArrayList<Integer> a1, ArrayList<Integer> a2) {
		if (a1.isEmpty() || a2.isEmpty() || a1.get(0) > a2.get(a2.size()-1))
			return false;

		int c = 0;
		for (int i = a2.size()-1; i >= 0; i--) {
			int x = a2.get(i) - c;
			if (x < a1.size())
				return false;
			c++;
		}
		
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
