package NeededProblems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class ZhenyaMovesFromParents_100507C {
	
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
		int n= Integer.parseInt(bf.readLine());
		Lett l[]= new Lett[n];
		for(int i=0; i<n; i++){
			StringTokenizer st= new StringTokenizer(bf.readLine());
			int x= Integer.parseInt(st.nextToken());
			String s= st.nextToken();
			int d=Integer.parseInt(s.substring(0,2));
			int mon= Integer.parseInt(s.substring(3,5));
			int date= mon*31+d;
			s= st.nextToken();
			int h=Integer.parseInt(s.substring(0,2));
			int min= Integer.parseInt(s.substring(3,5));
			int time= h*60+ min;
			l[i]= new Lett(x,date,time);

		}
		Lett x[]= Arrays.copyOf(l, n);
		Arrays.sort(x);
		for(int i=0; i<n; i++){
			x[i].ind=i;
		}
		PrintWriter out= new PrintWriter(System.out);
		int temp= n;
		int N=1; while(N<n) N<<=1;
		//System.out.println(N);
		SegmentTree sTree= new SegmentTree(N);
		for(int i=0; i<temp; i++){
			long m=0;
			long cred=0;
			if(l[i].mon>0)
				m= l[i].mon;
			else cred= l[i].mon*-1;
			sTree.update_point(l[i].ind+1,m ,cred);
			out.println(sTree.query(1, n).credit*-1);
		}
		out.flush();
		out.close();
		
	}
	
	static class Lett implements Comparable<Lett>{
		int date, time,ind;
		long mon;
		public Lett(int m, int d, int t){
			mon= m;
			date= d;
			time= t;
		}
		public int compareTo(Lett o) {
			if(date<o.date)
				return -1;
			else if(date>o.date)
				return 1;
			return time-o.time;
		}
		
		
		
	}
	
	static class Node{
		long money;
		long credit;
	}
	static class SegmentTree{
		int N;
		Node [] st;
		public SegmentTree(int n){
			N= n;
			st= new Node [N<<1];
			for(int i=0; i<(N<<1); i++)
				st[i]= new Node();
		}
		public void update_point (int node, long mon, long cred){
			node+= N-1;
			st[node].credit=cred;
			st[node].money= mon;
			while(node>1){
				node= parent(node);
				Node left= st[left(node)];
				Node right= st[right(node)];
				long credit= left.credit;
				long money= left.money;
				long temp= Math.min(money, right.credit);
				money-=temp;
				money+= right.money;
				credit+= (right.credit-temp);
				st[node].credit=credit;
				st[node].money=money;
			}
		}
		
		Node query (int i, int j){
			return query(1,1,N, i,j);
		}
		Node query(int node, int b, int e, int i, int j){
			if(i>e || j<b)
				return new Node();
			if(b>=i && e<=j)
				return st[node];
			int mid= (b+e)/2;
			Node left= query(left(node),b, mid, i,j);
			Node right= query(right(node),mid+1, e,i ,j);
			Node result= new Node();
			long credit= left.credit;
			long money= left.money;
			long temp= Math.min(money, right.credit);
			money-=temp;
			money+= right.money;
			credit+= (right.credit-temp);
			result.money=money;
			result.credit=credit;
			return result;
		}
		
	 
		
		public int left(int node){
			return node<<1;
			
		}
		public int right(int node){
			return (node<<1)+1;
		}
		public int parent(int node){
			return node>>1;
		}
		
	}
	
	
	
}