package Codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class CleanerRobot {
    static char arr[][];
    static int dx[] = {-1,0,1, 0};
    static int dy[] = { 0,1,0,-1};
    static int count;
    static TreeSet<Integer> visited[][];
    static int direction;

    public static void main(String[] args) throws IOException {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	StringTokenizer st = new StringTokenizer(br.readLine());
	int r = Integer.parseInt(st.nextToken());
	int c = Integer.parseInt(st.nextToken());

	arr = new char[r][c];

	int startX = -1;
	int startY = -1;
	direction = -1;
	for (int i = 0; i < r; i++) {
	    String line = br.readLine();
	    for (int j = 0; j < c; j++) {
		arr[i][j] = line.charAt(j);
		if (arr[i][j] == 'U') {
		    startX = i;
		    startY = j;
		    direction = 0;
		}
		if (arr[i][j] == 'R') {
		    startX = i;
		    startY = j;
		    direction = 1;
		}
		if (arr[i][j] == 'D') {
		    startX = i;
		    startY = j;
		    direction = 2;
		}
		if (arr[i][j] == 'L') {
		    startX = i;
		    startY = j;
		    direction = 3;
		}
	    }
	}

	count = 1;
	visited = new TreeSet[r][c];
	for (int i = 0; i < r; i++) 
	    for (int j = 0; j < c; j++) 
		visited[i][j] = new TreeSet<Integer>();
	
	traverse(startX,startY);
	System.out.println(count);

    }

    public static void traverse(int i, int j) {
	if (!visited[i][j].contains(direction)) {
	    visited[i][j].add(direction);
	    if (arr[i][j] == '.') {
		count++;
		arr[i][j] = 'v';
	    }
	    
	    int newI = i + dx[direction];
	    int newJ = j + dy[direction];
	    
	    if (newI >= 0 && newI < arr.length && newJ >= 0 && newJ < arr[newI].length && arr[newI][newJ] != '*') {
		traverse(newI, newJ);
	    }
	    else {
		direction++;
		if (direction == 4)
		    direction = 0;
		traverse(i, j);
	    }
	}
    }

}
