package UVa;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Genes {
    static Pair parents[];
    static String status[];
    static TreeMap<String, Integer> tm;
    
    public static void main(String[] args) throws Exception {
	Scanner sc = new Scanner(System.in);
	PrintWriter out = new PrintWriter(System.out);

	int n = sc.nextInt();
	status = new String[n];
	parents = new Pair[n];
	ArrayList<Result> res = new ArrayList<Result>();
	tm = new TreeMap<>();
	String[] names = new String[n];
	
	for (int i = 0; i < n; i++) {
	    String first = sc.Next();
	    String second = sc.Next();

	    if (second.equals("dominant") || second.equals("recessive") || second.equals("non-existent")) {
		tm.put(first, i);
		names[i] = first;
		status[i] = second;
		res.add(new Result(first, second));
	    }
	    else {
		int index = i;
		if (!tm.containsKey(second)) {
		    tm.put(second, i);
		    names[i] = second;
		    parents[i] = new Pair();
		}
		else
		    index = tm.get(second);
		
		parents[index].addParent(first);
	    }
	}
	
	for (int i = 0; i < n; i++) 
	    if (parents[i] != null) 
		res.add(new Result(names[i], getStatus(i)));
	
	Collections.sort(res);
	for (int i = 0; i < res.size(); i++) 
	    out.println(res.get(i).name + " " + res.get(i).gene);

	out.flush();
	out.close();
    }
    
    public static String getStatus(int i) {
	if (status[i] != null)
	    return status[i];
	
	int parent1 = tm.get(parents[i].first);
	int parent2 = tm.get(parents[i].second);
	
	status[parent1] = getStatus(parent1);
	status[parent2] = getStatus(parent2);
	
	return status[i] = getType(status[parent1], status[parent2]);
    }

    public static String getType(String p1, String p2) {
	if (p1.equals(p2))
	    return p1;
	if ((p1.equals("dominant") && p2.equals("non-existent"))
		|| (p2.equals("dominant") && p1.equals("non-existent")))
		return "recessive";
	
	if ((p1.equals("dominant") && p2.equals("recessive"))
		|| (p2.equals("dominant") && p1.equals("recessive")))
		return "dominant";
	
	if ((p1.equals("non-existent") && p2.equals("recessive"))
		|| (p2.equals("non-existent") && p1.equals("recessive")))
		return "non-existent";
	
	return null;
    }

    static class Result implements Comparable<Result> {
	String name;
	String gene;
	public Result(String n, String g) {
	    name = n;
	    gene = g;
	}
	@Override
	public int compareTo(Result o) {
	    return name.compareTo(o.name);
	}
    }

    static class Pair {
	String first;
	String second;
	public Pair() {
	    first = null;
	    second = null;
	}

	public void addParent(String name) {
	    if (first == null)
		first = name;
	    else second = name;
	}
	
	@Override
	public String toString() {
	    return "(" + first + ", " + second + ")";
	}
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
