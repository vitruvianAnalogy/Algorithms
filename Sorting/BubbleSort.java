import java.util.*;

/*
What basically happens in Bubble Sort is that two adjacent elements are checked and swapped accordingly.
We go through all the elements and swap them. We repeat this step until no swap is happening.
BUT The underlying thing that you need to know is that, with each pass the last element becomes the maximum element
*/
public class BubbleSort{
	public static void main(String[] args){
		Scanner sn = new Scanner(System.in);
		int n = sn.nextInt();
		int[] arrayOfElements = new int[n];

		//Taking input array
		for(int i=0; i<n; i++){
			arrayOfElements[i] = sn.nextInt();
		}

/*First loop is working as a pass. It will only help in counter j knowing how long it has to run. 
Counter j is the element on the left.
tempCounter variable keep the right element in check. Because we always start with first two elements and check them together. Therefore they
only need to be one apart from each other.
 */
		for(int i=0;i<n-1;i++){
			int tempCounter = 0;
			for(int j=0;j<n-i-1;j++)
			{	
				tempCounter++;
				if(arrayOfElements[j]>arrayOfElements[tempCounter])
				{
					int temp = arrayOfElements[j];
					arrayOfElements[j]=arrayOfElements[tempCounter];
					arrayOfElements[tempCounter]=temp;
				}
			}				
		}

		System.out.println("------------------------------");
		for(int i=0; i<n; i++){
			System.out.println(arrayOfElements[i]);
		}
	}
}