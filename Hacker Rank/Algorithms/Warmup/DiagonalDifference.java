import java.util.*;

/* Solution to HackerRank Diagonal Difference problem*/
class DiagonalDifference
{
	public static void main (String[] args)
	{
		Scanner sn = new Scanner (System.in);
		int n = sn.nextInt();
		int sumLeft = 0;
		int sumRight = 0;
        for(int i=1;i<=n;i++){
			for(int j=1;j<=n;j++){
				if(i==j && i==(n+1)-j){
					int temp = sn.nextInt();
					sumLeft = sumLeft+temp;
					sumRight = sumRight+temp;
				}
				else if(i==j){
					int temp = sn.nextInt();
					sumLeft = sumLeft+temp;
				}
				else if(i==(n+1)-j){
					int temp = sn.nextInt();
					sumRight = sumRight+temp;
				}
				else
					sn.nextInt();
			}
		}

		System.out.println(Math.abs(sumRight-sumLeft));
		
		sn.close();
	}
}
