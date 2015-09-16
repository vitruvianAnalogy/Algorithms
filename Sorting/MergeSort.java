/*
Best Case : O(nlogn)
Worst Case : O(nlogn)
Average Case : O(nlogn)
Space Complexity : O(n) - due to the extra array used in the merge operation
*/

import java.util.*;

public class MergeSort{

	public static void sort(int [] a, int left, int right){

		int difference = right - left;
		if(difference<=1)
			return;

		int middle = (left + right)/2;
		sort(a,left,middle);
		sort(a,middle,right);

		//The new temporary array that we will create to sort this array and put them together
		int [] temp = new int[difference];
		int i = left;//i tries to reach the middle
		int j = middle;//j tries to reach the right

		for(int k =0; k<difference;k++){
			if(j==right)//in case j exceeds its last element since it should go as far as high-1
				temp[k]=a[i++];
			else if(i==middle)//in case i exceeds its last element since it should go as far as middle-1
				temp[k]=a[j++];
			else if(a[i]>a[j])//if i is greater then j will be put
				temp[k]=a[j++];
			else
				temp[k]=a[i++];//if i is smaller it will be put
			}

		/*Now we will take this temp array and put it in the main array so that the main array is ordered*/
		for(int k=0; k<difference; k++)
			a[left+k]=temp[k];

	}

	public static void main(String[] args){
		Scanner sn = new Scanner(System.in);
		int n = sn.nextInt();
		int [] a = new int[n];

	/*Input the elements*/
		for(int i=0; i<n; i++){
			a[i] = sn.nextInt();
		}

	/*Call sort method*/
		sort(a,0,n);

		System.out.println("-----------------Results----------------------");

	/*Print them after sorting*/
		for (int i=0; i<n; i++) {
			System.out.println(a[i]);
		}

	}
}