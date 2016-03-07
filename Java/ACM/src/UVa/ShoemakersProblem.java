package UVa;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class ShoemakersProblem {
	
	public static void main(String[] args) throws IOException {
		Scanner sc= new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		
		int t = sc.nextInt();
		while(t-->0) {
			int n = sc.nextInt();
			
			PriorityQueue<Task> pq = new PriorityQueue<>();
			for (int i = 1; i <= n; i++) {
				int T = sc.nextInt();
				int S = sc.nextInt();
				
				pq.add(new Task(i, T, S, (double)S/T));
			}
			
			while(!pq.isEmpty()) {
				Task first = pq.remove();
				if (pq.isEmpty()) {
					out.print(first.id);
					break;
				}
				Task second = pq.remove();
				
				if (first.T*second.S <= second.T*first.S) {
					out.print(first.id + " ");
					pq.add(new Task(second.id, second.T, second.S, second.ratio));
				}
				else {
					out.print(second.id + " ");
					pq.add(new Task(first.id, first.T, first.S, first.ratio));
				}
			}
			out.println();
			if (t > 0)
				out.println();
		}
		
		out.flush();
		out.close();
		
	}
	
	static class Task implements Comparable<Task> {
		int id;
		int T;
		int S;
		double ratio;
		
		public Task(int i, int t, int s, double r) {
			id = i;
			T = t;
			S = s;
			ratio = r;
		}

		@Override
		public int compareTo(Task o) {
			if (Double.compare(ratio, o.ratio) != 0)
				return Double.compare(o.ratio, ratio);
			return Integer.compare(id, o.id);
		}
		
		@Override
		public String toString() {
			return id + " " + T + " " + S + " " + ratio;
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

		public String Next() throws IOException {
			while (st == null || !st.hasMoreTokens())
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
