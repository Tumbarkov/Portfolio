import java.util.Scanner;

public class ValidNumbers {
    public static void main(String[] args) {
        Scanner scanner= new Scanner(System.in);

        double num= Double.parseDouble(scanner.nextLine());
        boolean truenum= (num>=100 && num<=200  || num==0);
        if (!truenum){
            System.out.println("invalid");
        }
    }
}
