package Codeforces;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class GenasCode {

    public static void main(String[] args) throws IOException {
	Scanner sc = new Scanner(System.in);
	PrintWriter out = new PrintWriter(System.out);
	
	int n = sc.nextInt();
	String non_beautiful = "";
	int totalZeros = 0;
	for (int i = 0; i < n; i++) {
	    String num = sc.Next();
	    int len = num.length();


	    if (non_beautiful.isEmpty()) {
		if (!isBeautiful(num, len))
		    non_beautiful = num;
		else {
		    if (num.equals("0")) {
			System.out.println(0);
			return;
		    }
		    else
			totalZeros += len-1;
		}
	    }
	    else {
		if (num.equals("0")) {
		    System.out.println(0);
		    return;
		}
		else
		    totalZeros += len-1;
	    }
	}

	if (!non_beautiful.isEmpty())
	    out.print(non_beautiful);
	else
	    out.print(1);
	for (int i = 0; i < totalZeros; i++) {
	    out.print(0);
	}

	out.flush();
	out.close();
    }

    public static boolean isBeautiful(String num, int len) {
	int countOnes = 0;
	for (int i = 0; i < len; i++) {
	    if (num.charAt(i) == '1')
		countOnes++;
	    else if (num.charAt(i) != '0')
		return false;
	}
	return countOnes <= 1;
    }

    private static class Scanner {
	BufferedReader br;
	StringTokenizer st;

	public Scanner(FileReader f) {
	    br = new BufferedReader(f);
	}

	public Scanner(InputStream in) {
	    br = new BufferedReader(new InputStreamReader(in));
	}

	public String Next() throws IOException {
	    if (st == null || !st.hasMoreTokens())
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
