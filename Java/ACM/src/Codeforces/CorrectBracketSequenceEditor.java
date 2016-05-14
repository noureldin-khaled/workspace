package Codeforces;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class CorrectBracketSequenceEditor {
	static ArrayList<Pair> close;
	static boolean[] taken;
	

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);

		int n = sc.nextInt(), m = sc.nextInt(), p = sc.nextInt()-1;
		String line = sc.nextLine();
		String instructions = sc.nextLine();

		close = new ArrayList<Pair>();
		ArrayList<Pair> open = new ArrayList<Pair>();
		
		int c = 0;
		for (int i = 0; i < n; i++) {
			if (line.charAt(i) == '(') {
				c++;
				open.add(new Pair(c, i));
			}
			else {
				c--;
				close.add(new Pair(c, i));
			}
		}

		Collections.sort(close);
		int pairs[] = new int[n];
		
		int len = close.size();
		taken = new boolean[len];
		for (int i = 0; i < open.size(); i++) {
			Pair cur = open.get(i);
			int closed = binarySearch(cur.count-1, cur.index, len);
			pairs[closed] = cur.index;
			pairs[cur.index] = closed;
		}
		
//		for (int i = 0; i < n; i++)
//			System.out.println(i + " : " + pairs[i]);
		
		int[] go = new int[n];
		Arrays.fill(go, -1);
		
		for (int i = 0; i < m; i++) {
			char command = instructions.charAt(i);
			if (command == 'R') {
				if (go[p+1] == -1)
					p++;
				else 
					p = go[p+1];
			}
			else if (command == 'L') {
				if (go[p-1] == -1)
					p--;
				else 
					p = go[p-1];
			}
			else {
				if (line.charAt(p) == '(') {
					go[p] = pairs[p]+1;
					go[pairs[p]] = p-1;
					if (go[p] < n && go[go[p]] != -1)
						go[p] = go[go[p]];
					
					if (go[pairs[p]] >= 0 && go[go[pairs[p]]] != -1)
						go[pairs[p]] = go[go[pairs[p]]];
					
					if (go[p] < n)
						p = go[p];
					else
						p = go[pairs[p]];
				}
				else {
					go[p] = pairs[p]-1;
					go[pairs[p]] = p+1;
					
					if (go[p] >= 0 && go[go[p]] != -1)
						go[p] = go[go[p]];
					
					if (go[pairs[p]] < n && go[go[pairs[p]]] != -1)
						go[pairs[p]] = go[go[pairs[p]]];
					
					if (go[pairs[p]] < n)
						p = go[pairs[p]];
					else
						p = go[p];
				}
			}
		}

		int i = 0;
		while(i < n) {
			if (go[i] == -1) {
				out.print(line.charAt(i));
				i++;
			}
			else 
				i = go[i];
		}

		out.flush();
		out.close();
	}

	public static int binarySearch(int target, int i, int len) {
		int low = 0;
		int high = len-1;
		int ans = -1;
		
		while(low <= high) {
			int mid = low + (high-low)/2;
			
			if (close.get(mid).count == target && close.get(mid).index > i && !taken[mid]) {
				ans = mid;
				high = mid - 1;
			}
			else if (close.get(mid).count > target)
				high = mid - 1;
			else
				low = mid + 1;
		}
		
		taken[ans] = true;
		return close.get(ans).index;
	}

	static class Pair implements Comparable<Pair>{
		int count, index;

		public Pair(int c, int i) {
			count = c;
			index = i;
		}

		@Override
		public int compareTo(Pair o) {
			if (count != o.count)
				return count - o.count;
			return index - o.index;
		}

		@Override
		public String toString() {
			return "(" + count + ", " + index + ")";
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
