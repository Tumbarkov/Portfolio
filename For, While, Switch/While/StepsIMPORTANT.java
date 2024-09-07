import java.util.Scanner;

public class StepsIMPORTANT {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int allsteps=0;

        String input=scanner.nextLine();
        boolean a=false;

        while(!input.equals("Going home")) {
            int steps=Integer.parseInt(input);
            allsteps+=steps;
            if(allsteps>=10000){
                a=true;
                break;
            }
            input=scanner.nextLine();
        }
        if(input.equals("Going home")) {
            int homesteps = Integer.parseInt(scanner.nextLine());
            allsteps += homesteps;
            if (allsteps >= 10000) {
                a = true;
            }
        }

        if(a) {
            System.out.println("Goal reached! Good job!");
            System.out.printf("%d steps over the goal!",allsteps-10000);
        } else {
            System.out.printf("%d more steps to reach goal.",10000-allsteps);
        }
    }
}
