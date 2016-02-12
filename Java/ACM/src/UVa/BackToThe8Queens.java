package UVa;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BackToThe8Queens {
    static ArrayList<int[]> l;
    static int[] row;
    
    public static void main(String[] args) throws IOException {
	Scanner sc = new Scanner(System.in);
	PrintWriter out = new PrintWriter(System.out);
	
	l = new ArrayList<>();
	row = new int[8];
	backtracking(0);
	
	int size = l.size();
	int t = 1;
	
	while(sc.Ready()) {
	    int arr[] = new int[8];
	    for (int i = 0; i < 8; i++) 
		arr[i] = sc.nextInt() - 1;
	    
	    int min = -1;
	    for (int i = 0; i < size; i++) {
		int cur = moves(arr, l.get(i));		
		if (min == -1 || cur < min)
		    min = cur;
	    }
	    
	    out.printf("Case %d: %d\n",t, min);
	    t++;
	}

	out.flush();
	out.close();
    }
    
    public static int moves(int[] a, int[] b) {
	int count = 0;
	for (int i = 0; i < 8; i++) {
	    if (a[i] != b[i])
		count++;
	}
	return count;
    }

    public static void backtracking(int c) {
	if (c == 8) 
	    l.add(row.clone());
	
	for (int r = 0; r < 8; r++) {
	    if (canPlace(r, c)) {
		row[c] = r;
		backtracking(c + 1);
	    }
	}
    }


    public static boolean canPlace(int r, int c) {
	for (int prev = 0; prev < c; prev++) {
	    if (row[prev] == r || (Math.abs(row[prev] - r) == Math.abs(prev - c)))
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
