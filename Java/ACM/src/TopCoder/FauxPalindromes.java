package TopCoder;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class FauxPalindromes
{
	static int arr[][];
	static boolean visited[];

	public static int[] getEdge(int[] edge1, int[] edge2, int[] weight)
	{
		int n = edge1.length+1;
		arr = new int[n][n];

		for (int i = 0; i < edge1.length; i++) {
			arr[edge1[i]-1][edge2[i]-1] = weight[i];
			arr[edge2[i]-1][edge1[i]-1] = weight[i];
		}

		for (int i = 0; i < n; i++) {
			visited = new boolean[n];
			int res[] = find(i,i,0,0,0);
			if (res.length != 0)
				return res;
		}
		int res[] = {};
		return res;
	}

	public static int[] find(int orignalNode,int node,int count4,int count7,int edgesSoFar){
		visited[node] = true;

		if (edgesSoFar != 1 && edgesSoFar%2 != 0){
			if (count4 == count7-1){
				int res [] = {orignalNode+1,node+1,4};
				return res;
			}
			if (count7 == count4-1){
				int res [] = {orignalNode+1,node+1,7};
				return res;
			}
		}

		for (int i = 0; i < arr[node].length; i++) {
			if (!visited[i]){
				if (arr[node][i] == 4)
					return find(orignalNode,i, count4+1, count7,edgesSoFar+1);
				else if (arr[node][i] == 7)
					return find(orignalNode,i, count4, count7+1,edgesSoFar+1);
			}
		}
		int res[] = {};
		return res;
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String word = br.readLine();
		System.out.println(new FauxPalindromes().classifyIt(word));
	}

	public String classifyIt(String word)
	{

		String visited = "";
		for (int i = 0; i < word.length(); i++) {
			String tmp  = word.charAt(i) + "";
			if (!visited.contains(tmp))
				visited += tmp;
		}

		String rev = "";
		for (int i = visited.length()-1; i >= 0; i--) 
			rev += visited.charAt(i);

		if (visited.equals(word)){ // check for palindrome
			if (rev.equals(visited))
				return "PALINDROME";
			else
				return "NOT EVEN FAUX";
		}
		else { //try to make it faux palindrome
			if (rev.equals(visited))
				return "FAUX";
			else
				return "NOT EVEN FAUX";
		}
	}

	public int construct(int a)
	{
		for(int i = a+1; i <= 100; i++){
			int number = a^i;
			String numberXORed = number + "";
			boolean valid = true;
			for(int j = 0; j < numberXORed.length() && valid;j++){
				if (numberXORed.charAt(j) != '4' && numberXORed.charAt(j) != '7')
					valid = false;
			}
			if (valid)
				return Integer.parseInt(numberXORed);
		}
		return -1;
	}



}