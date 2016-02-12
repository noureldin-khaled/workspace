package Codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class TeamOlympiad {

    public static void main(String[] args) throws NumberFormatException, IOException {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	int n = Integer.parseInt(br.readLine());
	
	Cell arr[] = new Cell[4];
	for (int i = 0; i < arr.length; i++) 
	    arr[i] = new Cell(0, new ArrayList<Integer>());
	
	StringTokenizer st = new StringTokenizer(br.readLine());
	
	for (int i = 1; i <= n; i++) {
	    int num = Integer.parseInt(st.nextToken());
	    arr[num].occ++;
	    arr[num].people.add(i);
	}
	
	int min = Integer.MAX_VALUE;
	for (int i = 1; i < arr.length; i++) {
	    if (arr[i].occ < min)
		min = arr[i].occ;
	}
	
	System.out.println(min);
	if (min != 0){
	    for (int i = 0; i < min; i++) 
		System.out.println(arr[1].people.get(i) + " " + arr[2].people.get(i) + " " + arr[3].people.get(i));
	    
	}
	
    }

}

class Cell{
    int occ;
    ArrayList<Integer> people;
    public Cell(int occ,ArrayList<Integer> people){
	this.occ = occ;
	this.people = people;
    }
}
