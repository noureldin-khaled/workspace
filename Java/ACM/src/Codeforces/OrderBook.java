package Codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class OrderBook {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);

		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int s = Integer.parseInt(st.nextToken());

		ArrayList<Pair> buy = new ArrayList<>();
		ArrayList<Pair> sell = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			char type = st.nextToken().charAt(0);
			int price = Integer.parseInt(st.nextToken());
			int volume = Integer.parseInt(st.nextToken());

			Pair p = new Pair(price, volume);
			if (type == 'B'){
				int index = buy.indexOf(p);
				if (index == -1)
					buy.add(p);
				else
					buy.get(index).volume += volume;
			}
			else {
				int index = sell.indexOf(p);
				if (index == -1)
					sell.add(p);
				else
					sell.get(index).volume += volume;
			}
		}

		Collections.sort(sell);
		Collections.sort(buy);
		Collections.reverse(buy);

		if (sell.size() >= s)
			for (int i = s-1; i >= 0; i--) 
				out.println("S " + sell.get(i).price + " " + sell.get(i).volume);
		else
			for (int i = sell.size()-1; i >= 0; i--) 
				out.println("S " + sell.get(i).price + " " + sell.get(i).volume);


		if (buy.size() >= s)
			for (int i = 0; i < s; i++) 
				out.println("B " + buy.get(i).price + " " + buy.get(i).volume);
		else
			for (int i = 0; i < buy.size(); i++) 
				out.println("B " + buy.get(i).price + " " + buy.get(i).volume);



		out.flush();
		out.close();
	}
}

class Pair implements Comparable<Pair>{
	int price;
	int volume;

	public Pair(int first, int second){
		this.price = first;
		this.volume = second;
	}

	public String toString(){
		return "("+price+", "+volume+")";
	}

	public int compareTo(Pair o) {
		if (this.price > o.price)
			return 1;
		if (this.price < o.price)
			return -1;
		return 0;
	}

	public boolean equals(Object o){
		return (this.price == ((Pair)o).price);
	}

}

