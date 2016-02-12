package Codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Multipliers {

    public static void main(String[] args) throws NumberFormatException, IOException {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	PrintWriter out = new PrintWriter(System.out);

	int n = Integer.parseInt(br.readLine());
	long num = 1;
	StringTokenizer st = new StringTokenizer(br.readLine());
	for(int i = 0; i < n; i++)
	{
	    int s = Integer.parseInt(st.nextToken());
	    num = ((long)num*s);
	}

	BigInteger product = new BigInteger("1");
	long square_root = (long)Math.sqrt(num) + 1;

	for (long i = 1; i < square_root; i++){
	    if (num % i == 0)
	    {
		product = product.multiply(new BigInteger(i + ""));
		if (num/i != i)
		    product = product.multiply(new BigInteger(num/i + ""));
	    }
	}

	product = product.mod(new BigInteger(1000000007 + ""));
	out.println(product);
	out.flush();
	out.close();
    }

}
