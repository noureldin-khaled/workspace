package Codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;


public class EugenyAndArray {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int countOnes = 0;
        int countNegativeOnes = 0;

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());
            if (num == 1)
                countOnes++;
            else 
                countNegativeOnes++;
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int l = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());

            int len = r-l+1;
            if (len % 2 != 0)
                out.println(0);
            else {
                int condition = len/2;
                
                if (condition <= countNegativeOnes && condition <= countOnes)
                    out.println(1);
                else 
                    out.println(0);
            }
        }
        out.flush();
        out.close();
        
    }   
}


