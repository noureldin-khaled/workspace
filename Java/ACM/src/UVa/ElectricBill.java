package UVa;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class ElectricBill {
	
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);

		while(true) {
			int A = sc.nextInt();
			int B = sc.nextInt();

			if (A == 0 && B == 0) break;

			out.println(binarySearch(A, B));
		}

		out.flush();
		out.close();
	}

	public static int binarySearch(int A, int B) {
		int low = 0;
		int high = A;
		int res = -1;
		
		while(low <= high) {
			int mid = low + (high - low)/2;

			int ans = f(mid, B);
			if (ans == A) {
				res = mid;
				low = mid+1;
			}
			else if (ans < A)
				low = mid+1;
			else
				high = mid-1;
		}

		return res;
	}

	public static int f(int mine, int B) {
		int neighbour = B+mine;

		int totalUsage = getUsage(mine) + getUsage(neighbour);

		return getBill(totalUsage);
	}

	public static int getBill(int usage) {
		int price = 0;

		if (usage > 0) {
			if (usage < 100) {
				price += 2*usage;
				usage = 0;
			}
			else {
				price += 200;
				usage -= 100;
			}
		}
		
		if (usage > 0) {
			if (usage < 9900) {
				price += 3*usage;
				usage = 0;
			}
			else {
				price += 29700;
				usage -= 9900;
			}
		}
		
		if (usage > 0) {
			if (usage < 990000) {
				price += 5*usage;
				usage = 0;
			}
			else {
				price += 4950000;
				usage -= 990000;
			}
		}
		
		
		if (usage > 0) {
			price += 7*usage;
			usage = 0;
		}

		return price;
	}

	public static int getUsage(int price) {
		int usage = 0;

		if (price > 0) {
			if (price < 200) {
				usage += Math.ceil((double)price/2);
				price = 0;
			}
			else {
				price -= 200;
				usage += 100;
			}
		}

		if (price > 0) {
			if (price < 29700) {
				usage += Math.ceil((double)price/3);
				price = 0;
			}
			else {
				price -= 29700;
				usage += 9900;
			}
		}

		if (price > 0) {
			if (price < 4950000) {
				usage += Math.ceil((double)price/5);
				price = 0;
			}
			else {
				price -= 4950000;
				usage += 990000;
			}
		}

		if (price > 0) {
			usage += Math.ceil((double)price/7);
			price = 0;
		}

		return usage;
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
