package Codeforces;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.TreeMap;
	

public class MishaAndChangingHandles {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int q = Integer.parseInt(br.readLine());
		
		DisjointSets ds = new DisjointSets(q*2);
		TreeMap<String, Integer> tm = new TreeMap<>();
		
		int count = 0;
		ArrayList<String> input = new ArrayList<>();
		for (int i = 0; i < q; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String first = st.nextToken();
			String second = st.nextToken();
			
			input.add(first + " " + second);
			if (!tm.containsKey(first))
				tm.put(first, count++);
			if (!tm.containsKey(second))
				tm.put(second, count++);
		}
		
		for (int i = 0; i < input.size(); i++) {
			StringTokenizer st = new StringTokenizer(input.get(i));
			String first = st.nextToken();
			String second = st.nextToken();
			
			ds.union(tm.get(first), tm.get(second), first, second);
		}
		
		System.out.println(ds.c);
		for (int i = 0; i < ds.handles.length; i++) {
			if (ds.handles[i].getOldName() != null && ds.handles[i].getNewName() != null ){
				System.out.println(ds.handles[i].getOldName() + " " + ds.handles[i].getNewName());
			}
		}
	}

}

class DisjointSets {
	int representative[];
	int rank[];
	Handle handles[];
	int c;

	public DisjointSets(int n) {
		representative = new int[n];
		rank = new int[n];
		for (int i = 0; i < representative.length; i++)
			representative[i] = i;
		Arrays.fill(rank, 1);
		handles = new Handle[n];
		for (int i = 0; i < handles.length; i++) 
			handles[i] = new Handle();
		c = 0;
	}

	int findSet(int x) {
		if (x == representative[x])
			return x;
		return representative[x] = findSet(representative[x]);
	}

	void union(int x, int y,String oldName,String newName) {
		int x1 = findSet(x);
		int y1 = findSet(y);
		if (x1 != y1)
			if (rank[x1] > rank[y1]) {
				representative[y1] = x1;
				handles[x1].setNewName(newName);
			} else if (rank[x1] < rank[y1]) {
				representative[x1] = y1;
				handles[y1].setNewName(newName);
			} else {
				representative[x1] = y1;
				rank[y1]++;
				handles[y1].setOldName(oldName);
				handles[y1].setNewName(newName);
				c++;
			}
	}
}

class Handle{
	private String oldName;
	private String newName;
	public Handle(){
	}
	
	public void setOldName(String oldName) {
		this.oldName = oldName;
	}
	public void setNewName(String newName) {
		this.newName = newName;
	}

	public String getOldName() {
		return oldName;
	}

	public String getNewName() {
		return newName;
	}
	
}


















