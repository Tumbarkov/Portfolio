import java.util.Scanner;

public class Oscars {
    public static void main(String[] args) {

        Scanner scanner= new Scanner(System.in);

        String actorname= scanner.nextLine();
        double points=Double.parseDouble(scanner.nextLine());
        int n=Integer.parseInt(scanner.nextLine());
        double judgepoitsall=points;

        for (int i = 1; i <= n; i++) {
            String judge= scanner.nextLine();
            double judgepoints=Double.parseDouble(scanner.nextLine());
            judgepoitsall+= (judge.length()*judgepoints)/2;

         if( judgepoitsall>=1250.5) {
            System.out.printf("Congratulations, %s got a nominee for leading role with %.1f!", actorname, judgepoitsall);
            break;
        }

         }
        if(judgepoitsall<1250.5) {
            System.out.printf("Sorry, %s you need %.1f more!",actorname,Math.abs(judgepoitsall-1250.5));
        }




    }
}
