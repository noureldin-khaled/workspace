package UVa;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class MutantFlatworldExplorers {
    static int arr[][];
    static int dx[] = {-1,0,1, 0};
    static int dy[] = { 0,1,0,-1};
    static String instructions;
    static int pos;
    static int index;
    static int finalX;
    static int finalY;
    static boolean lost;


    public static void main(String[] args) throws IOException {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	PrintWriter out = new PrintWriter(System.out);

	StringTokenizer st = new StringTokenizer(br.readLine());
	int columns = Integer.parseInt(st.nextToken());
	int rows = Integer.parseInt(st.nextToken());

	arr = new int[rows+1][columns+1];
	while(br.ready()) {
	    st = new StringTokenizer(br.readLine());
	    int initialY = Integer.parseInt(st.nextToken());
	    int initialX = rows - Integer.parseInt(st.nextToken());
	    String initialPos = st.nextToken();

	    finalX = initialX;
	    finalY = initialY;
	    pos = -1;
	    if (initialPos.equals("N"))
		pos = 0;
	    if (initialPos.equals("E"))
		pos = 1;
	    if (initialPos.equals("S"))
		pos = 2;
	    if (initialPos.equals("W"))
		pos = 3;
	    lost = false;
	    instructions = br.readLine();
	    index = 0;

	    traverse(initialX,initialY);
	    out.print(finalY + " " + (rows - finalX) + " " + getPos(pos));
	    if (lost)
		out.print(" LOST");
	    out.println();
	}
	out.flush();
	out.close();
    }

    public static void traverse(int x, int y) {
	for (; index < instructions.length(); index++) {
	    char c = instructions.charAt(index);
	    if (c == 'R'){
		pos++;
		if (pos == 4)
		    pos = 0;
	    }
	    else if (c == 'L'){
		pos--;
		if (pos == -1)
		    pos = 3;
	    }
	    else { // c == 'F'
		int newX = x + dx[pos];
		int newY = y + dy[pos];
		if (valid(newX, newY)) {
		    finalX = newX;
		    finalY = newY;
		    index++;
		    traverse(newX, newY);
		    break;
		}
		else {
		    if (arr[x][y] != -1) {
			finalX = x;
			finalY = y;
			arr[x][y] = -1;
			lost = true;
			break;
		    }
		}
	    }
	}

    }

    public static boolean valid(int x,int y) {
	return x >= 0 && x < arr.length && y >= 0 && y < arr[x].length;
    }

    public static char getPos(int num) {
	if (num == 0)
	    return 'N';
	else if (num == 1)
	    return 'E';
	else if (num == 2)
	    return 'S';
	else
	    return 'W';
    }

}
