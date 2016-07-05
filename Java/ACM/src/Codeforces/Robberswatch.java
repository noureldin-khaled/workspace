package Codeforces;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Robberswatch {
	static int n, m;
	static final int digits[] = {0, 1, 2 , 3, 4, 5, 6};
	static int res[];
	static ArrayList<int[]> arr; 
	
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);

		n = sc.nextInt();
		m = sc.nextInt();
		int placesN = places(n), placesM = places(m);

		if (placesN + placesM > 7) {
			System.out.println(0);
			return;
		}
		
		res = new int[placesN+placesM];
		Arrays.fill(res, -1);
		arr = new ArrayList<>();
		generate(0, placesN+placesM, 0);
		
		long ans = 0;
		for (int i = 0; i < arr.size(); i++) {
			int cur[] = arr.get(i);
			do {
				String a = "";
				String b = "";
				
				int j = 0;
				for (; j < placesN; j++)
					a += cur[j];
				
				for (; j < placesN+placesM; j++)
					b += cur[j];
				
				if (valid(a, b))
					ans++;
			}while(nextPerm(cur));
		}
		
		out.println(ans);
		
		out.flush();
		out.close();
	}
	
	public static void generate(int index, int k, int i) {
		if (k == 0) {
			arr.add(res.clone());
			return;
		}
		if (index == 7)
			return;
		
		res[i] = digits[index];
		generate(index+1, k-1, i+1);
		res[i] = -1;
		generate(index+1, k, i);
	}
	
	public static boolean valid(String a, String b) {
		BigInteger b1 = new BigInteger(a, 7);
		BigInteger b2 = new BigInteger(b, 7);
		
		int num1 = Integer.parseInt(b1.toString(10));
		int num2 = Integer.parseInt(b2.toString(10));
		
		return num1 >= 0 && num1 < n && num2 >= 0 && num2 < m;
	}

	public static boolean nextPerm(int[] arr){
		int length = arr.length;
		int i = length - 2;
		for (; i >= 0; i--) {
			if (arr[i] < arr[i+1]){
				break;
			}
		}

		if (i == -1)
			return false;

		for (int j = length - 1; j > i; j--) {
			if (arr[j] > arr[i]){
				int tmp = arr[j];
				arr[j] = arr[i];
				arr[i] = tmp;
				break;
			}
		}

		int s = i+1;
		int e = length -1;

		while (s < e){
			int tmp = arr[s];
			arr[s] = arr[e];
			arr[e] = tmp;
			s++;
			e--;
		}

		return true;
	}

	public static int places(int a) {
		return BigInteger.valueOf(a-1).toString(7).length();
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
