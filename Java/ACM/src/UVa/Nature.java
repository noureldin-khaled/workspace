package UVa;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Nature {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		while(true){
			String line = br.readLine();
			if (line.equals("0 0"))
				break;
			
			StringTokenizer st = new StringTokenizer(line);
			int C = Integer.parseInt(st.nextToken());
			int R = Integer.parseInt(st.nextToken());
			
			TreeMap<String, Integer> tm = new TreeMap<String, Integer>();
			int count = 0;
			for (int i = 0; i < C; i++) 
				tm.put(br.readLine(),count++);
			
			DisjointSets ds = new DisjointSets(C);
			
			for (int i = 0; i < R; i++) {
				st = new StringTokenizer(br.readLine());
				String first = st.nextToken();
				String second = st.nextToken();
				
				int x = tm.get(first);
				int y = tm.get(second);
				
				ds.union(x, y);
			}
			
			System.out.println(ds.maxCycle);
			
			br.readLine();
		}
	}
	
	static class DisjointSets {
		int representative[];
		int rank[];
		int cycle[];
		int maxCycle;

		public DisjointSets(int n) {
			representative = new int[n];
			rank = new int[n];
			cycle = new int[n];
			for (int i = 0; i < representative.length; i++)
				representative[i] = i;
			Arrays.fill(rank, 1);
			Arrays.fill(cycle, 1);
			maxCycle = 1;
		}

		int findSet(int x) {
			if (x == representative[x])
				return x;
			return representative[x] = findSet(representative[x]);
		}

		void union(int x, int y) {
			int x1 = findSet(x);
			int y1 = findSet(y);
			if (x1 != y1)
				if (rank[x1] > rank[y1]) {
					representative[y1] = x1;
					int sum = cycle[x1] + cycle[y1];
					cycle[x1] = sum;
					cycle[y1] = 0;
					if (sum > maxCycle)
						maxCycle = sum;
				} else if (rank[x1] < rank[y1]) {
					representative[x1] = y1;
					int sum = cycle[x1] + cycle[y1];
					cycle[y1] = sum;
					cycle[x1] = 0;
					if (sum > maxCycle)
						maxCycle = sum;
				} else {
					representative[x1] = y1;
					rank[y1]++;
					int sum = cycle[x1] + cycle[y1];
					cycle[y1] = sum;
					cycle[x1] = 0;
					if (sum > maxCycle)
						maxCycle = sum;
				}
		}

	}
}
