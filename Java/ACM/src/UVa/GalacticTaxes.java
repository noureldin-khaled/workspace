package UVa;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class GalacticTaxes {
	static int n, m;
	static final double INF = 1e16;
	static final double EPS = 1e-11;
	static ArrayList<Node> adjlist[];
	static Line in[];

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);

		sc.waitForInput(1500);
		while(sc.Ready()) {
			n = sc.nextInt();
			m = sc.nextInt();

			in = new Line[m];
			for (int i = 0; i < m; i++)
				in[i] = new Line(sc.nextInt()-1, sc.nextInt()-1, sc.nextInt(), sc.nextInt());

			adjlist = new ArrayList[n];
			double low = 0.0;
			double high = 1440.0;

			while(Math.abs(high-low) > EPS) {
				double d = (high-low)/3;
				double c1 = dijkstra(low+d);
				double c2 = dijkstra(high-d);
				
				if (Math.abs(c1-c2) < EPS) {
					low += d;
					high -= d;
				}
				else if (c1 > c2)
					high -= d;
				else
					low += d;
			}
			
			out.printf("%.5f\n", dijkstra(low));
		}

		out.flush();
		out.close();
	}

	static double dijkstra(double t) {
		for (int j = 0; j < n; j++)
			adjlist[j] = new ArrayList<>();
		
		for (int i = 0; i < m; i++) {
			double w = f(in[i].A, in[i].B, t);
			adjlist[in[i].u].add(new Node(in[i].v, w));
			adjlist[in[i].v].add(new Node(in[i].u, w));
		}

		double[] dist = new double[n];
		Arrays.fill(dist, INF);
		PriorityQueue<Node> pq = new PriorityQueue<Node>();
		dist[0] = 0.0;
		pq.add(new Node(0, 0));
		while(!pq.isEmpty()) {
			Node cur = pq.remove();
			if(cur.name == n-1)		//remove if all nodes are sinks
				break;
			if(cur.cost > dist[cur.name] + EPS)
				continue;
			for(Node nxt: adjlist[cur.name])
				if(cur.cost + nxt.cost + EPS < dist[nxt.name])
				{
					dist[nxt.name] = cur.cost + nxt.cost;
					pq.add(new Node(nxt.name, dist[nxt.name]));
				}
		}

		return dist[n-1];
	}

	static double f(int A, int B, double t) {
		return A*t + B;
	}

	static class Node implements Comparable<Node> {
		int name;
		double cost;

		public Node(int n, double c) {
			name = n;
			cost = c;
		}

		@Override
		public int compareTo(Node o) {
			if (Math.abs(cost - o.cost) < EPS)
				return 0;
			return cost > o.cost + EPS ? 1 : -1;
		}
	}

	static class Line {
		int u, v, A, B;

		public Line(int u, int v, int A, int B) {
			this.u = u;
			this.v = v;
			this.A = A;
			this.B = B;
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
