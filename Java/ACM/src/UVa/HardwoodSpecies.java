package UVa;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.TreeMap;

public class HardwoodSpecies {
    public static void main(String[] args) throws NumberFormatException, IOException {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	PrintWriter out = new PrintWriter(System.out);

	int t = Integer.parseInt(br.readLine());
	br.readLine();
	while(t-->0) {
	    ArrayList<String> input = new ArrayList<String>();
	    
	    while(br.ready()) {
		String line = br.readLine();
		if (line.isEmpty()) break;
		input.add(line);
	    }
	    Collections.sort(input);
	    
	    TreeMap<String, Integer> tm = new TreeMap<String, Integer>();
	    String[] names = new String[10005];
	    int occ[] = new int[10005];
	    int i = 0;
	    int size = input.size();
	    
	    for(int j = 0; j < size; j++) {
		String line = input.get(j);
		if (!tm.containsKey(line)) {
		    names[i] = line;
		    tm.put(line, i++);
		}

		int index = tm.get(line);
		occ[index]++;
	    }
	    
	    for(int j = 0; j < 10005; j++) {
		if (occ[j] > 0) {
		    String tree = names[j];
		    double value = (occ[j] * 1.0) / size;
		    out.printf("%s %.4f\n",tree,value*100);
		}
	    }
	    
	    if (t > 0)
		out.println();
	}

	out.flush();
	out.close();
    }
}
