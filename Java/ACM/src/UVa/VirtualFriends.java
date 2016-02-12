package UVa;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class VirtualFriends {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());

		while(t-->0){
			int F = Integer.parseInt(br.readLine());

			TreeMap<String, Integer> people = new TreeMap<String, Integer>();

			int count = 0;
			DisjointSets ds = new DisjointSets(F*2);

			for (int i = 0; i < F; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				String firstFriend = st.nextToken();
				String secondFriend = st.nextToken();

				if (!people.containsKey(firstFriend))
					people.put(firstFriend, count++);
				if (!people.containsKey(secondFriend))
					people.put(secondFriend, count++);

				ds.union(people.get(firstFriend), people.get(secondFriend));
			}
		}
	}

  static class DisjointSets {
  	int representative[];
  	int rank[];
  	int socialNetwork[];

  	public DisjointSets(int n) {
  		representative = new int[n];
  		rank = new int[n];
  		socialNetwork = new int[n];
  		for (int i = 0; i < representative.length; i++)
  			representative[i] = i;
  		Arrays.fill(rank, 1);
  		Arrays.fill(socialNetwork, 1);
  	}

  	int findSet(int x) {
  		if (x == representative[x])
  			return x;
  		return representative[x] = findSet(representative[x]);
  	}

  	void union(int x, int y) {
  		int x1 = findSet(x);
  		int y1 = findSet(y);
  		if (x1 != y1){
  			if (rank[x1] > rank[y1]) {
  				representative[y1] = x1;
  				int sum = socialNetwork[x1] + socialNetwork[y1];
  				socialNetwork[x1] = sum;
  				socialNetwork[y1] = 0;
  				System.out.println(sum);
  			} else if (rank[x1] < rank[y1]) {
  				representative[x1] = y1;
  				int sum = socialNetwork[x1] + socialNetwork[y1];
  				socialNetwork[y1] = sum;
  				socialNetwork[x1] = 0;
  				System.out.println(sum);
  			} else {
  				representative[x1] = y1;
  				rank[y1]++;
  				int sum = socialNetwork[x1] + socialNetwork[y1];
  				socialNetwork[y1] = sum;
  				socialNetwork[x1] = 0;
  				System.out.println(sum);
  			}
  		}
  		else
  			System.out.println(socialNetwork[x1]);
  	}

  }

}
