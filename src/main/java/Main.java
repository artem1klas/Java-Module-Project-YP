import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberPerson;

        System.out.println("На скольких человек необходимо разделить счёт?");
        while (true) {
            if(scanner.hasNextInt()){
                int a = scanner.nextInt();
                if(a <= 1){
                    System.out.println("Введите корректное количество человек.");
                } else {
                    numberPerson = a;
                    break;
                }
            } else {
                System.out.println("Введите корректное количество человек.");
                scanner.next();
            }
        }

        Calculator calculator = new Calculator(numberPerson);

        System.out.println("Введите через пробел название товара и его стоимость.\nCтоимость в формате 'рубли.копейки'");
        while (true) {
            String s = scanner.nextLine();
            if (s.equalsIgnoreCase("завершить")) {
                break;
            }
            if (calculator.add(s)) {
                System.out.println("Товар успешно добавлен в корзину.\nЖелаете продолжить?\nДля расчета введите слово 'завершить'.");
            } else {
                System.out.println("Введены некорректные данные, повторите попытку");
            }
        }
        scanner.close();
        calculator.printBill();
    }
}