package UVa;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class ShellSort {

    public static void main(String[] args) throws IOException {
	Scanner sc = new Scanner(System.in);
	PrintWriter out = new PrintWriter(System.out);
	
	int t = sc.nextInt();
	while(t-->0) {
	    int n = sc.nextInt();

	    String initial[] = new String[n];
	    String desired[] = new String[n];
	    
	    
	    for (int i = 0; i < n; i++) {
		String turtle = sc.nextLine();
		initial[i] = turtle;
	    }
	    
	    for (int i = 0; i < n; i++) {
		String turtle = sc.nextLine();
		desired[i] = turtle;
	    }
	    
	    int initialPointer = initial.length-1;
	    int desiredPointer = desired.length-1;
	    
	    while(initialPointer >= 0) {
		if (initial[initialPointer].equals(desired[desiredPointer])) {
		    initialPointer--;
		    desiredPointer--;
		}
		else 
		    initialPointer--;
	    }
	    
	    for (; desiredPointer >= 0; desiredPointer--) 
		out.println(desired[desiredPointer]);
	    
	    out.println();
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
