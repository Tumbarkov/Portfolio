import java.util.Scanner;

public class NewHouse {
    public static void main(String[] args) {

        Scanner scanner=new Scanner(System.in);
        double price=0;
        String type= scanner.nextLine();
        int flowers= Integer.parseInt(scanner.nextLine());
        int budget= Integer.parseInt(scanner.nextLine());

        switch (type) {
            case "Roses":
                price= flowers * 5;
                if(flowers>80){
                    price= price*0.9;
                }
                break;
            case "Dahlias":
                price= flowers * 3.8;
                if(flowers>90) {
                    price = price * 0.85;
                }
                break;
            case "Tulips":
                price= flowers * 2.8;
                if(flowers>80) {
                    price = price * 0.85;
                }
                break;
            case "Narcissus":
                price= flowers * 3;
                if(flowers<120) {
                    price = price * 1.15;
                }
                    break;
                case "Gladiolus":
                        price = flowers * 2.5;
                        if (flowers < 80) {
                            price = price * 1.20;
                        }
                            break;
                }
                double diff = Math.abs(budget-price);
        if (price<=budget){
            System.out.printf("Hey, you have a great garden with %d %s and %.2f leva left.",flowers,type,diff);
        } else{
            System.out.printf("Not enough money, you need %.2f leva more.",diff);
        }
    }
}
