package Codeforces;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ComparingTwoLongIntegers {

    public static void main(String[] args) throws IOException {
	Scanner sc = new Scanner(System.in);

	String a = sc.nextLine();
	String b = sc.nextLine();
	
	int len1 = a.length();
	int len2 = b.length();
	
	int index1 = 0;
	int index2 = 0;
	
	for (; index1 < len1; ++index1) {
	    if (a.charAt(index1) != '0')
		break;
	}
	
	for (; index2 < len2; ++index2) {
	    if (b.charAt(index2) != '0')
		break;
	}
	
	if ((len1 - index1) > (len2 - index2)) {
	    System.out.println(">");
	    return;
	}
	
	if ((len1 - index1) < (len2 - index2)) {
	    System.out.println("<");
	    return;
	}
	
 	while(index1 < len1 && index2 < len2) {
 	   int digit1 = a.charAt(index1) - '0';
 	   int digit2 = b.charAt(index2) - '0';
 	   
 	   if (digit1 > digit2) {
 	       System.out.println(">");
 	       return;
 	   }
 	   
 	   if (digit1 < digit2) {
 	       System.out.println("<");
 	       return;
 	   }
 	   ++index1;
 	   ++index2;
	}
 	
 	System.out.println("=");
	
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
