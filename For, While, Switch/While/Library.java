import java.util.Scanner;

public class Library {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String book = scanner.nextLine();
        String input = scanner.nextLine();
        int num = 0;

        boolean isfound = false;

        while (!input.equals("No More Books")) {

            if(input.equals(book)){
                isfound=true;
                break;
            }
                input=scanner.nextLine();
                num++;

        }
        if(isfound){
            System.out.printf("You checked %d books and found it.",num);
        } else {
            System.out.println("The book you search is not here!");
            System.out.printf("You checked %d books.%n",num);
        }
    }
}
/*
Troy
Stronger
Life Style
Troy
*/
