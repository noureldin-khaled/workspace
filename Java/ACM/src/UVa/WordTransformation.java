package UVa;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class WordTransformation {
    static ArrayList<Integer> arr[];
    
    public static void main(String[] args) throws Exception{
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	PrintWriter out = new PrintWriter(System.out);
	int t = Integer.parseInt(br.readLine());
	br.readLine();
	while(t-->0) {
	    TreeMap<String, Integer> dictionary = new TreeMap<>();
	    int count = 0;
	    arr = new ArrayList[250];
	    for (int i = 0; i < 250; i++) 
		arr[i] = new ArrayList<>();
	    
	    String dic[] = new String[250];
	    while(true) {
		String s = br.readLine();
		if (s.equals("*"))
		    break;
		dictionary.put(s, count);
		dic[count] = s;
		
		for (int i = 0; i < count; i++) {
		    if (Check(dic[i], s)) {
			arr[i].add(count);
			arr[count].add(i);
		    }
		}
		count++;
	    }

	    while(true && br.ready()) {
		String line = br.readLine();
		if (line.isEmpty())
		    break;
		StringTokenizer st = new StringTokenizer(line);
		int src = dictionary.get(st.nextToken());
		int dest = dictionary.get(st.nextToken());
		
		int dist[] = new int[250];
		Arrays.fill(dist, -1);

		Queue<Integer> q = new LinkedList<>();
		q.add(src);
		dist[src] = 0;

		while(!q.isEmpty()) {
		    int parent = q.remove();
		    if (dest == parent)
			break;
		    for(int i = 0; i < arr[parent].size(); i++){
			int child = arr[parent].get(i);
			if (dist[child] == -1) {
			    dist[child] = dist[parent] + 1;
			    q.add(child);
			}
		    }
		}
		out.println(dic[src] + " " + dic[dest] + " " + dist[dest]);
	    }
	    
	    if (t > 0)
		out.println();
	}
	out.flush();
	out.close();
    }
    
    public static boolean Check(String First, String Second){
	int Counter = 0;
	
	Counter = Math.abs(First.length() - Second.length());
	if( Second.length() >= First.length() ){
		for(int i = 0; i < First.length(); i++)
			if(First.charAt(i) != Second.charAt(i))	Counter++;
	}else{
		for(int i = 0; i < Second.length(); i++)
			if(First.charAt(i) != Second.charAt(i))
				Counter++;
	}
	return Counter == 1;
}

}

