package Codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class WeirdCryptography {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		
		int t = 1;
		while(true) {
			int n = sc.nextInt();
			if (n == 0) break;
			
			int a[] = new int[n];
			TreeMap<String, Integer> tm = new TreeMap<>();
			int c = 0;
			for (int i = 0; i < n; i++) {
				String s = sc.next();
				int idx = c;
				if (tm.containsKey(s)) 
					idx = tm.get(s);
				else 
					tm.put(s, c++);
				
				a[i] = idx;
			}
			
			int occ[] = new int[10];
			for (int i = 0; i < n; i++) 
				occ[a[i]]++;
			
			PriorityQueue<Integer> pq = new PriorityQueue<>();
			while(true) {
				int set = 0;
				for (int i = 0; i < 10; i++)
					if (occ[i] > 0) {
						occ[i]--;
						set++;
					}
				
				if (set == 0)
					break;
				pq.add(set);
			}
			
			out.printf("Case %d: ", t++);
			while (!pq.isEmpty()) 
				out.print(pq.remove());
			out.println();
		}
		
		out.flush();
		out.close();
	}
	
	static class Scanner {
		BufferedReader br;
		StringTokenizer st;

		public Scanner(InputStream in) {
			br = new BufferedReader(new InputStreamReader(in));
		}

		public String next() throws IOException {
			while (st == null || !st.hasMoreTokens())
				st = new StringTokenizer(br.readLine());
			return st.nextToken();
		}

		public int nextInt() throws IOException {
			return Integer.parseInt(next());
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