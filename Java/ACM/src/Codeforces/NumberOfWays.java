package Codeforces;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class NumberOfWays {
	
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		long comm[] = new long[n];
		
		for (int i = 0; i < n; i++) {
			int a = sc.nextInt();
			
			comm[i] = a;
			if (i > 0)
				comm[i] += comm[i-1];
		}
		
		TreeMap<Long, Pair> tm = new TreeMap<>();
		for (int i = 1; i < n-1; i++) {
			if (tm.containsKey(comm[i])) {
				Pair p = tm.get(comm[i]);
				tm.put(comm[i], new Pair(p.occ + 1, i));
			}
			else
				tm.put(comm[i], new Pair(1, i));
		}
		
		long ans = 0;
		for (int i = 0; i < n-1; i++) {
			long req = 2*comm[i];
			
			if (i > 0  && tm.containsKey(comm[i])) {
				Pair p = tm.get(comm[i]);

				if (p.occ - 1 == 0)
					tm.remove(comm[i]);
				else
					tm.put(comm[i], new Pair(p.occ - 1, p.index));
			}
			if (tm.containsKey(req)) {
				Pair p = tm.get(req);
				
				if ((comm[n-1] - comm[p.index]) == comm[i]) 
					ans += p.occ;
			}
			
			
		}
		
		System.out.println(ans);
	}
	
	static class Pair {
		int occ;
		int index;
		
		public Pair(int o, int i) {
			occ = o;
			index = i;
		}
		
		@Override
		public String toString() {
			return "(" + occ + ", " + index + ")";
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
