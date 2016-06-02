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
import java.util.Stack;
import java.util.StringTokenizer;

public class CorrectBracketSequenceEditor {	

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		int n = sc.nextInt(), m = sc.nextInt(), p = sc.nextInt()-1;
		char[] sequence = sc.nextLine().toCharArray();
		char[] instructions = sc.nextLine().toCharArray();

		int pairs[] = new int[n];
		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i < n; i++) {
			if (sequence[i] == '(') 
				stack.push(i);
			else {
				int index = stack.pop();
				pairs[index] = i;
				pairs[i] = index;
			}
		}

		int left[] = new int[n];
		int right[] = new int[n];

		for (int i = 0; i < n; i++) {
			if (i == 0)
				left[i] = -1;
			else
				left[i] = i-1;

			if (i == n-1)
				right[i] = -1;
			else
				right[i] = i+1;
		}
		
		int start = 0;
		for (int i = 0; i < m; i++) {
			if (instructions[i] == 'L') 
				p = left[p];
			else if (instructions[i] == 'R') 
				p = right[p];
			else {
				int l = p;
				int r = pairs[p];

				if (l > r) {
					int temp = l;
					l = r;
					r = temp;
				}
				
				if (l == start)
					start = right[r];
				
				if (left[l] != -1)
					right[left[l]] = right[r];
				if (right[r] != -1)
					left[right[r]] = left[l];
				
				if (right[r] != -1)
					p = right[r];
				else
					p = left[l];
			}
		}
		
		while(start != -1) {
			sb.append(sequence[start]);
			start = right[start];
		}
		
		System.out.println(sb);
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
