package UVa;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class DemandingDilemma {

    public static void main(String[] args) throws IOException {
	Scanner sc = new Scanner(System.in);
	PrintWriter out = new PrintWriter(System.out);

	int t = sc.nextInt();
	while(t-->0) {
	    int v = sc.nextInt();
	    int e = sc.nextInt();

	    int input[][] = new int[v][e];
	    for (int i = 0; i < v; i++) 
		for (int j = 0; j < e; j++) 
		    input[i][j] = sc.nextInt();
	    
	    boolean valid = true;
	    for (int j = 0; j < e && valid; j++) {
		int count = 0;
		for (int i = 0; i < v; i++) 
		    count += input[i][j];
		
		valid = count == 2;
	    }

	    if (!valid) {
		out.println("No");
		continue;
	    }
	    
	    for (int i = 0; i < e && valid; i++) {
		for (int j = i+1; j < e && valid; j++) {
		    boolean equal = true;
		    for (int k = 0; k < v; k++) 
			if (input[k][i] != input[k][j])
			    equal = false;
		    if (equal)
			valid = false;
		}
	    }
	    
	    out.println(valid ? "Yes" : "No");
	}

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
