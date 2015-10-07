import java.util.*;

public class Upvotes{

	public static void sortWithoutSwap(int[] window){
		int nonDecreasing = 0;
		int nonIncreasing = 0;
		for(int i=0;i<window.length;i++){
			for(int j =i+1;j<window.length;j++){
				if(window[i]<window[j])
					nonDecreasing++;
				else if(window[i]>window[j])
					nonIncreasing++;
				else if (window[i]==window[j]){
					nonDecreasing++;
					nonIncreasing++;
				}
			}
		}
		System.out.println(nonDecreasing-nonIncreasing);
	}

	public static void main(String[] args){
		Scanner sn = new Scanner(System.in);
		int n = sn.nextInt();
		int k = sn.nextInt();

		int[] elements = new int[n];
		int[][] window = new int[n-k+1][k];

		System.out.println("Enter elements");

		for(int i = 0 ; i<n ; i++){
			elements[i] = sn.nextInt();
		}

		int counter = 0;

		for(int i = 0; i<n-k+1; i++){
			for(int j = 0 ; j<k; j++){
				window[i][j] = elements[counter];
				counter++;
			}
			counter = i+1;
		}

		for(int i = 0; i<n-k+1; i++)
			sortWithoutSwap(window[i]);

/*		int nonIncreasing = 0;
		int nonDecreasing = 0;
		for(int i = 0; i<n-k+1; i++){
			for(int j = 1 ; j<k; j++){
				if(window[i][j-1]<=window[i][j])
					nonDecreasing++;
				else if(window[i][j-1]>=window[i][j])
					nonIncreasing++;
			}
			System.out.println(nonDecreasing - nonIncreasing);
			nonIncreasing = 0;
			nonDecreasing = 0;
		}*/


	}

}