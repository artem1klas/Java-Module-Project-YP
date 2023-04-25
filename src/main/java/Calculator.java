import java.util.ArrayList;
import java.util.regex.Pattern;

public class Calculator {
    private ArrayList<ProductAndPrice> bill = new ArrayList<>();
    private double total = 0;
    private final int numberPerson;
    public Calculator(int numberPerson) {
        this.numberPerson = numberPerson;
    }

    /*Метод add принимает на вход строку.
    Если входных данных валидны  преобразует строку в параметры,
    создает на их основе экземпляр класса ProductAndPrice и
    добавляет последний в массив bill; при успешном выполнении возвращает true.
    Если переданный в метод аргумент не валидный возвращает false*/
    public boolean add(String s){
        int lastSpace = s.lastIndexOf(" ");
        if (lastSpace == -1){
            return false;
        }
        String name = s.substring(0, lastSpace);
        String price = s.substring(lastSpace + 1);
        if(Pattern.matches("^(0|\\d+)[.]\\d\\d$", price.trim())){
            double i = Double.parseDouble(price);
            bill.add(new ProductAndPrice(name, i));
            total += i;
            return true;
        } else {
            return false;
        }
    }

    /* Метод выводит на экран данные класса Calculator, в соответсвии с заданным условием*/
    public void printBill(){
        StringBuilder sb = new StringBuilder("Добавленные товары:\n");
        for(int i = 0; i < bill.size(); i++){
            sb.append(bill.get(i).getName()).append(" ").append(bill.get(i).getPrice()).append("\n");
        }
        String average = String.format("%.2f", total/(double)numberPerson);
        sb.append("Каждый человек должен заплатить ").append(average).append(" ").append(declinationOfRub(total / (double) numberPerson));
        System.out.println(sb);
    }

    /*Метод возвращает слово "рубль" в склонении, соответсвующим целочисленной части
     переданному ему числа */
    public String declinationOfRub(double n){
        int num = (int) n;
        int preLastDigit = num % 100 / 10;
        if (preLastDigit == 1)
        {
            return "рублей";
        }
        switch (num % 10)
        {
            case 1:
                return "рубль";
            case 2:
            case 3:
            case 4:
                return "рубля";
            default:
                return "рублей";
        }
    }
}
