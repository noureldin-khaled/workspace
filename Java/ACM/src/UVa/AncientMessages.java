package UVa;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class AncientMessages {
    static int arr[][];
    static int count;
    static int index;
    static int dx[] = {-1,0,1, 0};
    static int dy[] = { 0,1,0,-1};
    static int dx2[] = {1,0,-1,0,1,1,-1,-1};
    static int dy2[] = {0,1,0,-1,1,-1,1,-1}; 
    static final char symbols[] = {'W','A','K','J','S','D'};
    static boolean valid;

    public static void main(String[] args) throws IOException {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	PrintWriter out = new PrintWriter(System.out);
	int t = 1;
	while(true) {
	    String line = br.readLine();
	    if (line.equals("0 0"))
		break;
	    StringTokenizer st = new StringTokenizer(line);
	    int h = Integer.parseInt(st.nextToken());
	    int w = Integer.parseInt(st.nextToken());

	    arr = new int[h][w*4];
	    for (int i = 0; i < h; i++) {
		String s = br.readLine();
		BigInteger b = new BigInteger(s,16);
		s = b.toString(2);
		int len = s.length();
		for (int j = 0; j < len; j++) 
		    arr[i][j+w*4-len] = s.charAt(j)-'0';

	    }
	    ArrayList<Character> res = new ArrayList<>();
	    index = 2;
	    for (int i = 0; i < h; i++) {
		for (int j = 0; j < w*4; j++) {
		    if (arr[i][j] == 1) {
			count = 0;
			dfs(i,j);
			index++;
			res.add(symbols[count]);
		    }
		}
	    }
	    Collections.sort(res);
	    out.printf("Case %d: ", t);
	    for (int i = 0; i < res.size(); i++) {
		out.print(res.get(i));
	    }
	    out.println();
	    t++;
	}
	out.flush();
	out.close();

    }

    public static void dfs(int i, int j) {
	arr[i][j] = index;

	for (int k = 0; k < 4; k++) {
	    int newI = i + dx[k];
	    int newJ = j + dy[k];

	    if (newI >= 0 && newI < arr.length && newJ >= 0 && newJ < arr[newI].length) {
		if (arr[newI][newJ] == 1)
		    dfs(newI, newJ);
		else if (arr[newI][newJ] == 0) {
		    valid = true;
		    dfs2(newI,newJ);
		    if (valid)
			count++;
		}
	    }
	}

    }

    public static void dfs2(int i, int j) {
	arr[i][j] = -1;

	for (int k = 0; k < 8; k++) {
	    int newI = i + dx2[k];
	    int newJ = j + dy2[k];

	    if (newI >= 0 && newI < arr.length && newJ >= 0 && newJ < arr[newI].length) {
		if (arr[newI][newJ] == 0) 
		    dfs2(newI, newJ);
	    }
	    else
		valid = false;

	}
    }

}
