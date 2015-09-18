import java.util.*;
public class BinarySearch{

	public static boolean search(int[] a, int element){
		int left = 0;
		int right = a.length-1;

		while(left<=right){
			int middle = (left+right)/2;

			if(a[middle]==element){
				System.out.println("Element is at "+middle);
				return true;
			}
				
			if(a[middle]>element)
				right = middle-1;
			if(a[middle]<element)
				left = middle+1;			
		}
		return false;
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