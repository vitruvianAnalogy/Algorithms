import java.util.*;

public class MakeItAnagram{
	public static void main(String[] args){
		Scanner sn = new Scanner(System.in);
		String string1, string2;
		System.out.print("Enter String 1" );
		string1 = sn.nextLine();
		System.out.print("Enter String 2" );
		string2 = sn.nextLine();
		
		if(string1.length()<1 || string2.length()<1 || string1.length()>10000 || string2.length()>10000){
			System.out.println("Invalid Strings");		
			return;
		}

		int numberOfDeletions = 0;
		string1 = string1.toLowerCase();
		string2 = string2.toLowerCase();

		int[] frequency1  = new int[26];
		int[] frequency2  = new int[26];

		/*frequency of string1 characters*/
		for(int i = 0; i<string1.length(); i++){
			char c = string1.charAt(i);
			frequency1[(int)c - 97]++;
		}

		/*frequency of string2 characters*/
		for(int i = 0; i<string2.length(); i++){
			char c = string2.charAt(i);
			frequency2[(int)c - 97]++;
		}

		for(int i = 0; i<26; i++){
			int difference = Math.abs(frequency1[i]-frequency2[i]);
			if(difference!=0){
				numberOfDeletions= numberOfDeletions + difference;
			}
		}

		System.out.println(numberOfDeletions);
		
	}
}