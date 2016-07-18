package Codeforces;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class MUHAndImportantThings {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		int n = sc.nextInt();
		Pair a[] = new Pair[n];
		for (int i = 0; i < n; i++)
			a[i] = new Pair(sc.nextInt(), i+1);
		Arrays.sort(a);
		
		sb.append("YES\n");
		for (int i = 0; i < n; i++) {
			if (i > 0)
				sb.append(" ");
			sb.append(a[i].index);
		}
		sb.append('\n');
		TreeSet<P> taken = new TreeSet<>();

		boolean found = false;
		for (int i = 0; i < n && !found; i++) {
			for (int j = 0; j < n && !found; j++) {
				if (i == j) continue;
				P p = new P(min(a[i].index, a[j].index), max(a[i].index, a[j].index));
				if (a[i].num == a[j].num && !taken.contains(p)) {
					Pair tmp = a[i];
					a[i] = new Pair(a[j].num, a[j].index);
					a[j] = new Pair(tmp.num, tmp.index);
					taken.add(p);
					found = true;
					i++;
				}
			}
		}
		
		
		if (!found) {
			System.out.println("NO");
			return;
		}
		
		for (int i = 0; i < n; i++) {
			if (i > 0)
				sb.append(" ");
			sb.append(a[i].index);
		}
		
		sb.append('\n');
		found = false;
		for (int i = 0; i < n && !found; i++) {
			for (int j = 0; j < n && !found; j++) {
				if (i == j) continue;
				P p = new P(min(a[i].index, a[j].index), max(a[i].index, a[j].index));
				if (a[i].num == a[j].num && !taken.contains(p)) {
					Pair tmp = a[i];
					a[i] = new Pair(a[j].num, a[j].index);
					a[j] = new Pair(tmp.num, tmp.index);
					taken.add(p);
					found = true;
					i++;
				}
			}
		}
		
		if (!found) {
			System.out.println("NO");
			return;
		}
		
		for (int i = 0; i < n; i++) {
			if (i > 0)
				sb.append(" ");
			sb.append(a[i].index);
		}

		System.out.println(sb);
	}
	
	static int min(int a, int b) {
		return Math.min(a ,b);
	}
	
	static int max(int a, int b) {
		return Math.max(a ,b);
	}
	
	static class P implements Comparable<P> {
		int first, second;
		public P(int f, int s) {
			first = s;
			second = s;
		}
		
		@Override
		public int compareTo(P o) {
			if (first != o.first)
				return first > o.first ? 1 : -1;
			if (second != o.second)
				return second > o.second ? 1 : -1;
			return 0;
		}
	}

	static class Pair implements Comparable<Pair> {
		int num, index;

		public Pair(int n, int i) {
			num = n;
			index = i;
		}

		@Override
		public int compareTo(Pair o) {
			if (num != o.num)
				return num > o.num ? 1 : -1;
			if (index != o.index)
				return index > o.index ? 1 : -1;
			return 0;
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
