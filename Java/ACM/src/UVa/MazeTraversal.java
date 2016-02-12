package UVa;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class MazeTraversal {
    static char arr[][];
    static String instructions;
    static int finalX;
    static int finalY;
    static int index;
    static int length;
    static int dx[] = {-1,0,1, 0};
    static int dy[] = { 0,1,0,-1};
    static int direction;
    
    public static void main(String[] args) throws NumberFormatException, IOException {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	PrintWriter out = new PrintWriter(System.out);
	
	int t = Integer.parseInt(new StringTokenizer((br.readLine())).nextToken());
	while(t-->0) {
	    br.readLine();
	    StringTokenizer st = new StringTokenizer(br.readLine());
	    int n = Integer.parseInt(st.nextToken());
	    int m = Integer.parseInt(st.nextToken());
	    
	    arr = new char[n][m];
	    for (int i = 0; i < n; i++) {
		String line = br.readLine();
		for (int j = 0; j < m; j++) 
		    arr[i][j] = line.charAt(j);
	    }

	    st = new StringTokenizer(br.readLine());
	    int startX = Integer.parseInt(st.nextToken())-1;
	    int startY = Integer.parseInt(st.nextToken())-1;

	    instructions = "";
	    boolean done = false;
	    while(!done) {
		st = new StringTokenizer(br.readLine());
		while(st.hasMoreTokens()) {
		    String line = st.nextToken();
		    for (int i = 0; i < line.length(); i++) {
			if (line.charAt(i) == 'Q') {
			    done = true;
			    break;
			}
			instructions += line.charAt(i);
		    }
		}
	    }
	    
	   
	    length = instructions.length();
	    finalX = startX;
	    finalY = startY;
	    index = 0;
	    direction = 0;
	    
	    traverse(startX,startY);
	    char c = ' ';
	    if (direction == 0)
		c = 'N';
	    if (direction == 1)
		c = 'E';
	    if (direction == 2)
		c = 'S';
	    if (direction == 3)
		c = 'W';
	
	    finalX++;
	    finalY++;
	    out.println(finalX + " " + finalY + " " + c);
	    if (t > 0)
		out.println();
	}

	out.flush();
	out.close();
    }
    
    public static void traverse(int i, int j) {
	finalX = i;
	finalY = j;
	for (; index < length; index++) {
	    char c = instructions.charAt(index);
	    if (c == 'R') {
		direction++;
		if (direction == 4)
		    direction = 0;
		
	    }
	    else if (c == 'L') {
		direction--;
		if (direction == -1)
		    direction = 3;
		
	    } 
	    else if (c == 'F'){
		int newI = i + dx[direction];
		int newJ = j + dy[direction];
		
		if (newI >= 0 && newI < arr.length && newJ >= 0 && newJ < arr[newI].length && arr[newI][newJ] != '*') {
		    index++;
		    traverse(newI, newJ);
		    break;
		}
	    }
	    
	}
    }

}
