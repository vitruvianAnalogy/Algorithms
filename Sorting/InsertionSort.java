import java.util.*;

public class InsertionSort{
	public static void main(String[] args){
		Scanner sn = new Scanner(System.in);
		int n = sn.nextInt();
		int[] arrayOfElements = new int[n];

		//Taking input array
		for(int i=0; i<n; i++){
			arrayOfElements[i] = sn.nextInt();
		}

		int j;
		//the second nested loop is kind of backward loop.
		/*The first loop starts from the second position and checks if it is smaller than the previous element to it.
		If it is smaller then it is inserted in front of it and this will happen till it gets to the front or finds its correct position
		So basically we choose an element starting from the second position hence a[1] and then move backward to the front checking it
		with other elements. This is not bubble sort, in which we do passes and we put the biggest element in the end. here we put the smallest
		in the front...more correctly insert smaller element in its correct place
		*/
		for(int i=1; i<n; i++){
			int element = arrayOfElements[i];
			j = i-1;
			while(j>=0 && arrayOfElements[j]>element){
				//swap				
				arrayOfElements[j+1]=arrayOfElements[j];
				arrayOfElements[j]=element;
				j=j-1;
			}
		}

		System.out.println("-------------------------");
		for(int i=0;i<n; i++)
		{
			System.out.println(arrayOfElements[i]);
		}
	}
}