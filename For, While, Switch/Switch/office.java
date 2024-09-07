import java.util.Scanner;

public class office {
    public static void main(String[] args) {

        Scanner scanner= new Scanner(System.in);

        int hour= Integer.parseInt(scanner.nextLine());

        String day= scanner.next();

        boolean dayOfWeek = day.equals("Monday") ||
                day.equals("Tuesday") ||
                day.equals("Wednesday") ||
                day.equals("Thursday") ||
                day.equals("Friday") ||
                day.equals("Saturday");
        boolean workHours = hour>=10 && hour<=18;
        if (dayOfWeek && workHours){
            System.out.println("open");
        }
        else {
            System.out.println("closed");
        }
        }
    }

