package UVa;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Ordering {
	static ArrayList<Integer> graph[];

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		int t = Integer.parseInt(br.readLine());

		while(t-->0){
			br.readLine();
			StringTokenizer st = new StringTokenizer(br.readLine());
			ArrayList<Character> arr = new ArrayList<>();
			while(st.hasMoreTokens())
				arr.add(st.nextToken().charAt(0));
			
			String relations = br.readLine();
			int size = arr.size();
			
			ArrayList<String> output = new ArrayList<>();
			do{
				TreeMap<Character, Integer> tm = new TreeMap<Character, Integer>();
				char[] tmRev = new char[size];
				graph = new ArrayList[size];
				int count = 0;
				for (int i = 0; i < size; i++) {
					tmRev[count] = arr.get(i);
					tm.put(arr.get(i), count++);
				}
				for (int i = 0; i < graph.length; i++) 
					graph[i] = new ArrayList<>();

				int indegrees[] = new int[size];
				st = new StringTokenizer(relations);
				while(st.hasMoreTokens()){
					String line = st.nextToken();
					int first = tm.get(line.charAt(0));
					int second = tm.get(line.charAt(2));

					graph[first].add(second);
					indegrees[second]++;
				}
				

				Queue<Integer> tsort_queue = new LinkedList<>();
				ArrayList<Integer> sorted = new ArrayList<>();

				for (int i = 0; i < size; i++) {
					if (indegrees[i] == 0){
						tsort_queue.add(i);
						break;
					}
				}

				boolean visited[] = new boolean[size];
				while(!tsort_queue.isEmpty()){
					int front = tsort_queue.remove();
					sorted.add(front);
					visited[front] = true;
					for (int i = 0; i < graph[front].size(); i++) {
						int child = graph[front].get(i);
						indegrees[child]--;
					}
					for (int i = 0; i < indegrees.length; i++) 
						if (indegrees[i] == 0 && !visited[i]){
							tsort_queue.add(i);
							break;
						}
				}

				boolean isSorted = true;
				for (int i = 0; i < size && isSorted; i++) {
					if (indegrees[i] != 0)
						isSorted = false;
				}
				
				String res = "";
				if (!isSorted){
					res += "NO";
					output.add(res);
					break;
				}
				else {
					for (int i = 0; i < size; i++)
						if (i == size - 1)
							res += tmRev[sorted.get(i)];
						else
							res += tmRev[sorted.get(i)] + " ";
					if (!output.contains(res))
						output.add(res);
				}
			}while(nextPerm(arr));
			for (int i = 0; i < output.size(); i++) 
				out.println(output.get(i));
			
			if (t > 0)
				out.println();
		}

		out.flush();
		out.close();
	}

	public static boolean nextPerm(ArrayList<Character> arr){
		int length = arr.size();
		int i = length - 2;
		for (; i >= 0; i--) {
			if (arr.get(i) < arr.get(i+1)){
				break;
			}
		}

		if (i == -1)
			return false;

		for (int j = length - 1; j > i; j--) {
			if (arr.get(j) > arr.get(i)){
				char tmp = arr.get(j);
				arr.set(j, arr.get(i));
				arr.set(i, tmp);
				break;
			}
		}

		int s = i+1;
		int e = length -1;

		while (s < e){
			char tmp = arr.get(s);
			arr.set(s, arr.get(e));
			arr.set(e, tmp);
			s++;
			e--;
		}

		return true;
	}

}
