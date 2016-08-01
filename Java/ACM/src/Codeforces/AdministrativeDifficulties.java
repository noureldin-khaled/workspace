package Codeforces;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class AdministrativeDifficulties {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);

		int t = sc.nextInt();
		while(t-->0) {
			int n = sc.nextInt(), m = sc.nextInt();
			Car cars[] = new Car[n];
			TreeMap<String, Integer> carTm = new TreeMap<>();
			for (int i = 0; i < n; i++) {
				String name = sc.next();
				carTm.put(name, i);
				cars[i] = new Car(sc.nextLong(), sc.nextLong(), sc.nextLong());
			}

			String[] in = new String[m];
			TreeMap<String, Integer> driverTm = new TreeMap<>();
			TreeMap<Integer, String> names = new TreeMap<>();
			int index = 0;
			for (int i = 0; i < m; i++) {
				String line = sc.nextLine();
				in[i] = line;
				StringTokenizer st = new StringTokenizer(line);
				st.nextToken();
				String name = st.nextToken();
				if (!driverTm.containsKey(name)) {
					driverTm.put(name, index);
					names.put(index++, name);
				}
			}

			int s = driverTm.size();
			int p[] = new int[s];
			Arrays.fill(p, -1);
			boolean r[] = new boolean[s];
			Arrays.fill(r, true);
			long c[] = new long[s];
			boolean valid[] = new boolean[s];
			Arrays.fill(valid, true);
			boolean carTaken[] = new boolean[n];

			for (int i = 0; i < m; i++) {
				StringTokenizer st = new StringTokenizer(in[i]);

				st.nextToken();
				int idx = driverTm.get(st.nextToken());
				char action = st.nextToken().charAt(0);
				if (!valid[idx]) continue;
				if (action == 'p') {
					if (p[idx] != -1)
						valid[idx] = false;
					else {
						String carName = st.nextToken();
						int carIdx = carTm.get(carName);
						if (carTaken[carIdx])
							valid[idx] = false;
						else {
							p[idx] = carIdx;
							c[idx] += cars[carIdx].pick_up;
							r[idx] = false;
						}
					}
				}
				else {
					if (p[idx] == -1)
						valid[idx] = false;
					else if (action == 'a') {
						long k = Long.parseLong(st.nextToken());
						c[idx] += (long)Math.ceil(getFine(cars[p[idx]].price, k));
					}
					else {
						r[idx] = true;
						long d = Long.parseLong(st.nextToken());
						c[idx] += d * cars[p[idx]].price_per_kilo;
						carTaken[p[idx]] = false;
						p[idx] = -1;
					}
				}
			}

			Result[] o = new Result[s];
			for (int i = 0; i < s; i++) {
				if (valid[i] && r[i])
					o[i] = new Result(names.get(i), c[i]);
				else
					o[i] = new Result(names.get(i), -1);
			}

			Arrays.sort(o);
			for (int i = 0; i < s; i++) {
				out.print(o[i].name + " ");
				if (o[i].cost == -1)
					out.print("INCONSISTENT");
				else
					out.print(o[i].cost);
				out.println();
			}

		}

		out.flush();
		out.close();
	}

	static double getFine(long a, long p) {
		return (a * p)/100.0;
	}

	static class Result implements Comparable<Result> {
		String name;
		long cost;

		public Result(String n, long c) {
			name = n;
			cost = c;
		}

		@Override
		public int compareTo(Result o) {
			return name.compareTo(o.name);
		}
	}

	static class Car {
		long price, pick_up, price_per_kilo;

		public Car(long p, long pu, long ppk) {
			price = p;
			pick_up = pu;
			price_per_kilo = ppk;
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
