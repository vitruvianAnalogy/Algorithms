import java.util.*;

public class CommonDescending
{

	public static void sort(int[] a){

		for(int i=0;i<a.length-1;i++){
			for(int j=i+1; j<a.length;j++){
				if(a[i]<a[j])
					{
					int temp = a[i];
					a[i]=a[j];
					a[j]=temp;
					}
			}
		}

	}

	public static void main(String[] args){

		Scanner sn = new Scanner(System.in);
		
		System.out.println("Enter size of array 1");
		int size1 = sn.nextInt();
		System.out.println("Enter size of array 2");
		int size2 = sn.nextInt();

		int[] array1 = new int[size1];
		int[] array2 = new int[size2];

		System.out.println("Enter elements of array 1");
		
		for(int i = 0; i <size1; i++){
			array1[i] = sn.nextInt();
		}

		System.out.println("Enter elements of array 2");
		
		for(int i = 0; i <size2; i++){
			array2[i] = sn.nextInt();
		}

		sort(array1);
		sort(array2);

		int theSize = size1>size2?size1:size2;

		for(int i = 0 ; i < size1; i++){
			for(int j = 0; j < size2; j++){
				if(array1[i]==array2[j]){
					System.out.println(array1[i]);
					break;
				}
			}
		}

	}
}