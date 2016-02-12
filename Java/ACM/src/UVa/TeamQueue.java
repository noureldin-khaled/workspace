package UVa;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class TeamQueue {

    public static void main(String[] args) throws IOException {
	Scanner sc = new Scanner(System.in);
	PrintWriter out = new PrintWriter(System.out);

	int s = 1;
	while(true) {
	    int t = sc.nextInt();
	    if (t == 0)
		break;

	    TreeMap<Integer, Integer> tm = new TreeMap<>();
	    int indices[] = new int[t];
	    Arrays.fill(indices, -1);
	    ArrayList<Queue<Integer>> team_queue = new ArrayList<>();
	    int queue_size = 0;
	    int queue_pointer = 0;
	    for (int i = 0; i < t; i++) {
		int n = sc.nextInt();
		for (int j = 0; j < n; j++) {
		    int team = sc.nextInt();
		    tm.put(team, i);
		}
	    }

	    out.printf("Scenario #%d\n",s);
	    s++;
	    while(true) {
		String command = sc.Next();
		if (command.equals("STOP"))
		    break;

		if (command.equals("ENQUEUE")) {
		    int team = sc.nextInt();
		    int team_index = tm.get(team);
		    if (indices[team_index] == -1) {
			Queue<Integer> q = new LinkedList<>();
			q.add(team);
			team_queue.add(q);

			indices[team_index] = queue_size;
			queue_size++;
		    }
		    else {
			team_queue.get(indices[team_index]).add(team);
		    }
		}
		else {

		    int elem = team_queue.get(queue_pointer).remove();
		    if (team_queue.get(queue_pointer).isEmpty()) {
			int team_index = tm.get(elem);
			indices[team_index] = -1;
			queue_pointer++;
		    }
		    out.println(elem);
		}
	    }
	    out.println();
	}

	out.flush();
	out.close();
    }

    private static class Scanner {
	BufferedReader br;
	StringTokenizer st;

	public Scanner(FileReader f) {
	    br = new BufferedReader(f);
	}

	public Scanner(InputStream in) {
	    br = new BufferedReader(new InputStreamReader(in));
	}

	public String Next() throws IOException {
	    if (st == null || !st.hasMoreTokens())
		st = new StringTokenizer(br.readLine());
	    return st.nextToken();
	}

	public String nextLine() throws IOException {
	    return br.readLine();
	}

	public int nextInt() throws IOException {
	    return Integer.parseInt(Next());
	}

	public long nextLong() throws IOException {
	    return Long.parseLong(Next());
	}

	public double nextDouble() throws IOException {
	    return Double.parseDouble(Next());
	}

	public boolean Ready() throws IOException {
	    return br.ready();
	}

	public void waitForInput(long time) {
	    long ct = System.currentTimeMillis();
	    while(System.currentTimeMillis() - ct < time) {};
	}

    }
}
