import java.math.*;
import java.util.*;


public class ExtraLongFactorials {
	public static BigInteger factorial(BigInteger number)
	{
		int n = 1;
		if(number.equals(BigInteger.ONE)){
			return BigInteger.valueOf(n);
		}
		else
		{
			return factorial(number.subtract(BigInteger.valueOf(1))).multiply(number);
		}
	}
	public static void main(String[] args){
		BigInteger number = BigInteger.valueOf(0);
		Scanner sn = new Scanner(System.in);
		
		number = sn.nextBigInteger();

		
		BigInteger fact = BigInteger.valueOf(1);
		if (number.intValue()>1){
			fact = fact.multiply(factorial(number));
		}
		System.out.println(fact.toString());
		sn.close();	
	}
}
