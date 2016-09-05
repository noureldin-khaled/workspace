package Codeforces;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BitStringReordering {
	static int b[];
	static int n, m;
	
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		m = sc.nextInt();
		b = new int[m];
		
		int start = 0;
		for (int i = 0; i < n; i++) {
			int a= sc.nextInt();
			start += a;
			start <<= 1;
		}
		start >>= 1;	
		
		for (int i = 0; i < m; i++)
			b[i] = sc.nextInt();
		
		
		System.out.println(f(start));
	}
	
	static long f(int s) {
		Queue<Integer> q = new LinkedList<>();
		long dist[] = new long[32768+5];
		Arrays.fill(dist, -1);
		q.add(s);
		dist[s] = 0;
		
		while(!q.isEmpty()) {
			int cur = q.remove();
			if (valid(cur))
				return dist[cur];
			
			for (int i = 0; i < n-1; i++) {
				int nxt = swap(cur, n-i-1);
				if (dist[nxt] == -1) {
					dist[nxt] = dist[cur] + 1;
					q.add(nxt);
				}
			}
		}
		
		return -1;
	}
	
	static int swap(int num, int i) {
		boolean b1 = (num & (1 << i)) == 0 ? false : true;
		boolean b2 = (num & (1 << (i-1))) == 0 ? false : true;
		int res = num;
		if (b2)
			res |= (1 << i);
		else
			res &= ~(1 << i);
		
		if (b1)
			res |= (1 << (i-1));
		else
			res &= ~(1 << (i-1));
		
		return res;
	}
	
	static boolean valid(int num) {
		ArrayList<Integer> al = new ArrayList<Integer>();
		Boolean prev = null;
		int c = 0;
		for (int i = 0; i < n; i++) {
			int idx = n-i-1;
			boolean bit = (num & (1 << idx)) == 0 ? false : true;
			if (prev != null) {
				if (bit != prev) {
					al.add(c);
					c = 1;
				}
				else 
					c++;
			}
			else
				c++;
			
			prev = bit;
		}
		
		if (c > 0)
			al.add(c);
		
		int len = al.size();
		if (len != m)
			return false;
		
		for (int i = 0; i < m; i++)
			if (al.get(i) != b[i])
				return false;
		return true;
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
