import java.util.Scanner;

public class TimeConversion {
	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner sn = new Scanner(System.in);
		String line = sn.nextLine();
		//String line = args[0];
		String[] parts = line.split(":");
		int[] intParts = new int[parts.length];

		//Parse integer from string
		for(int i = 0; i<parts.length; i++){
			intParts[i] = Integer.parseInt(parts[i].substring(0,2));
		}
		String timeOfLife = parts[parts.length-1].substring(2);
		
		if(timeOfLife.equalsIgnoreCase("AM") && intParts[0]==12)
		{
			parts[0]="00";
			parts[2]=parts[2].substring(0,2);
		}
		if(timeOfLife.equalsIgnoreCase("PM"))
		{
			if(intParts[0]>=1 && intParts[0]<12){
				intParts[0]=intParts[0]+12;
				parts[0] = Integer.toString(intParts[0]);
			}
			System.out.println("Test");
		}
		if(parts[0]=="12 Noon")
		{
			System.out.println("12:00:00");
		}
		else
		{
			System.out.println(parts[0]+":"+parts[1]+":"+parts[2].substring(0,2));
		}
		sn.close();
	}
}
