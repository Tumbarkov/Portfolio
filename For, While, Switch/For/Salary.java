import java.util.Scanner;

public class Salary {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int salary = Integer.parseInt(scanner.nextLine());
        int fb = 0;
        int insta = 0;
        int reddit = 0;
        int finalsalary=0;

        for (int i = 1; i <= n; i++) {
            String website = scanner.nextLine();

            if (website.equals("Facebook")) {
                fb++;
            }
            if (website.equals("Instagram")) {
                insta++;
            }
            if (website.equals("Reddit")) {
                reddit++;
            }
            finalsalary=salary-(fb*150+insta*100+reddit*50);
        }


            if (finalsalary <= 0) {
                System.out.println("You have lost your salary.");

            } else {
                System.out.printf("%d",finalsalary);
            }

        }
    }

