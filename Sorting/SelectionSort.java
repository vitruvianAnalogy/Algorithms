import java.util.*;

public class SelectionSort{
	public static void main(String[] args){
		Scanner sn = new Scanner(System.in);
		int n = sn.nextInt();
		int[] arrayOfElements = new int[n];

		//Taking input array
		for(int i=0; i<n; i++){
			arrayOfElements[i] = sn.nextInt();
		}

		int minimum = -1;

//Find the minimum element and put it at the beginning
		for(int i=0 ; i<n ; i++){
			//0...n, 1....n,2...n,.....
			minimum = i;
			
			for(int j=i+1 ; j<n ; j++){
				//Finding the minimum element, keep on updating the
				//minimum element, find lesser element and keep on checking
				//it with smaller element until you find the smallest number
				if(arrayOfElements[minimum] > arrayOfElements[j])
					minimum = j;
			}

			if(minimum!=i){
				int temp = arrayOfElements[i];
				arrayOfElements[i]=arrayOfElements[minimum];
				arrayOfElements[minimum]=temp;	
			}
			
		}
		System.out.println("----Sorted List is as follows------------");
		for(int i=0; i<n; i++){			
			System.out.println(arrayOfElements[i]);
		}
	}
}