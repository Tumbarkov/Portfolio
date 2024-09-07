import java.util.Scanner;

public class SumNum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num=Integer.parseInt(scanner.nextLine());
        int sumnum=0;
        while(sumnum<num){
            int current=Integer.parseInt(scanner.nextLine());
            sumnum+=current;
        }
        System.out.println(sumnum);
    }
}
