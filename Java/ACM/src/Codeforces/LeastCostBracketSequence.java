package Codeforces;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class LeastCostBracketSequence {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		
		char[] s = sc.nextLine().toCharArray();
		int n = s.length;
		
		Element a[] = new Element[n];
		for (int i = 0; i < n; i++) 
			if (s[i] == '?')
				a[i] = new Element(sc.nextInt(), sc.nextInt(), i);
		
		PriorityQueue<Element> pq = new PriorityQueue<>();
		int size = 0;
		
		long sum = 0;
		int c = 0;
		for (int i = 0; i < n; i++) {
			if (c < 0)
				break;
			if (s[i] == '(')
				c++;
			else if (s[i] == ')') {
				c--;
			}
			else {
				s[i] = ')';
				sum += a[i].b;
				pq.add(a[i]);
				size++;
				c--;
			}
			if (c < 0) {
				if (size == 0)
					break;
				Element e = pq.remove();
				size--;
				sum += e.a - e.b;
				s[e.idx] = '(';
				c+=2;
			}
		}
		
		if (c == 0) {
			out.println(sum);
			out.println(new String(s));
		}
		else
			out.println(-1);
		
		out.flush();
		out.close();
	}
	
	static class Element implements Comparable<Element> {
		int a, b, idx;
		
		public Element(int x, int y, int i) {
			a = x;
			b = y;
			idx = i;
		}

		@Override
		public int compareTo(Element o) {
			int d1 = a-b;
			int d2 = o.a-o.b;
			
			return Integer.compare(d1, d2);
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
