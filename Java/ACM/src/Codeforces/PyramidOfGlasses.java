package Codeforces;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class PyramidOfGlasses {
	static ArrayList<Integer> adjlist[];
	static double perc[];

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt(), t = sc.nextInt();
		int size = (n*(n+1))/2;
		adjlist = new ArrayList[size];
		for (int i = 0; i < size; i++)
			adjlist[i] = new ArrayList<Integer>();

		int c = 0;
		for (int i = 1; i <= n; i++) {
			if (c+i >= size) break;
			for (int j = 0; j < i; j++) {
				adjlist[c].add(c+i);
				adjlist[c].add(c+i+1);
				c++;
			}
		}

		//		for (int i = 0; i<  size; i++)
		//			System.out.println(i + " : " + adjlist[i]);

		perc = new double[size];
		perc[0] = 100;
		c = 0;
		for (int i = 0; i < size; i++) {
			for (Integer v : adjlist[i]) 
				perc[v] += perc[i]/2;
		}

		double time[] = new double[size];
		for (int i = 0; i < size; i++) 
			time[i] += 100.0/perc[i];

		double arr[] = new double[size];
		arr[0] = 100.0*t;
		for (int i = 0; i < size; i++) {
			if (arr[i] > 100) {
				double rem = arr[i]-100;
				for (Integer v : adjlist[i])
					arr[v] += rem/2;
			}
		}
		
		long ans = 0;
		for (int i = 0; i < size; i++)
			if (arr[i] >= 100)
				ans++;
		
		System.out.println(ans);
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
