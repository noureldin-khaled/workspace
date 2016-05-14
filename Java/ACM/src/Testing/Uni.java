package Testing;

import java.math.BigInteger;

public class Uni {
	public static void main(String[] args) {
		BigInteger b = new BigInteger("555555555555555555555555555555555555000000000");
		System.out.println(b.mod(BigInteger.valueOf(90)));
	}
}
