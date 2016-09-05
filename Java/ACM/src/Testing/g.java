//WRONG ANSWER

package Testing;
import java.io.*;
import java.util.StringTokenizer;
public class g {
	static int []array = new int[5];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i=0; i<5; i++) {
				array[i] = Integer.parseInt(st.nextToken());
			}
			int count=0;
			for(int i=0; i<5; i++) {
				if(array[i]==0)
					count++;
			}
			if(count==5)
				break;
			else {
				if(checker(1,array[0]))
					System.out.println("Possible");
				else 
					System.out.println("Impossible");
			}
		}
	}
	public static boolean checker(int index, int sumSoFar) {
		System.out.println(index + " " + sumSoFar);
		if(index>=5) {
			if(sumSoFar==23)
				return true;
			else return false;
		}
		else {
			boolean sum = checker(index+1, sumSoFar+array[index]);
			boolean sub = checker(index+1, sumSoFar-array[index]);
			boolean mul = checker(index+1, sumSoFar*array[index]);

			return sum||sub||mul;
		}
	}
}
