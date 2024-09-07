import java.util.Scanner;

public class Pass {
    public static void main(String[] args) {
        Scanner scanner= new Scanner(System.in);
        String username= scanner.nextLine();
        String pass= scanner.nextLine();
        while(true) {
            String logPass=scanner.nextLine();
            if(logPass.equals(pass)) {
                System.out.printf("Welcome %s!",username);
                break;
            }
        }
    }
}
