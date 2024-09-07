import java.util.Scanner;

public class onTime {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int examHour= Integer.parseInt(scanner.nextLine());
        int examMin= Integer.parseInt(scanner.nextLine());
        int arrivalHour= Integer.parseInt(scanner.nextLine());
        int arrivalMin= Integer.parseInt(scanner.nextLine());

        int exam= examHour*60 + examMin;
        int arrival= arrivalHour*60+ arrivalMin;
        int diff= Math.abs(arrival-exam);

        if(arrival>exam){
            System.out.println("Late");
            if(diff<60){
                System.out.printf("%d minutes after the start",diff);
            } else {
                int hour = diff/60;
                int minutes= diff % 60;
                System.out.printf("%d:%02d hours after the start",hour,minutes);
            }

        } else if (diff<=30){
            System.out.println("On time");
            if(exam!=arrival) {
                System.out.printf("%d minutes before the start", diff);
            }
            } else {
                System.out.println("Early");
                if (diff < 60) {
                    System.out.printf("%d minutes before the start", diff);

                } else {
                    int hour = diff / 60;
                    int minutes = diff % 60;
                    System.out.printf("%d:%02d hours before the start", hour, minutes);
                }
            }
        }
    }

