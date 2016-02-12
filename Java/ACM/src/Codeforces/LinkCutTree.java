package Codeforces;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class LinkCutTree {

    public static void main(String[] args) throws IOException {
	Scanner sc = new Scanner(System.in);
	PrintWriter out = new PrintWriter(System.out);

	long l = sc.nextLong();
	long r = sc.nextLong();
	long k = sc.nextLong();

	ArrayList<Long> res = new ArrayList<>();
	if (1 >= l && 1 <= r)
	    res.add((long) 1);

	BigInteger r_int = BigInteger.valueOf(r);
	BigInteger l_int = BigInteger.valueOf(l);
	BigInteger k_int = BigInteger.valueOf(k);
	BigInteger val = BigInteger.valueOf(k);
	while (val.compareTo(r_int) <= 0) {
	    if (val.compareTo(l_int) >= 0 && val.compareTo(r_int) <= 0)
		res.add(val.longValue());

	    val = val.multiply(k_int);
	}

	int size = res.size();

	if (size == 0)
	    out.println(-1);
	else {
	    for (int i = 0; i < size; i++) {
		if (i == size-1)
		    out.print(res.get(i));
		else
		    out.print(res.get(i) + " ");
	    }
	}

	out.flush();
	out.close();
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
