/*This algorithm is sort of like insertion sort, where we put elements to their sorted correct positions in a sequence
In SHELLSORT we do kind of the same thing but instead of comparing elements with rest of the elements in the list
we compare elements that are far apart. This makes smaller elements to move faster to the front of the list.*/

/*Guess what. There is an issue in this, since we are comparing far off elements, there is an almost certain chance that we are missing
some elements that lie between these two far off elements. Therefore, we cannot do sorting in just ONE PASS like insertion sort. We have
to do multiple passes.*/

/*
Using Insertion Sort is advantageous when the elements are almost sorted. Shell sort on the other hand has a very critical calculation in GAP.
THere are various gap sequences proposed by various researchers but mostly it is dependent on the input data 
*/

/*The complexity depends on the gap sequence that we are using. Gap sequence proposed by Knuth is the most effective with O(n^3/2). 
Donald shell's gap sequence works at n^2 while Pratt's sequence is n(logn)^2. Here we will use Knuth's sequence
that is 3x+1 increment sequence:  1, 4, 13, 40, 121, 364, 1093, ... 
*/
import java.util.*;
import java.math.*;
public class ShellSort{

	public static void sort(int[] a){
		int n = (a.length-1);

		int gap = 1;
		//Calculate the maximum possible 'h' i.e. gap
		while(gap<n/3)
			gap=3*gap +1;

		//We will start from the greatest gap and decrement the gap with each pass
		while(gap>=1){
			/*Since the left most element is 0, and the farthest element is separated
			by gap distance therefore that far element is at gap. After 
			the first comparison we will move the left most element by 1 and
			check it with another element at gap distance*/
			for(int i=gap;i<=n;i++)
			{
				/*this is the first far element from the left element, 
				considering the left most element is at zero, as the
				left most element shifts to right, this element will 
				also move to right since i increments..
				Basically this outer loop represents every pass starting
				from the left most element and incrementing it until 
				the entire element is sorted for this particular gap value
				*/
				int temp = a[i];
				int j = i;
				
				/*The element at a gap distance from its left counterpart
				is at i  and as long as there is a left counterpart to that
				left element, we will keep on going to the left*/
				
				/*FOR CONDITION : if gap =3 and j =2 that means that there is
				not enough distance between j and its left most element, because
				its left most element could be 0 and there is not enough
				gap between them*/
				for(j=i; j>=gap &&a[j-gap]>temp;j-=gap)
					a[j] = a[j-gap];

				/*At the end of the above for loop, j's value has become
				the left most element.*/
				a[j] = temp;

				/*Now we will increment i in order for next element in the array
				to compare itself with the element gap distance away on its
				right*/

			}
			gap = gap/3;
		}

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