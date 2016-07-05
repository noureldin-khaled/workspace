package Codeforces;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class DesignTutorialMakeItNondeterministic {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		Triple[] in = new Triple[n];
		for (int i = 0; i < n; i++) {
			String f = sc.next(), l = sc.next();
			in[i] = new Triple(f, l, null);
		}
		
		Triple[] arr = new Triple[n];
		for (int i = 0; i < n; i++) {
			int a = sc.nextInt()-1;
			arr[i] = in[a];
		}
		
		arr[0].used = arr[0].first_name.compareTo(arr[0].last_name) < 0 ? arr[0].first_name : arr[0].last_name;
		for (int i = 1; i < n; i++) {
			Triple cur = arr[i];
			Triple prev = arr[i-1];
			String low = cur.first_name.compareTo(cur.last_name) < 0 ? cur.first_name : cur.last_name;
			String high = cur.first_name.compareTo(cur.last_name) > 0 ? cur.first_name : cur.last_name;
			
			if (low.compareTo(prev.used) < 0 && high.compareTo(prev.used) < 0) {
				System.out.println("NO");
				return;
			}
			
			if (low.compareTo(prev.used) >= 0)
				cur.used = low;
			else
				cur.used = high;
		}
		
		System.out.println("YES");
	}
	
	static class Triple {
		String first_name, last_name, used;
		
		public Triple(String f, String l, String u) {
			first_name = f;
			last_name = l;
			used = u;
		}
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
