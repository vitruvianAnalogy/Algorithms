/*In interpolation search, the interpolation is used to find an item near the
one being searched for, then linear search is ussed to find the exact item*/
import java.util.*;
public class InterpolationSearch{

		public static int search(int[] a, int element){
			int low = 0;
			int high = a.length-1;
			int mid;

			while(a[low]<element && a[high]>element){
				if(a[high]-a[low]==0)
					return -1;

				/*The middle will be greater than low . How much greater?
				The high-low will tell how many observations are between them
				The a[high]-a[low] will tell what is the difference between
				the observations VALUE. So, their ratio would mean, how
				much VALUE is spread between those two observations.Multiply
				that ratio to difference between low and element, so that
				we know how many observations far is element*/
				mid = low + (element-a[low])*(high-low)/(a[high]-a[low]);

				//We make mid as the lower value, kind of like binary search
				if(a[mid]<element){
					low = mid + 1;
				}
				else if(a[mid]>element)
					high = mid - 1;
				else
					return mid;
			}

			if(a[low]==element)
				return low;
			else if (a[high]==element)
				return high;
			else
				return -1;
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
		int temp = search(a,element);

		if(temp ==-1){
			System.out.println("Couldn't find the element");
		}
		else
		{
			temp++;
			System.out.println("Element at "+ (temp)+" position");
		}
			
	}
}