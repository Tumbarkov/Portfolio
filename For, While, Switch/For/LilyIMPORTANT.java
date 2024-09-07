import java.util.Scanner;

public class LilyIMPORTANT {
    public static void main(String[] args) {

        Scanner scanner= new Scanner(System.in);


        int age=Integer.parseInt(scanner.nextLine());
        double washing=Double.parseDouble(scanner.nextLine());
        double toyprice=Double.parseDouble(scanner.nextLine());
        double sum=0;
        int toys=0;
        double toysmoney;

        for (int currentage = 1; currentage <= age; currentage++) {
            if(currentage%2==0) {
                sum= sum+(currentage * 5 -1);
            } else {
                toys++;
            }
        }
        toysmoney= toys*toyprice;
        double wholesum=sum+toysmoney;
        double diff= Math.abs(wholesum-washing);
        if(wholesum>=washing){
            System.out.printf("Yes! %.2f",diff);
        } else {
            System.out.printf("No! %.2f",diff);
        }

    }
}
