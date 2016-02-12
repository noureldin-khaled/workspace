package UVa;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

public class FileFragmentation {
    
    public static void main(String[] args) throws NumberFormatException, IOException {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	PrintWriter out = new PrintWriter(System.out);
	
	int t = Integer.parseInt(br.readLine());
	br.readLine();
	while(t-- > 0) {
	    ArrayList<String> fragments = new ArrayList<String>();
	    TreeMap<String, Integer> tm = new TreeMap<>();
	    while(br.ready()) {
		String line = br.readLine();
		if (line.isEmpty())
		    break;
		
		fragments.add(line);
	    }
	    
	    int size = fragments.size();
	    for (int i = 0; i < size; i++) 
		for (int j = 0; j < size; j++) 
		    if (i != j) {
			String concat = fragments.get(i) + fragments.get(j);
			
			if (tm.containsKey(concat)) {
			    int count = tm.get(concat);
			    tm.put(concat, count+1);
			}
			else
			    tm.put(concat, 1);
		    }
	    
	    int max = 0;
	    String ans = "";
	    
	    for (Map.Entry<String, Integer> entry : tm.entrySet()) {
		String key = entry.getKey();
		int value = entry.getValue();
		
		if (value > max) {
		    max = value;
		    ans = key;
		}
	    }
	    
	    out.println(ans);
	    if (t > 0)
		out.println();

	}
	
	out.flush();
	out.close();
    }
}
