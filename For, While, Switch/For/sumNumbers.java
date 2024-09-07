import java.util.Scanner;

public class sumNumbers {
    public static void main(String[] args) {
        Scanner scanner= new Scanner(System.in);
        int num= Integer.parseInt(scanner.nextLine());
        int sum=0;

        for ( int i = 1; i <= num; i++) {
             int currentnum = Integer.parseInt(scanner.nextLine());
            sum=sum+currentnum;
        }
        System.out.println(sum);
    }
}
