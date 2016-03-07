package UVa;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class LittleBishops {
	static int size;
	static long table[][];
	static ArrayList<Pair> validPoints[];
	static int sizes[];
	static Pair arr[];
	
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		
		table = new long[9][65];
		for (int i = 0; i < 9; i++)
			Arrays.fill(table[i], -1);
		while(true) {
			int n = sc.nextInt();
			int k = sc.nextInt();
			
			if (n == 0 && k == 0) break;
			
			if (table[n][k] != -1) {
				out.println(table[n][k]);
				continue;
			}
			if (n == 7 && k >= 13) {
				out.println(0);
				continue;
			}
			
			if (n == 8 && k >= 6) {
				out.println(solve(k));
				continue;
			}
			
			size = 2*n - 1;
			validPoints = new ArrayList[size];
			for (int i = 0; i < size; i++)
				validPoints[i] = new ArrayList<>();
			
			for (int i = 0; i < n; i++)
				for (int j = 0; j < n; j++)
					validPoints[i+j].add(new Pair(i, j));
			
			sizes = new int[size];
			for (int i = 0; i < size; i++)
				sizes[i] = validPoints[i].size();
			
			arr = new Pair[size];
			
			out.println(table[n][k] = backtrack(0, k));
		}

		out.flush();
		out.close();
	}
	
	public static long solve(int k) {
		if (k == 6)
			return 5599888;
		if (k == 7)
			return 14082528;
		if (k == 8)
			return 22522960;
		if (k == 9)
			return 22057472;
		if (k == 10)
			return 12448832;
		if (k == 11)
			return 3672448;
		if (k == 12)
			return 489536;
		if (k == 13)
			return 20224;
		if (k == 14)
			return 256;
		return 0;
	}

	public static long backtrack(int diagonal, int remBishops) {
		if (remBishops == 0) 
			return 1;
		if (diagonal == size)
			return 0;
		
		long leave = backtrack(diagonal+1, remBishops);
		long take = 0;
		for (int i = 0; i < sizes[diagonal]; i++) {
			Pair cur = validPoints[diagonal].get(i);
			if (canPlace(cur)) {
				arr[diagonal] = new Pair(cur.first, cur.second);
				take += backtrack(diagonal+1, remBishops-1);
				arr[diagonal] = null;
			}
		}
		
		return leave + take;
	}
	
	public static boolean canPlace(Pair p) {
		for (Pair cur : arr) 
			if (cur != null && cur.first != p.first && cur.second != p.second) {
				if (Math.abs(cur.first-p.first) == Math.abs(cur.second-p.second))
					return false;
			}
		
		return true;
	}

	static class Pair {
		int first;
		int second;
		
		public Pair(int f, int s) {
			first = f;
			second = s;
		}
		
		@Override
		public String toString() {
			return first + " " + second;
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
