import java.util.Scanner;

public class GraduationImportant {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String name= scanner.nextLine();
        double wholemarks=0;
        int years=1;
        double average=0;
        double marks;
        int poor=0;

        while(years<=12) {

            if(poor>1){
                break;
            }

            marks=Double.parseDouble(scanner.nextLine());

            if(marks<4){
                poor++;
                continue;
            }

            wholemarks=wholemarks+marks;

            ++years;

        }
        if(poor>1){
            System.out.printf("%s has been excluded at %d grade",name,years);
        }else {

            average = wholemarks / 12;
            System.out.printf("%s graduated. Average grade: %.2f", name, average);
        }
    }
}
