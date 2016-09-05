package Testing;

import java.util.*;
public class car {
	int model;
	String manuf;
	String color;
	int ccc;
	String type; 

	public car(int m , String man , String c , int cc , String t ){
		model=m;
		manuf=man;
		color=c;
		ccc=cc;
		type=t;
	}
	public int ageofCar(int m){
		int in =2016-m;
		return(in);
	}
	public String toString(){
		String z=("this car is model " + model + " , it's manufactured by " + manuf + ", its color is " + color  );
		return z;
	}

	public static void main(String[]args){
		car a =new car(2008,"skoda","silver",1600,"automatic");
		car b =new car(2015,"toyota","black",1800,"manual");

		System.out.println(b.toString());

	}



}