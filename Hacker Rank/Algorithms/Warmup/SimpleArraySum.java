import java.util.*;
public class SimpleArraySum{
	public static void main(String [] args){
		Scanner sn = new Scanner (System.in);
		int n = sn.nextInt();
		int sum = 0;
		for(int i =0;i<n;i++)
		{
			sum = sum+sn.nextInt();
		}
		System.out.println(sum);
	}

}