import java.util.*;

public class CaesarCipher {
	public static void main(String[] args){

		Scanner sn = new Scanner(System.in);
		int length = sn.nextInt();
		sn.nextLine();
		String letters = sn.nextLine();
		int key = sn.nextInt();
		key = key%26;
		
		char[] alphabets = new char[123];
		for(int i=0; i<123; i++){
			alphabets[i] = (char)i;
		}

		char[] lettersChar = letters.toCharArray();
		for(int i = 0; i<length; i++){
			if (lettersChar[i]>=65 && lettersChar[i]<=90){
				lettersChar[i]=(char)(lettersChar[i]+key);
				if(lettersChar[i]>90){
					lettersChar[i] = (char)(64 + lettersChar[i]-90);
				}					
				System.out.print(lettersChar[i]);
			}
			else if (lettersChar[i]>=97 && lettersChar[i]<=122){
				lettersChar[i]=(char)(lettersChar[i]+key);
				if(lettersChar[i]>122){
					lettersChar[i] = (char)(96 + lettersChar[i] - 122);
				}
				System.out.print(lettersChar[i]);
			}
			else if(lettersChar[i]<=65 || lettersChar[i]>=90|| lettersChar[i]<=97 || lettersChar[i]>=122)
				System.out.print((char)lettersChar[i]);

		}
		sn.close();
	}
}