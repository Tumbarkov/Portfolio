import java.util.Scanner;

public class Pochivka {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        double money=Double.parseDouble(scanner.nextLine());
        double nalichni=Double.parseDouble(scanner.nextLine());
        int spend=0;
        int days=0;
        boolean a=false;

        while(nalichni<money&&spend<5) {
            String action = scanner.nextLine();
            double sum = Double.parseDouble(scanner.nextLine());
            days++;
            if (action.equals("spend")) {
                nalichni = nalichni - sum;
                spend++;
                if(nalichni<0){
                    nalichni=0;
                }
            }
            if(action.equals("save")){
                nalichni= nalichni+sum;
                spend=0;
                if(nalichni>=money){
                    a=true;
                    break;
                }
            }

        }
        if(a){
            System.out.printf("You saved the money for %d days.",days);
        } else{
            System.out.printf("You can't save the money.%n%d",days);
        }


    }
}
