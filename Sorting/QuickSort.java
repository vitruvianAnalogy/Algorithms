/*The difference between quicksort and mergesort is that in mergesort, 
sorting happens after the array has been split and once we try to merge them

On the other hand, in quick sort, while making a partition, we make sure that
smaller elements are to the left of the pivot and larger element are to the right
of the pivot.
*/

/*
Space complexity O(log n)
Best : O(nlogn)
Average : O(nlogn)
Worst : O(n2)

Constant hidden by Big - OH notation is small
*/

import java.util.*;
public class QuickSort{


	/*Let us take the middle element as the pivot*/
	public static void sort(int[] a, int left, int right){

		int i = left;
		int j = right;

	//check if the array isn't composed of just element or is invalid
		if(i>=j)
			return;
		//calculate the middle pivot
		int pivot = a[(i+j)/2];
		//As long as left is smaller or equal to j we do the following
		while(i<=j){			
			/*while left element is smaller than pivot, we keep on approaching pivot until it becomes equal or greater than pivot*/
			while(a[i]<pivot)
				i++;//in case i reaches pivot this condition won't work
			/*while right element is greater than pivot, we keep on approaching pivot until it becomes equal or less than pivot*/
			while(a[j]>pivot)
				j--;//in case j reaches pivot this condition won't work
			/*when we find something greater than pivot on left and smaller than pivot on right we swap them and then repeat the process until we reach the pivot*/
			if(i<=j)
			{
				int temp = a[i];
				a[i] = a[j];
				a[j] = temp;
				//We swap them and then move to the next element in that line of elements
				i++;
				j--;
			}//The last if runs when i == j == pivot since both were converging towards it and both passes it with help of i++ and j--

			//This loop will end when i becomes greater than j, this will happen when j and i both have reached pivot
		}

		// if the j hasn't reached the left extreme
		if(left<j)
			sort(a,left,j);
		// if i hasn't reached the right extreme
		if(right>i)
			sort(a,i,right);		
	}

	public static void main(String[] args){
		
		Scanner sn = new Scanner(System.in);
		
		//Input number of elements
		int n = sn.nextInt();
		//Declare array where number of elements will be stored
		int[] a = new int[n];

		//Fill arrays with the elements
		for(int i=0;i<n;i++){
			a[i] = sn.nextInt();
		}

		//Call method sort
		int firstElementIndex = 0;
		int lastElementIndex = n-1;
		sort(a, firstElementIndex, lastElementIndex);

		System.out.println("------------RESULTS-------------");

		//Print elements after sorting
		for(int i=0;i<n;i++){
			System.out.println(a[i]);
		}

	}
}