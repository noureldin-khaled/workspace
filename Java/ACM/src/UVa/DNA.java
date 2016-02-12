package UVa;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class DNA {
    static final char arr[] = {'A','C','G','T'};
    static ArrayList<char[]> res;
    static int n;

    public static void main(String[] args) throws IOException {
	Scanner sc = new Scanner(System.in);
	StringBuilder output = new StringBuilder();

	int t = sc.nextInt();
	while(t-->0) {
	    n = sc.nextInt();
	    int k = sc.nextInt();

	    String w = sc.Next();

	    char[] word = w.toCharArray();
	    res = new ArrayList<>();
	    
	    rec(0, word, k);

	    ArrayList<String> realRes = new ArrayList<>();
	    int size = res.size();
	    for (int i = 0; i < size; i++) {
		String temp = "";
		for (int j = 0; j < n; j++) {
		    temp += res.get(i)[j];
		}
		realRes.add(temp);
	    }

	    int realSize = realRes.size();
	    output.append(realSize + "\n");
	    for (int i = 0; i < realSize; i++) {
		output.append(realRes.get(i) + "\n");
	    }
	}

	System.out.print(output);
    }



    public static void rec(int i, char[] word, int count) {
	if (count == 0 || i == n) {
	    res.add(word.clone());
	    return;
	}
	
	for (int j = 0; j < 4; j++) {
	    if (arr[j] == word[i])
		rec(i+1, word.clone(), count);
	    else {
		char[] word2 = word.clone();
		word2[i] = arr[j];
		rec(i+1, word2, count-1);
	    }
	}
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

    }

}
