package UVa;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

public class BrokenKeyboard {

    public static void main(String[] args) throws IOException {
	Scanner sc = new Scanner(System.in);
	PrintWriter out = new PrintWriter(System.out);

	while(sc.Ready()) {
	    String line = sc.nextLine();
	    ArrayList<StringBuilder> end = new ArrayList<>();
	    Stack<StringBuilder> begin = new Stack<>();
	    boolean e = true;

	    StringBuilder temp = new StringBuilder();
	    for (int i = 0; i < line.length(); i++) {
		if (line.charAt(i) == '[') {
		    if (e)
			end.add(temp);
		    else
			begin.push(temp);
		    e = false;
		    temp = new StringBuilder();
		}
		else if (line.charAt(i) == ']') {
		    if (e)
			end.add(temp);
		    else
			begin.push(temp);
		    e = true;
		    temp = new StringBuilder();
		}
		else 
		    temp.append(line.charAt(i));
	    }

	    if (!temp.equals("")) {
		if (e)
		    end.add(temp);
		else
		    begin.push(temp);
	    }

	    while(!begin.isEmpty())
		out.print(begin.pop());

	    for (int i = 0; i < end.size(); i++) 
		out.print(end.get(i));
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
