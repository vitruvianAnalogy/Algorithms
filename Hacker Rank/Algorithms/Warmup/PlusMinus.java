import java.util.*;


public class PlusMinus {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sn = new Scanner(System.in);
        float total = (float)sn.nextInt();
        int sumPos = 0;
        int sumNeg = 0;
        int sumZero = 0;
        for(int i = 1; i<=total; i++){
            int temp = sn.nextInt();
            if(temp > 0)
                sumPos = sumPos + 1;
            else if(temp<0)
                sumNeg = sumNeg + 1;
            else
                sumZero = sumZero + 1;                
        }
        System.out.println(sumPos/total);
        System.out.println(sumNeg/total);
        System.out.println(sumZero/total);
        sn.close();

    }
}
