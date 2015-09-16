/*
Best Case : O(nlogn)
Worst Case : O(nlogn)
Average Case : O(nlogn)
*/

import java.util.*;

public class HeapSort{

	public static void swap(int[] a, int index1, int index2){		
		int temp = a[index1];
		a[index1]=a[index2];
		a[index2]=temp;
	}

	public static void maxHeap(int[] a, int parentOfLastElement, int indexOfLastElement){
		int left = parentOfLastElement*2;
		int right = parentOfLastElement*2+1;
		int max = parentOfLastElement;
		/*The first check is actually for the 'right' element, 
		because when we divided the last index with 2 we assumed that even if it is odd, 
		dividing by two will truncate it to the nearest integer, so this is to just find out
		in case it was even it right element check doesn't give array index out of bounds exception

		The second check is to find out if left child is greater than parent and then if right child is greater than whichever is max
		be it parent or the left child. Whichever is bigger is set as max*/
		if(left<=indexOfLastElement && a[left]>a[parentOfLastElement]){
			max = left;
		}

		if(right<=indexOfLastElement && a[right]>a[max]){
			max = right;
		}

		/*So basically if the left child or the right child is greater than the parent then we swap the
		parent with the child / max in that array*/
		if(max!=parentOfLastElement){
			swap(a,parentOfLastElement,max);
			//After swapping we run the maxheap procedure on the maximum element now, which is now either the left child or the right child
			maxHeap(a,max,indexOfLastElement);
		}

	}

	public static void heapify(int[] a){
		
		int indexOfLastElement = a.length -1 ;
		int parentOfLastElement = indexOfLastElement/2;

		/*Step 1 : Build Max Heap - We need Heapify procedure which can only be applied to a node whose children nodes are heapified
		Therefore, we need to start heapifying from the bottom node, i.e. Bottom Up Order
		*/
		for(int i = parentOfLastElement; i>=0; i--){
			maxHeap(a,i,indexOfLastElement);	//Bottom Up Order , therefore we start from the bottom element
		}
	}

	public static void sort(int[] a){
		int indexOfLastElement = a.length -1 ;
		//We received the array that is to be sorted
		/*First Step should be to create the max heap and we do that by calling heapify
		For Increasing order sorting we build a MAXHEAP*/
		heapify(a);


		/*Now that we have generated the maxHeap, we will swap the root element which is btw the largest element
		with the rightmost leaf node. This will put a smaller element on the root but the largest element on the rightmost leaf node.
		*/
		for(int i=indexOfLastElement;i>=0;i--){
			//we will swap the top element, i.e. largest with the rightmost leaf.
			swap(a,0,i);	
			/*Since the last element is the largest, we don't want to involve it in the 
			process. Therefore, we will decrease the last element index by 1, therefore it doesn't
			become the part of the process*/
			indexOfLastElement = indexOfLastElement -1;
			/*after swapping we fix the heap because it has lost its properties, 
			we start from the left and right child of the top node, because that is the 
			node that has lost its properties*/
			maxHeap(a,0,indexOfLastElement);
		}

	}

	public static void main(String[] args){
		Scanner sn = new Scanner(System.in);
		int n = sn.nextInt();
		int[] array = new int[n];
		
		//Initialize array with the input
		for(int i = 0; i<n; i++){
			array[i] = sn.nextInt();
		}

	/*A binary heap is a complete binary tree where the value
	of the parent node is either greater or smaller than the child node.
	If it is greater then it is called maxHeap, if it is smaller then it is called minHeap
	*/

	// Since a binary heap is a complete binary tree therefore it can easily be stored in an array
	// for(int i=0;i<n;i++)
	// {
	// 	array[1+ (2*i)] = sn.nextInt();
	// 	array[2+ (2*i)] = sn.nextInt();
	// }


	//Call the Sorting Method and pass the array into it
		sort(array);

	System.out.println("------------------RESULTS------------------------");

		for(int i=0;i<n;i++)
			System.out.println(array[i]);

	}
}