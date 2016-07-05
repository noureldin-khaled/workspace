package Codeforces;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class HeapOperations {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		
		ArrayList<String> res = new ArrayList<>();
		int n = sc.nextInt();
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for (int i = 0; i < n; i++) {
			String command = sc.next();
			
			if (command.equals("insert")) {
				int a = sc.nextInt();
				pq.add(a);
				res.add(command + " " + a);
			}
			else if (command.equals("getMin")) {
				int a = sc.nextInt();
				
				while(!pq.isEmpty()) {
					int e = pq.peek();
					if (e > a) {
						res.add("insert " + a);
						pq.add(a);
					}
					else if (e < a) {
						res.add("removeMin");
						pq.remove();
					}
					else 
						break;
				}
				
				if (pq.isEmpty()) {
					res.add("insert " + a);
					pq.add(a);
				}
				
				res.add(command + " " + a); 
			}
			else {
				if (pq.isEmpty()) {
					res.add("insert 0");
					pq.add(0);
				}
				
				pq.remove();
				res.add(command);
			}
		}
		
		int v = res.size();
		out.println(v);
		for (int i = 0; i < v; i++)
			out.println(res.get(i));
		
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
