package UVa;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class AndysSecondDictionary {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		
		sc.waitForInput(3000);
		TreeSet<String> ts = new TreeSet<>();
		String temp = "";
		boolean flag = false;
		while(sc.Ready()) {
			String line = sc.nextLine();
			if (line.isEmpty()) continue;
			
			line = line.toLowerCase();
			flag = false;
			int len = line.length();
			for (int i = 0; i < len; i++) {
				if (line.charAt(i) >= 'a' && line.charAt(i) <= 'z') 
					temp += line.charAt(i);
				else if (line.charAt(i) == '-') {
					if (i != len - 1) 
						temp += line.charAt(i);
					else
						flag = true;
				}
				else {
 					if (!temp.isEmpty() && !ts.contains(temp)) 
						ts.add(temp);
					temp = "";
				}
			}
			
			if (flag)
				continue;
			if (!temp.isEmpty() && !ts.contains(temp)) 
				ts.add(temp);
			
			temp = "";
		}
		
		if (flag)
			temp += '-';
		if (!temp.isEmpty() && !ts.contains(temp))
			ts.add(temp);
		
		for (String s : ts)
			out.println(s);
		
		out.flush();
		out.close();
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
