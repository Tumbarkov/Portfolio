import java.sql.SQLOutput;
import java.util.Scanner;

public class MinMax {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int num= Integer.parseInt(scanner.nextLine());
        int max=Integer.MIN_VALUE;
        int min=Integer.MAX_VALUE;

        for ( int i = 1; i <= num; i++) {
            int currentnum = Integer.parseInt(scanner.nextLine());

            if(currentnum>max){
                max=currentnum;

            } if(currentnum<min){
                min=currentnum;

            }

        }
        System.out.printf("Max number: %d%n",max);
        System.out.printf("Min number: %d%n",min);

    }
}
