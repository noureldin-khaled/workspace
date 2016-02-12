package UVa;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class GraphConnectivity {
    static ArrayList<Integer> arr[];
    static boolean visited[];

    public static void main(String[] args) throws NumberFormatException, IOException {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	int t = Integer.parseInt(br.readLine());

	br.readLine();
	while(t-->0){

	    String s = br.readLine();
	    int n = s.charAt(0) - 'A';
	    n++;

	    arr = new ArrayList[n];
	    for (int i = 0; i < arr.length; i++) 
		arr[i] = new ArrayList<Integer>();

	    while(br.ready()){
		String line = br.readLine();
		if (line.isEmpty() || line == null)
		    break;
		int first = line.charAt(0) - 'A';
		int second = line.charAt(1) - 'A';

		arr[first].add(second);
		arr[second].add(first);
	    }

	    visited = new boolean[n];
	    int count = 0;
	    for (int i = 0; i < visited.length; i++) {
		if (!visited[i]){
		    count++;
		    dfs(i);
		}
	    }
	    System.out.println(count);
	    if (t > 0) System.out.println();
	}
    }
    public static void dfs(int node){
	visited[node] = true;

	for (int i = 0; i < arr[node].size(); i++) {
	    int dist = arr[node].get(i);
	    if (!visited[dist])
		dfs(dist);
	}
    }

}
