package Codeforces;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Exam {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		if (n == 1){
			System.out.println(1);
			System.out.println(1);
		}
		else if (n == 2){
			System.out.println(1);
			System.out.println(1);
		}
		else if (n == 3){
			System.out.println(2);
			System.out.println(1 + " " + 3);
		}
		else {
			System.out.println(n);
			if ((n%2) == 0){ // even number start
				for (int i = n-1; i > 0; i-=2) 
					System.out.print(i + " ");

				for (int i = n; i > 1; i-=2) 
					if (i == 2)
						System.out.print(i);
					else
						System.out.print(i + " ");

			}
			else { //odd number start
				for (int i = n; i > 0; i-=2) 
					System.out.print(i + " ");
				
				for (int i = n-1; i > 1; i-=2) 
					if (i == 2)
						System.out.print(i);
					else
						System.out.print(i + " ");
			}
		}
	}


}
