package UVa;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class ThroughTheDesert{

    static ArrayList<Event> events;
    static final double EPS = 1e-9;

    public static void main(String[] args) throws IOException {
	BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	PrintWriter out = new PrintWriter(System.out);

	boolean done = false;

	while(true){
	    events = new ArrayList<>();
	    int maxD = 0;

	    for (int i = 0; true; i++) {
		StringTokenizer s = new StringTokenizer(in.readLine());

		int location = (Integer.parseInt(s.nextToken()));
		String type = (s.nextToken());

		if(s.hasMoreTokens())
		    s.nextToken();

		int consumption = -1;

		if(s.hasMoreTokens())
		    consumption = Integer.parseInt(s.nextToken());

		if(consumption == 0){
		    done = true;
		    break;
		}

		events.add(new Event(location, type, consumption));

		maxD = location;

		if(type.equals("Goal"))
		    break;
	    }

	    if(done)
		break;

	    double low = 0;
	    double high = (0.3 * maxD) + (50 * maxD);

	    double ans = -1;

	    while(!(Math.abs(low - high) < EPS)) {
		double mid = low + (high-low)/2;
		if (simulate(mid)) {
		    ans = mid;
		    high = mid;
		}
		else 
		    low = mid;
	    }

	    if(simulate(low))
		ans = low;

	    out.printf("%.3f\n", ans);
	}

	out.flush();
	out.close();
    }
    private static boolean simulate(double mid) {
	double cc = 0;
	int holes = 0;
	int prevLocation = 0;

	double gas = mid; 

	for (int i = 0; i < events.size(); i++) {
	    Event e = events.get(i);

	    gas -= (e.location - prevLocation) * (cc / 100);
	    gas -= (e.location - prevLocation) * holes;

	    if(gas + EPS < 0)
		return false;

	    if(e.type.equals("Fuel"))
		cc = e.consumption;
	    else if(e.type.equals("Leak"))
		holes++;
	    else if(e.type.equals("Mechanic"))
		holes = 0;
	    else
		gas = mid;

	    prevLocation = e.location;
	}

	return gas + EPS >= 0;


    }

    static class Event{
	int location, consumption;
	String type;

	public Event(int location, String type, int consumption) {
	    this.location = location;
	    this.type = type;
	    this.consumption = consumption;
	}
    }
}

