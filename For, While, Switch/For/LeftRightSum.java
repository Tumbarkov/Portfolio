import java.util.Scanner;

public class LeftRightSum {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n= Integer.parseInt(scanner.nextLine());
        int sum=0;
        int sum1=0;
        for ( int i = 1; i<=n; i++) {
            int num= Integer.parseInt(scanner.nextLine());
            sum = sum+num;
        }
        for ( int i = 1; i<=n; i++) {
            int num1= Integer.parseInt(scanner.nextLine());
            sum1 = sum1+num1;
        }
        if(sum != sum1) {
            int diff = Math.abs(sum - sum1);
            System.out.printf("No, diff = %d",diff);
        } else {
            ;
            System.out.printf("Yes, sum = %d",sum);
        }
    }
}
