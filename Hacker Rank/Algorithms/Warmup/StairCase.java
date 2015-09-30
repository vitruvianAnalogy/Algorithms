import java.util.*;


public class StairCase {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sn = new Scanner(System.in);
        int height = sn.nextInt();
        
        for(int i = 1; i <= height; i++){
            for(int j = 1; j <= height-i; j++){
                System.out.print(" ");
            }
            for(int k = height-i; k < height; k++){
                System.out.print("#");
            }
            System.out.print("\n");
        }
        sn.close();
    }
}
