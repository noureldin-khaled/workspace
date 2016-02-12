package UVa;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class WordIndex {
    static TreeMap<String, Integer> tm;
    static int count;

    public static void main(String[] args) throws IOException {
	Scanner sc = new Scanner(System.in);
	PrintWriter out = new PrintWriter(System.out);

	tm = new TreeMap<>();
	count = 1;
	go("a", 0);
	go("ab", 0);
	go("abc", 0);
	go("abcd", 0);
	go("abcde", 0);
	
	sc.waitForInput(3000);
	while(sc.Ready()) {
	    String word = sc.Next();
	    if (tm.containsKey(word))
		out.println(tm.get(word));
	    else
		out.println(0);
	}

	out.flush();
	out.close();
    }

    public static void go(String s, int index) {
	if (index == s.length()) {
	    if (valid(s)) 
		tm.put(s, count++);
	    return;
	}

	for (int i = 0; i < 26; i++) {
	    char add = (char) (i+'a');
	    char temp[] = s.toCharArray();
	    temp[index] = add;
	    s = String.valueOf(temp);
	    go(s, index+1);
	}
    }


    public static boolean valid(String s) {
	for (int i = 0; i < s.length()-1; i++) {
	    if (s.charAt(i+1) <= s.charAt(i))
		return false;
	}
	return true;
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
