package UVa;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Stack;

public class WhatGoesUp {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);

		ArrayList<Integer> arr = new ArrayList<>();
		while (br.ready())
			arr.add(Integer.parseInt(br.readLine()));

		int n = arr.size();
		Element tail[] = new Element[n];
		int P[] = new int[n];

		tail[0] = new Element(arr.get(0), 0);
		P[0] = -1;
		int len = 1;
		for (int i = 1; i < n; i++) {
			if (arr.get(i) < tail[0].e) {
				tail[0] = new Element(arr.get(i), i);
				P[i] = -1;
			} else if (arr.get(i) > tail[len - 1].e) {
				P[i] = tail[len - 1].index;
				tail[len++] = new Element(arr.get(i), i);
			} else {
				int l = -1;
				int r = len - 1;
				while (r - l > 1) {
					int m = l + (r - l) / 2;
					if (tail[m].e >= arr.get(i))
						r = m;
					else
						l = m;
				}
				P[i] = tail[r - 1].index;
				tail[r] = new Element(arr.get(i), i);
			}
		}
		out.println(len + "\n-");

		Stack<Integer> s = new Stack<>();
		int i = tail[len - 1].index;
		while (i != -1) {
			s.push(i);
			i = P[i];
		}

		while (!s.isEmpty())
			out.println(arr.get(s.pop()));

		out.flush();
		out.close();
	}

}

class Element {
	int e;
	int index;

	public Element(int e, int index) {
		this.e = e;
		this.index = index;
	}
}
