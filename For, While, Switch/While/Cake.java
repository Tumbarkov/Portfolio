import java.util.Scanner;

public class Cake {
    public static void main(String[] args) {

        Scanner scanner=new Scanner(System.in);

        int a=Integer.parseInt(scanner.nextLine());
        int b=Integer.parseInt(scanner.nextLine());
        String cake= scanner.nextLine();
        int whole= b*a;

        boolean t= true;

        while(!cake.equals("STOP")) {

            int pieces= Integer.parseInt(cake);
            whole-=pieces;
            if(whole<=0){
                t=false;
                break;
            }
            cake= scanner.nextLine();
        }
        if(t) {
            System.out.printf("%d pieces are left.", whole);
        } else

        System.out.printf("No more cake left! You need %d pieces more.",Math.abs(whole));


    }
}
