import java.util.Scanner;

public class Sbor {
    public static void main(String[] args) {

        Scanner scanner=new Scanner(System.in);


        int n= Integer.parseInt(scanner.nextLine());

        int max= Integer.MIN_VALUE;

        int numsum=0;

        for (int i = 0; i <n ; i++) {
            int num= Integer.parseInt(scanner.nextLine());

            if ( num>max){
                max=num;
            }

            numsum=numsum+num;

        }
        if(numsum-max==max){
            System.out.println("yes");
        } else {
            System.out.println("No");
        }
    }
}
//7 3 4 1 1 2 12//