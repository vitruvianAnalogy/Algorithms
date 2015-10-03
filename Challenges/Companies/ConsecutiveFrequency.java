import java.util.*;

public class ConsecutiveFrequency{

	public static int digging(char[] a, int index){
		if(index==a.length)
			return 0;
		if(a[index]==a[index-1]){
			return 1+digging(a,index+1);
		}			
		else
			return 0;

	}

	public static void main(String[] args){
		Scanner sn = new Scanner(System.in);
		System.out.println("Enter string");

		String s = sn.nextLine()+"$";
		char[] a = s.toCharArray();

		for(int i =1; i<a.length; i++){
			if(a.length==i){
				System.out.println(a[i]);
				break;
			}				
			int count = 1+digging(a,i);
			if(count==1){
				System.out.println(a[i-1]);
			}
			else
			{
				System.out.println(a[i-1]+""+count);
				i=i+count-1;
			}
		}
	}
}