package Codeforces;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class PhoneNumbers {
	
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		int n = sc.nextInt();
		int maxTaxi = 0;
		ArrayList<String> nameTaxi = new ArrayList<String>();
		int maxPizza = 0;
		ArrayList<String>  namePizza = new ArrayList<String>();
		int maxGirls = 0;
		ArrayList<String>  nameGirls = new ArrayList<String>();
		
		for (int i = 0; i < n; i++) {
			int s = sc.nextInt();
			String name = sc.Next();
			
			int taxi = 0;
			int pizza = 0;
			for (int j = 0; j < s; j++) {
				char[] number = sc.nextLine().toCharArray();

				int arr[] = new int[6];
				arr[0] = number[0] - '0';
				arr[1] = number[1] - '0';
				arr[2] = number[3] - '0';
				arr[3] = number[4] - '0';
				arr[4] = number[6] - '0';
				arr[5] = number[7] - '0';
				
				if (isTaxi(arr))
					taxi++;
				else if (isPizza(arr))
					pizza++;
			}
			
			int girls = s - (taxi+pizza);
			if (taxi > maxTaxi) {
				maxTaxi = taxi;
				nameTaxi = new ArrayList<>();
				nameTaxi.add(name);
			}
			else if (taxi == maxTaxi)
				nameTaxi.add(name);
			
			if (pizza > maxPizza) {
				maxPizza = pizza;
				namePizza = new ArrayList<>();
				namePizza.add(name);
			}
			else if (pizza == maxPizza)
				namePizza.add(name);
			
			if (girls > maxGirls) {
				maxGirls = girls;
				nameGirls = new ArrayList<>();
				nameGirls.add(name);
			}
			else if (girls == maxGirls)
				nameGirls.add(name);
		}
		
		sb.append("If you want to call a taxi, you should call: ");
		for (int i = 0; i < nameTaxi.size(); i++) {
			if (i > 0)
				sb.append(", ");
			sb.append(nameTaxi.get(i));
		}
		
		sb.append(".\n");
		
		sb.append("If you want to order a pizza, you should call: ");
		for (int i = 0; i < namePizza.size(); i++) {
			if (i > 0)
				sb.append(", ");
			sb.append(namePizza.get(i));
		}
		
		sb.append(".\n");
		
		sb.append("If you want to go to a cafe with a wonderful girl, you should call: ");
		for (int i = 0; i < nameGirls.size(); i++) {
			if (i > 0)
				sb.append(", ");
			sb.append(nameGirls.get(i));
		}
		
		sb.append(".\n");
		
		System.out.println(sb);
	}
	
	public static boolean isPizza(int[] arr) {
		for (int i = 0; i < 5; i++)
			if (arr[i+1] >= arr[i])
				return false;
		
		return true;
	}

	public static boolean isTaxi(int[] arr) {
		int num = arr[0];
		for (int i = 1; i < 6; i++) 
			if (num != arr[i])
				return false;
		
		return true;
	}

	static class Scanner {
	    BufferedReader br;
	    StringTokenizer st;

	    public Scanner(FileReader f) {
	        br = new BufferedReader(f);
	    }

	    public Scanner(InputStream in) {
	        br = new BufferedReader(new InputStreamReader(in));
	    }

	    public String Next() throws IOException {
	        while (st == null || !st.hasMoreTokens())
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
