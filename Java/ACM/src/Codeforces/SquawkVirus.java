package Codeforces;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SquawkVirus {
	
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(), m = sc.nextInt(), s = sc.nextInt(), t = sc.nextInt();
		
		ArrayList<Integer> adjlist[] = new ArrayList[n];
		for (int i = 0; i < n; i++)
			adjlist[i] = new ArrayList<>();
		
		for (int i = 0; i<  m; i++) {
			int u = sc.nextInt(), v = sc.nextInt();
			adjlist[u].add(v);
			adjlist[v].add(u);
		}
		
		Queue<Virus> q = new LinkedList<>();
		BigInteger a[] = new BigInteger[n];
		for (int i = 0; i < n; i++)
			a[i] = BigInteger.ZERO;
		q.add(new Virus(s, BigInteger.ONE));
		a[s] = BigInteger.ONE;
		while(t-->0) {
			ArrayList<Virus> al = new ArrayList<>();
			while(!q.isEmpty()) {
				Virus v = q.remove();
				a[v.node] = BigInteger.ZERO;
				al.add(v);
			}
			
			for (int i = 0; i < al.size(); i++) {
				Virus cur = al.get(i);
				for (int j = 0; j < adjlist[cur.node].size(); j++) {
					int v = adjlist[cur.node].get(j);
					a[v] = a[v].add(cur.sq);
				}
			}
			
			for (int i = 0; i < n; i++)
				if (a[i].compareTo(BigInteger.ZERO) > 0)
					q.add(new Virus(i, a[i]));
			
		}
		BigInteger sum = BigInteger.ZERO;
		for (int i = 0; i < n; i++)
			sum = sum.add(a[i]);
		System.out.println(sum);
		
	}
	
	static class Virus {
		int node;
		BigInteger sq;
		
		public Virus(int n, BigInteger s) {
			node = n;
			sq = s;
		}
		@Override
		public String toString() {
			return "(" + node + ", " + sq + ")";
		}
	}
	
	static class Scanner {
		BufferedReader br;
		StringTokenizer st;
		
		public Scanner(InputStream in) {
			br = new BufferedReader(new InputStreamReader(in));
		}
		
		public String next() throws Exception {
			while(st == null || !st.hasMoreTokens())
				st = new StringTokenizer(br.readLine());
			return st.nextToken();
		}
		
		public int nextInt() throws Exception {
			return Integer.parseInt(next());
		}
	}
}
