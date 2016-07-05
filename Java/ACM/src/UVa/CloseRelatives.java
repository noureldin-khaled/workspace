package UVa;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class CloseRelatives {
	static ArrayList<Integer> adjlist[];
	static StringBuilder sbleft;
	static StringBuilder sbright;
	static TreeMap<Integer, String> tmRev;
	
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		
		sc.waitForInput(3000);
		TreeMap<String, Integer> tm = new TreeMap<>();
		tmRev = new TreeMap<>();
		
		adjlist = new ArrayList[6000];
		for (int i =0 ; i < 6000; i++)
			adjlist[i] = new ArrayList<>();
		
		int c = 0;
		int parent[] = new int[6000];
		Arrays.fill(parent, -1);
		while(sc.Ready()) {
			String[] s = sc.next().split(",");
			String st = s[0];
			int u = c;
			if (tm.containsKey(st))
				u = tm.get(st);
			else {
				tm.put(st, c);
				tmRev.put(c++, st);
			}
			for (int i = 1; i < s.length; i++) {
				String str = s[i];
				int v = c;
				if (tm.containsKey(str))
					v = tm.get(str);
				else {
					tm.put(str, c);
					tmRev.put(c++, str);
				}
				
				adjlist[u].add(v);
				adjlist[v].add(u);
				parent[v] = u;
			}
		}
		
		int root = -1;
		for (int i = 0; i < c; i++)
			if (parent[i] == -1) {
				root = i;
				break;
			}
		
		sbleft = new StringBuilder();
		sbright = new StringBuilder();
		
		dfsLeft(root, -1);
		dfsRight(root, -1);
		
		String left = sbleft.toString();
		String right = sbright.toString();
		if (left.equals(right)) {
			System.out.println(1 + "\n");
			System.out.print(left);
		}
		else {
			System.out.println(2 + "\n");
			System.out.println(left);
			System.out.print(right);
		}
	}
	
	public static void dfsLeft(int u, int p) {
		for (int i = 0; i < adjlist[u].size(); i++) {
			int v = adjlist[u].get(i);
			if (v != p)
				dfsLeft(v, u);
		}
		
		sbleft.append(tmRev.get(u) + '\n');
	}
	
	public static void dfsRight(int u, int p) {
		for (int i = adjlist[u].size()-1; i >= 0; i--) {
			int v = adjlist[u].get(i);
			if (v != p)
				dfsRight(v, u);
		}
		
		sbright.append(tmRev.get(u) + '\n');
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
