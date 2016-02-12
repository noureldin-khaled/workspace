package UVa;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Forests {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());


		br.readLine();
		while (t-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int P = Integer.parseInt(st.nextToken());
			int T = Integer.parseInt(st.nextToken());

			boolean arr[][] = new boolean[P][T];
			while (br.ready()) {
				String line = br.readLine();
				if (line.isEmpty() || line.equals("") || line == null)
					break;
				st = new StringTokenizer(line);
				int person = Integer.parseInt(st.nextToken()) - 1;
				int tree = Integer.parseInt(st.nextToken()) - 1;

				arr[person][tree] = true;
			}

			DisjointSets ds = new DisjointSets(P);
			for (int i = 0; i < arr.length; i++) {
				for (int j = i + 1; j < arr.length; j++) {
					if (sameOpinion(arr[i], arr[j]))
						ds.union(i, j);
				}
			}
			System.out.println(ds.size);
			if (t > 0)
				System.out.println();
		}
	}

	public static boolean sameOpinion(boolean[] a, boolean[] b) {
		for (int i = 0; i < a.length; i++) {
			if (a[i] != b[i])
				return false;
		}
		return true;
	}

	static class DisjointSets {
		int representative[];
		int rank[];
		int size;

		public DisjointSets(int n) {
			representative = new int[n];
			rank = new int[n];
			for (int i = 0; i < representative.length; i++)
				representative[i] = i;
			Arrays.fill(rank, 1);
			size = n;
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
					size--;
				} else if (rank[x1] < rank[y1]) {
					representative[x1] = y1;
					size--;
				} else {
					representative[x1] = y1;
					rank[y1]++;
					size--;
				}
		}
	}


}


