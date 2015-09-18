import java.util.*;
public class InterpolationSearch{

		public static boolean search(int[] a, int element){

		}

		public static void main(String[] args){

		Scanner sn = new Scanner(System.in);
		//Enter number of elements in the search space
		int n = sn.nextInt();

		//Declare array of length n
		int[] a = new int[n];

		System.out.println("Enter the elements where the element is");

		//Enter the elements to be searched in
		for(int i = 0; i<n; i++){
			a[i] = sn.nextInt();
		}

		System.out.println("Enter which number is to be searched");
		int element = sn.nextInt();

		if(!search(a,element)){
			System.out.println("Couldn't find the element");
		}
	}
}