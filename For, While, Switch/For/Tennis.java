import java.util.Scanner;

public class Tennis {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int tournaments= Integer.parseInt(scanner.nextLine());
        int startingpoints=Integer.parseInt(scanner.nextLine());
        int countW=0;
        int finalPoints=0;

        for (int i = 0; i < tournaments; i++) {
            String type= scanner.nextLine();
            if(type.equals("W")) {
                countW++;
                finalPoints+= 2000;
            } else if (type.equals("F") ) {

                finalPoints+=1200;
            } else if (type.equals("SF")) {

                finalPoints+=720;
            }

        }
        int average= finalPoints/tournaments;
        double percent= (countW*1.0/tournaments)*100;

        System.out.printf("Final points: %d%n",finalPoints+startingpoints);
        System.out.printf("Average points: %d%n",average);
        System.out.printf("%.2f%%",percent);
    }
}
