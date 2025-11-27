import java.util.Scanner;

public class coffe {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] napitki = {"Еспресо☕", "Капучино☕", "Мляко с какао🥛🍫", "Чай🍵", "Топло мляко🥛"};
        double[] ceni = {1.20, 1.50, 2.00, 0.80, 1.00};
        Integer[] nomer = { 1, 2, 3, 4, 5 };

        System.out.println("=== ☕Кафе Машина☕ ===");
        System.out.println("Избери напитка :");
        for (int i = 0; i < napitki.length; i++)
            System.out.println(nomer[i] + ". " + napitki[i] + " --- " + ceni[i]);

        System.out.print("Въведи номер на напитката: ");
        int izbor = sc.nextInt();

        if (izbor < 1 && izbor > napitki.length) {
            System.out.println("Невалидна опция!❌");
            return;
        }

        double cena = ceni[izbor - 1];
        System.out.println("Избра: " + napitki[izbor - 1] + " цена: " + cena);

        System.out.print("Въведи сума🪙: ");
        double plashta = sc.nextDouble();

        if (plashta < cena) {
            System.out.println("Недостатъчна сума!🙁 Транзакцията е отказана.");
        } else {
            double resto = plashta - cena;
            System.out.printf("Напитката се приготвя…%nВашето ресто е: %.2f лв.%n", resto);
            System.out.println("Благодаря и приятно пиене!😊");
        }
    }
}
