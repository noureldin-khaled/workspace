package Codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class CourseScheduling {

    public static void main(String[] args) throws NumberFormatException, IOException {
	BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	PrintWriter out = new PrintWriter(System.out);

	int n = Integer.parseInt(in.readLine());

	TreeMap<String, HashSet<String>> map = new TreeMap<>();
	HashSet<String> courses = new HashSet<>();
	for (int i = 0; i < n; i++) {
	    StringTokenizer s = new StringTokenizer(in.readLine());

	    String fName = s.nextToken();
	    String lName = s.nextToken();
	    String course = s.nextToken();

	    String name = fName + lName;

	    HashSet<String> set = map.get(course);

	    courses.add(course);
	    if(set != null){
		map.get(course).add(name);
	    }
	    else{
		HashSet<String> temp = new HashSet<String>();
		temp.add(name);
		map.put(course, temp);
	    }
	}

	ArrayList<Course> output = new ArrayList<>();
	for(String h : courses) 
	    output.add(new Course(h, map.get(h).size()));

	Collections.sort(output);
	for (int i = 0; i < output.size(); i++) 
	    out.println(output.get(i));

	out.flush();
	out.close();

    }
}
class Course implements Comparable<Course>{
    String name;
    int size;
    public Course(String name, int size) {
	this.name = name;
	this.size = size;
    }

    public int compareTo(Course o) {
	return this.name.compareTo(o.name);
    }
    public String toString()
    {
	return name + " " + size;
    }
}
