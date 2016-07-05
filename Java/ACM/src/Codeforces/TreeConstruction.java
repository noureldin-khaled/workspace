package Codeforces;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.util.TreeMap;
import java.util.TreeSet;

public class TreeConstruction {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		
		int n = sc.nextInt();
		TreeSet<Integer> ts = new TreeSet<Integer>();
		boolean hasLeft[] = new boolean[n+1];
		int root = sc.nextInt();
		ts.add(root);
		TreeMap<Integer, Integer> tm = new TreeMap<>();
		tm.put(root, 0);
		
		for (int i = 1; i < n; i++) {
			int node = sc.nextInt();
			Integer upper = ts.higher(node);
			
			if (upper != null) {
				Integer idx = tm.get(upper);
				
				if (!hasLeft[idx]) {
					out.print(upper + " ");
					hasLeft[idx] = true;
					ts.add(node);
				}
				else {
					Integer lower = ts.lower(node);
					out.print(lower + " ");
					ts.add(node);
				}
			}
			else {
				Integer lower = ts.lower(node);
				out.print(lower + " ");
				ts.add(node);
			}
			
			tm.put(node, i);
		}
		
		out.flush();
		out.close();
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
