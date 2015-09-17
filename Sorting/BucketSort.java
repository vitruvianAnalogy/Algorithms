import java.util.*;
public class BucketSort{

	public static void sort(int[] a){

	}

	public static void main(String[] args){
		
		Scanner sn = new Scanner(System.in);
		//Enter number of elements to be sorted
		int n = sn.nextInt();

		//Declare array of length n
		int[] a = new int[n];

		//Enter elements to be sorted
		for(int i = 0; i<n; i++){
			a[i] = sn.nextInt();
		}

		//Call Sort Method
		sort(a);

		System.out.println("------------RESULTS-------------");

		//Print elements after sorting
		for(int i=0;i<n;i++){
			System.out.println(a[i]);
		} 

	}
}