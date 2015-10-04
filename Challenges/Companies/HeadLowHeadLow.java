import java.util.*;

public class HeadLowHeadLow{

	public static void sort(int[] a){
		for(int i=0;i<a.length-1;i++){
			for(int j=i+1;j<a.length;j++){
				if(a[i]<a[j]){
					int temp = a[i];
					a[i] = a[j];
					a[j] = temp;
				}
			}
		}
	}
	public static void main(String[] args){

		Scanner sn = new Scanner(System.in);
		System.out.println("Enter size");
		int size = sn.nextInt();
		System.out.println("Enter array");

		int[] a = new int[size];

		for(int i = 0; i<size;i++){
			a[i] = sn.nextInt();
		}

		sort(a);

		int middle = 0;
		middle = size/2;
					
		int counter = 0;
		int[] temp = new int[size];
		
		for(int i=0;i<size;i+=2){
			temp[i] = a[i/2];
		}
		for(int i=1;i<=middle;i++){
			temp[2*i-1] = a[size-i];
		}

		System.out.println("-----------------");
		for(int i =0;i<size;i++){
			System.out.println(temp[i]);
		}
	}
}