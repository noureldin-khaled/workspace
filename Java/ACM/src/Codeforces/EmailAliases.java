package Codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class EmailAliases {

    public static void main(String[] args) throws NumberFormatException, IOException {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	PrintWriter out = new PrintWriter(System.out);

	int n = Integer.parseInt(br.readLine());
	TreeMap<String, Integer> tm = new TreeMap<>();
	ArrayList<Group> res = new ArrayList<>();
	int count = 0;
	while(n-->0) {
	    String line = br.readLine();
	    StringTokenizer st = new StringTokenizer(line, "@");
	    
	    String login = st.nextToken();
	    String domain = st.nextToken();
	    
	    String temp = "";
	    if (domain.equalsIgnoreCase("bmail.com")) {
		for (int i = 0; i < login.length(); i++) {
		    if (login.charAt(i) == '.')
			continue;
		    if (login.charAt(i) == '+')
			break;
		    
		    temp += login.charAt(i);
		}
	    }
	    else 
		temp = login;
	    
	    String resLine = temp.toLowerCase() + "@" + domain.toLowerCase();
	    
	    if (tm.containsKey(resLine)) {
		int index = tm.get(resLine);
		res.get(index).size++;
		res.get(index).emails.add(line);
	    }
	    else {
		tm.put(resLine, count++);
		ArrayList<String> e = new ArrayList<>();
		e.add(line);
		res.add(new Group(1, e));
	    }
	}
	
	int size = res.size();
	out.println(size);
	for (int i = 0; i < size; i++) {
	    Group g = res.get(i);
	    out.print(g.size);
	    for (int j = 0; j < g.emails.size(); j++) 
		out.print(" " + g.emails.get(j));
	    
	    out.println();
	}
	out.flush();
	out.close();
    }

}

class Group {
    int size;
    ArrayList<String> emails;
    public Group(int size,ArrayList<String> emails) {
	this.size = size;
	this.emails = emails;
    }
}
