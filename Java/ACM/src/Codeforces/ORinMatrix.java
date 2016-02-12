package Codeforces;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class ORinMatrix {
    static int res[][];
    static int arr[][];
    static ArrayList<Point> valid;
    static int m;
    static int n;

    public static void main(String[] args) throws NumberFormatException, IOException {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	StringBuilder out = new StringBuilder();

	StringTokenizer st = new StringTokenizer(br.readLine());
	m = Integer.parseInt(st.nextToken());
	n = Integer.parseInt(st.nextToken());
	arr = new int[m][n];

	ArrayList<Point> ones = new ArrayList<Point>();
	for (int i = 0; i < m; i++) {
	    st = new StringTokenizer(br.readLine());
	    for (int j = 0; j < n; j++) {
		int num = Integer.parseInt(st.nextToken());
		arr[i][j] = num;
		if (num == 1)
		    ones.add(new Point(i,j));
	    }
	}

	res = new int[m][n];

	valid = new ArrayList<Point>();

	for (int i = 0; i < ones.size(); i++) 
	    process(ones.get(i));

	for (int c = 0; c < valid.size(); c++) {
	    Point point = valid.get(c);
	    for (int j = point.y+1; j < n; j++)   //right
		if (res[point.x][j] == -1)
		    res[point.x][j] = 0;

	    for (int j = point.y-1; j >= 0; j--)  //left
		if (res[point.x][j] == -1)
		    res[point.x][j] = 0;

	    for (int i = point.x-1; i >= 0; i--)  //up
		if (res[i][point.y] == -1)
		    res[i][point.y] = 0;

	    for (int i = point.x+1; i < m; i++)   //down
		if (res[i][point.y] == -1)
		    res[i][point.y] = 0;
	}
	
	
	out.append("YES\n");
	for (int i = 0; i < m; i++) {
	    for (int j = 0; j < n; j++) {
		if (res[i][j] == -1) {
		    System.out.println("NO");
		    return;
		}
		out.append(res[i][j] + " ");
	    }
	    out.append("\n");
	}
	
	System.out.println(out);

    }

    public static void process(Point point) {
	for (int j = point.y+1; j < n; j++) { //right
	    if (arr[point.x][j] == 0) {
		res[point.x][point.y] = -1;
		return;
	    }
	}

	for (int j = point.y-1; j >= 0; j--) { //left
	    if (arr[point.x][j] == 0) {
		res[point.x][point.y] = -1;
		return;
	    }
	}

	for (int i = point.x-1; i >= 0; i--) { //up
	    if (arr[i][point.y] == 0) {
		res[point.x][point.y] = -1;
		return;
	    }
	}

	for (int i = point.x+1; i < m; i++) { //down
	    if (arr[i][point.y] == 0) {
		res[point.x][point.y] = -1;
		return;
	    }
	}

	res[point.x][point.y] = 1;
	valid.add(point);
    }

}
