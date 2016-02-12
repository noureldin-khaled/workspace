package UVa;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class HeadJudgeHeadache {

    public static void main(String[] args) throws IOException {
	Scanner sc = new Scanner(System.in);
	PrintWriter out = new PrintWriter(System.out);

	int test = sc.nextInt();
	sc.nextLine();
	while(test-->0) {
	    ArrayList<Submission> input = new ArrayList<>();
	    int max = 0;
	    while(sc.Ready()) {
		String line = sc.nextLine();
		if (line == null || line.isEmpty())
		    break;

		StringTokenizer st = new StringTokenizer(line);
		int num = Integer.parseInt(st.nextToken());
		char p = st.nextToken().charAt(0);

		String time = st.nextToken();
		String[] split = time.split(":");
		int t = Integer.parseInt(split[0])*60 + Integer.parseInt(split[1]);

		char status = st.nextToken().charAt(0);

		max = Math.max(max, num);
		input.add(new Submission(num, p, t, status));
	    }

	    int time[][] = new int[max+1][7];
	    for (int i = 0; i < max+1; i++) 
		Arrays.fill(time[i], -1);

	    int wrongs[][] = new int[max+1][7];

	    Collections.sort(input);

	    for (int i = 0; i < input.size(); i++) {
		Submission cur = input.get(i);
		int team = cur.team_name;
		int problem = cur.problem - 'A';
		int sub = cur.time;
		char status = cur.status;

		if (time[team][problem] == -1) {
		    if (status == 'N') 
			wrongs[team][problem]++;
		    else 
			time[team][problem] = sub;
		}
	    }

	    Team arr[] = new Team[max];

	    for (int i = 1; i < max+1; i++) {
		int score = 0;
		int solved = 0;
		for (int j = 0; j < 7; j++) {
		    if (time[i][j] != -1) {
			score += time[i][j] + wrongs[i][j]*20;
			solved++;
		    }
		}

		arr[i-1] = new Team(i, score, solved);
	    }

	    Arrays.sort(arr);

	    out.println("RANK TEAM PRO/SOLVED TIME");
	    int prev_score = -1;
	    int prev_solved = -1;
	    int curRank = 1;
	    int rank = 1;
	    for (int i = 0; i < max; i++) {
		int team = arr[i].name;
		int solved = arr[i].solved;
		int score = arr[i].score;
		int rank_to_print = rank;

		if (solved == prev_solved && score == prev_score)
		    rank_to_print = curRank;
		else 
		    curRank = rank;

		int spaces = 3;
		if (rank_to_print > 9)
		    spaces--;
		for (int j = 0; j < spaces; j++) 
		    out.print(" ");
		out.print(rank_to_print + " ");

		spaces = 3;
		if (team > 9)
		    spaces--;
		for (int j = 0; j < spaces; j++) 
		    out.print(" ");
		out.print(team);

		if (solved > 0) {
		    out.print("    " + solved + "      ");
		    String temp = score+"";
		    spaces = (4-temp.length()) + 1;
		    for (int j = 0; j < spaces; j++) 
			out.print(" ");
		    out.print(score);
		}

		prev_score = score;
		prev_solved = solved;

		rank++;
		out.println();
	    }
	    if (test > 0)
		out.println();
	}

	out.flush();
	out.close();
    }

    private static class Submission implements Comparable<Submission> {
	int team_name;
	char problem;
	int time;
	char status;

	public Submission(int t_n, char p, int t, char s) {
	    this.team_name = t_n;
	    this.problem = p;
	    this.time = t;
	    this.status = s;
	}

	@Override
	public String toString() {
	    return team_name + " " + problem + " " + time + " " + status;
	}

	@Override
	public int compareTo(Submission o) {
	    return Integer.compare(time, o.time);
	}
    }

    private static class Team implements Comparable<Team> {
	int name;
	int score;
	int solved;
	public Team(int name, int score, int solved) {
	    this.name = name;
	    this.score = score;
	    this.solved = solved;
	}

	@Override
	public String toString() {
	    return "name: " + name + ", score = " + score + ", solved = " + solved;
	}

	@Override
	public int compareTo(Team o) {
	    if (Integer.compare(o.solved, this.solved) != 0)
		return Integer.compare(o.solved, this.solved);
	    if (Integer.compare(this.score, o.score) != 0)
		return Integer.compare(this.score, o.score);
	    return Integer.compare(this.name, o.name);
	}
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
