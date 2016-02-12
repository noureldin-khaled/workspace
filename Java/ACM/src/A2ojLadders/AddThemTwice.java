package A2ojLadders;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class AddThemTwice{

    
    public static void main(String[] args) throws NumberFormatException, IOException{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        
        double sum = 0.0;
        
        while(in.ready()){
            StringTokenizer s = new StringTokenizer(in.readLine());
            
            while(s.hasMoreTokens())
                sum += Double.parseDouble(s.nextToken());
        }
        
        System.out.print(sum * 2);

    }
}