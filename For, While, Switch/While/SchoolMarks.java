import java.util.Scanner;

public class SchoolMarks {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        int badmarks= Integer.parseInt(scanner.nextLine());

        int badmarkcount=0;

        double allmarks=0;

        double average;

        int trueupr=0;

        String last="";

        boolean a= false;

        while(badmarkcount<badmarks) {

            String upr=scanner.nextLine();

            if(upr.equals("Enough")){
                a=true;
                break;
            }

            int mark=Integer.parseInt(scanner.nextLine());

            if(mark<=4){
                badmarkcount++;
            }
            allmarks+=mark;

            trueupr++;
            last=upr;
        }
        average=allmarks/trueupr;
        if(a){

            System.out.printf("Average score: %.2f%n",average);
            System.out.printf("Number of problems: %d%n",trueupr);
            System.out.printf("Last problem: %s%n",last);
        } else{
            System.out.printf("You need a break, %d poor grades.%n",badmarkcount);
        }
    }
}
