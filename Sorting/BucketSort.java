/*Bucket Sort time complexity = O(n)
We find the maximum element in the list of numbers and then we declare an
array of size = maximum element. Then we initialize all the array positions
with 0. Then we start traversing the elements and increment the positions having
the index same as the number we acquire*/

import java.util.*;
public class BucketSort{

	public static int findmax(int[] a){
		int max = 0;
		for(int i = 0; i<a.length; i++){
			if(a[i]>max)
				max = a[i];
		}
		return max;
	}

	public static int[] sort(int[] a, int maxValue){
		int[] temp = new int[maxValue+1];
		for(int i = 0; i<maxValue; i++)
			temp[i] = 0;

		// /int i = 0;
		for(int i=0;i<a.length;i++){
			temp[a[i]]++;
		}

		int [] sortedArray = new int[a.length];
		int counter = 0;
		for(int i = 0; i<temp.length; i++)
		{
			while(temp[i]!=0){
				sortedArray[counter] = i;
				counter++;
				temp[i]--;
			}
		}
		return sortedArray;
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

		int maxValue = findmax(a);

		//Call Sort Method
		int[] sortedArray = sort(a, maxValue);

		System.out.println("------------RESULTS-------------");

		//Print elements after sorting
		for(int i=0;i<n;i++){
			System.out.println(sortedArray[i]);
		} 

	}
}