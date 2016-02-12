package Spoj;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;


public class IsitaTree {
	static boolean[]visited;
	static ArrayList<Integer>[]arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer s = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(s.nextToken()); //nodes
		int m = Integer.parseInt(s.nextToken()); //edges
		arr = new ArrayList[n];
		
		for (int i = 0; i < arr.length; i++) 
			arr[i] = new ArrayList<>();
		
		for (int i = 0; i < m; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int first = Integer.parseInt(st.nextToken())-1;
			int second = Integer.parseInt(st.nextToken())-1;
			arr[first].add(second);
			arr[second].add(first);
		}

		visited = new boolean[n];
		if (m != n-1)
			System.out.println("NO");
		else{
			boolean ans = tree(0,-1);
			if (ans){
				for (int i = 0; i < visited.length; i++) {
					if (!visited[i])
					{
						System.out.println("NO");
						return;
					}
				}
				System.out.println("YES");
			}
			else
				System.out.println("NO");
		}



	}

	public static boolean tree(int node, int parent) {
		visited[node] = true;

		for (int i = 0; i < arr[node].size(); i++) {
			if (visited[arr[node].get(i)]){
				if (arr[node].get(i) == parent)
					continue;
				else
					return false;
			}
			else
				tree(arr[node].get(i), node);
		}
		return true;
	}
}















