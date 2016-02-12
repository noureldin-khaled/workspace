package A2ojLadders;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;


public class HallPreparation {
	static ArrayList<Integer> used;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());

		for (int i = 0; i < t; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int [][] arr = new int[N][M];
			used = new ArrayList<Integer>();
			for (int j = 0; j < N; j++) {
				st = new StringTokenizer(br.readLine());
				for (int j2 = 0; j2 < M; j2++) 
					arr[j][j2] = Integer.parseInt(st.nextToken());
			}
			int res = 0;
			for (int j = 0; j < arr.length; j++) {
				for (int j2 = 0; j2 < arr[j].length; j2++) {
					if (isItAdjacent(arr,j,j2) && !used.contains(arr[j][j2])){
						res++;
						used.add(arr[j][j2]);
					}
				}
			}
			System.out.println(res);
		}
	}

	public static boolean isItAdjacent(int [][] arr,int i,int j){
		if (arr[i][j] != -1){
			if (j != arr[i].length-1 && arr[i][j] == arr[i][j+1])
				return true;
			if (j != 0 && arr[i][j] == arr[i][j-1])
				return true;
			if (i != arr.length-1 && arr[i][j] == arr[i+1][j])
				return true;
			if (i != 0 && arr[i][j] == arr[i-1][j])
				return true;
			if (i != 0 && j != 0 && arr[i][j] == arr[i-1][j-1])
				return true;
			if (i != arr.length-1 && j != arr[i].length-1 && arr[i][j] == arr[i+1][j+1])
				return true;
			if (i != 0 && j != arr[i].length-1 && arr[i][j] == arr[i-1][j+1])
				return true;
			if (i != arr.length-1 && j != 0 && arr[i][j] == arr[i+1][j-1])
				return true;
		}
		return false;
	}

}
