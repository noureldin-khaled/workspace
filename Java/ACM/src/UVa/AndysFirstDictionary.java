package UVa;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class AndysFirstDictionary {

    public static void main(String[] args) throws IOException {
	Scanner sc = new Scanner(System.in);
	PrintWriter out = new PrintWriter(System.out);

	sc.waitForInput(3000);
	TreeSet<String> ts = new TreeSet<>();
	ArrayList<String> res = new ArrayList<>();
	while(sc.Ready()) {
	    String line = sc.nextLine();
	    if (line.isEmpty()) continue;

	    line = line.toLowerCase();

	    String temp = "";
	    for (int i = 0; i < line.length(); i++) {
		if ((line.charAt(i) >= 'a' && line.charAt(i) <= 'z')) {
		    temp += line.charAt(i);
		}
		else {
		    if (!temp.isEmpty() && !ts.contains(temp)) {
			res.add(temp);
			ts.add(temp);
		    }
		    temp = "";
		}
	    }

	    if (!temp.isEmpty()) {
		if (!ts.contains(temp)) {
		    res.add(temp);
		    ts.add(temp);
		}
	    }
	}

	Collections.sort(res);

	for (int i = 0; i < res.size(); i++) { 
	    out.println(res.get(i));
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
