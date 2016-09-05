package UVa;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SoftwareAllocation {
	static final int INF = (int)1e9;
	static int s, t;
	static int[][] res;
	static int[] p;
	
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		
		sc.waitForInput(1500);
		res = new int[38][38];
		p = new int[38];
		while(sc.Ready()) {
			for (int i = 0; i < 38; i++)
				Arrays.fill(res[i], 0);
			
			for (int i = 27; i <= 36; i++) 
				res[i][37] = 1;
			
			int totalApps = 0;
			while(sc.Ready()) {
				String s = sc.nextLine();
				if (s.isEmpty()) break;
				
				StringTokenizer st = new StringTokenizer(s);
				String f = st.nextToken();
				int app = f.charAt(0) - 'A' + 1;
				res[0][app] += f.charAt(1) - '0';
				totalApps += (f.charAt(1) - '0');
				
				String l = st.nextToken();
				for (int i = 0; i < l.length()-1; i++) {
					int v = l.charAt(i) - '0' + 27;
					
					res[app][v] = INF;
				}
			}
			s = 0;
			t = 37;
			int mf = edmondsKarp();
			if (mf == totalApps) {
				StringBuilder sb = new StringBuilder();
				
				for(int i = 27; i <= 36; ++i) {
					boolean used = false;
					for(int j = 1; j <= 26 && !used; ++j)
						if(res[i][j] == 1) {
							sb.append((char)(j + 'A' - 1));
							used = true;
						}
					if(!used)
						sb.append('_');
				}
				
				out.print(sb);
			}
			else
				out.print("!");
			out.println();
		}
		
		out.flush();
		out.close();
	}
	
	static int edmondsKarp() {
		int mf = 0;
		while(true) {
			Queue<Integer> q = new LinkedList<Integer>();
			Arrays.fill(p, -1);
			p[s] = s;
			q.add(s);
			while(!q.isEmpty()) {
				int u = q.remove();
				if(u == t)
					break;
				for(int v = 0; v < 38; v++)
					if(res[u][v] > 0 && p[v] == -1) {
						p[v] = u;
						q.add(v);
					}
			}
			
			if(p[t] == -1)
				break;
			mf += augment(t, INF);
		}
		return mf;
	}

	static int augment(int v, int flow) {
		if(v == s)
			return flow;
		flow =  augment(p[v], Math.min(res[p[v]][v],flow));
		res[p[v]][v] -= flow;
		res[v][p[v]] += flow;

		return flow;
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
