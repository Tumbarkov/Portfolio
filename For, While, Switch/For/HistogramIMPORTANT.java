import java.util.Scanner;

public class HistogramIMPORTANT {
    public static void main(String[] args) {

        Scanner scanner=new Scanner(System.in);

        int n=Integer.parseInt(scanner.nextLine());

        int p1= 0;
        int p2= 0;
        int p3= 0;
        int p4= 0;
        int p5= 0;

        for (int i = 1; i <= n; i++) {

            int num= Integer.parseInt(scanner.nextLine());

            if( num < 200) {
                p1++;
            } else if( num<=399){
                p2++;
            } else if( num<=599){
                p3++;
            } else if( num<=799){
                p4++;
            } else if( num>=800){
                p5++;
            }

        }
            double p1percent= ((p1*1.0) /n)*100;
            double p2percent= ((p2*1.0) /n)*100;
            double p3percent= ((p3*1.0) /n)*100;
            double p4percent= ((p4*1.0) /n)*100;
            double p5percent= ((p5*1.0) /n)*100;

        System.out.printf("%.2f%% %n ",p1percent);
        System.out.printf("%.2f%% %n ",p2percent);
        System.out.printf("%.2f%% %n ",p3percent);
        System.out.printf("%.2f%% %n ",p4percent);
        System.out.printf("%.2f%% %n ",p5percent);

    }
}
